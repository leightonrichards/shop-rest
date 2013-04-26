package com.shop.rest.persistence.hibernate

import org.springframework.test.context.{TestExecutionListeners, ContextConfiguration}
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.transaction.TransactionalTestExecutionListener
import org.springframework.test.context.support.{DirtiesContextTestExecutionListener, DependencyInjectionTestExecutionListener}
import org.springframework.transaction.annotation.Transactional
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests
import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired
import com.shop.rest.domain.Customer
import com.shop.rest.persistence.CustomerDAO

@ContextConfiguration
@DirtiesContext
@TestExecutionListeners(Array(classOf[TransactionalTestExecutionListener],classOf[DependencyInjectionTestExecutionListener], classOf[DirtiesContextTestExecutionListener]))
@Transactional
class CustomerDaoHibernateTest  extends AbstractTransactionalJUnit4SpringContextTests
{
  @Autowired
  var customerDao: CustomerDAO = null

  val fixture: Fixture = new Fixture()

  @Test
  def addCustomerTest()
  {
    fixture.givenTheDepenciesAreMocked()
    fixture.whenACustomerIsAdded()
    fixture.thenTheRowCountIncreases()
  }

  @Test
  def getCustomerTest()
  {
    fixture.givenTheDepenciesAreMocked()
    fixture.whenACustomerIsAdded()
    fixture.thenGetCustomerFetchesTheCustomer()
  }

  @Test
  def deleteCustomerTest()
  {
    fixture.givenTheDepenciesAreMocked()
    fixture.whenACustomerIsAdded()
    fixture.whenTheCustomerIsDeleted()
    fixture.theTheRowCountDecreases()
    fixture.andGetCustomerReturnsNull()
  }

  class Fixture
  {
    var oldRows: Int = -1
    var customerIn: Customer = new Customer
    var newRows: Int = -1

    def givenTheDepenciesAreMocked()
    {

    }

    def whenACustomerIsAdded()
    {
      oldRows = countRowsInTable("customer")
      customerIn  = insertACustomer("London","UK","tom@cruise.com","Tom","Cruise","Warks","High Street","B11")
      newRows = countRowsInTable("customer")
    }

    private def insertACustomer(city: String, country: String, email: String, firstName: String, lastName: String, state: String, street: String, zip: String) =
    {
      val customer: Customer = new Customer
      customer.setCity(city)
      customer.setCountry(country)
      customer.setEmail(email)
      customer.setFirstName(firstName)
      customer.setLastName(lastName)
      customer.setState(state)
      customer.setStreet(street)
      customer.setZip(zip)
      customerDao.add(customer)
      customer
    }

    def thenTheRowCountIncreases()
    {
      assert(newRows == oldRows+1)
    }

    def thenGetCustomerFetchesTheCustomer()
    {
      val customerOut = customerDao.get(customerIn.id)
      assert(customerIn==customerOut)
    }

    def whenTheCustomerIsDeleted()
    {
      oldRows = countRowsInTable("customer")
      customerDao.delete(customerIn)
      newRows = countRowsInTable("customer")
    }

    def theTheRowCountDecreases()
    {
      assert(newRows == oldRows-1)
    }

    def andGetCustomerReturnsNull()
    {
      val customerOut: Customer = customerDao.get(customerIn.id)
      assert(customerOut==null)
    }
  }
}
