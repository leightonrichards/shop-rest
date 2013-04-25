package com.shop.rest.persistence

import org.springframework.test.context.{TestExecutionListeners, ContextConfiguration}
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.transaction.TransactionalTestExecutionListener
import org.springframework.test.context.support.{DirtiesContextTestExecutionListener, DependencyInjectionTestExecutionListener}
import org.springframework.transaction.annotation.Transactional
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests
import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired
import com.shop.rest.domain.Customer

@ContextConfiguration
@DirtiesContext
@TestExecutionListeners(Array(classOf[TransactionalTestExecutionListener],classOf[DependencyInjectionTestExecutionListener], classOf[DirtiesContextTestExecutionListener]))
@Transactional
class CustomerDaoHibernateTest  extends AbstractTransactionalJUnit4SpringContextTests
{
  @Autowired
  var customerDao: CustomerDAO = null



  @Test
  def createRowsTest()
  {
    val oldRows: Int = countRowsInTable("customer")
    val customerIn: Customer = insertACustomer("London","UK","tom@cruise.com","Tom","Cruise","Warks","High Street","B11")
    val newRows: Int = countRowsInTable("customer")
    assert(newRows == oldRows+1)
    val customerOut = customerDao.get(customerIn.id)
    assert(customerIn==customerOut)
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
}
