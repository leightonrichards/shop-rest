package com.shop.rest.persistence.hibernate

import org.springframework.test.context.{TestExecutionListeners, ContextConfiguration}
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.transaction.TransactionalTestExecutionListener
import org.springframework.test.context.support.{DirtiesContextTestExecutionListener, DependencyInjectionTestExecutionListener}
import org.springframework.transaction.annotation.Transactional
import org.springframework.beans.factory.annotation.Autowired
import com.shop.rest.domain.Customer
import com.shop.rest.persistence.CustomerDAO
import org.junit.{Test, Before}
import java.util
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests
import com.shop.rest.service.CustomerService

@ContextConfiguration
@DirtiesContext
@TestExecutionListeners(Array(classOf[TransactionalTestExecutionListener], classOf[DependencyInjectionTestExecutionListener], classOf[DirtiesContextTestExecutionListener]))
@Transactional
class CustomerDaoHibernateTest extends AbstractTransactionalJUnit4SpringContextTests{
  @Autowired
  val dao: CustomerService = null

  val customer1 = new Customer("London", "UK", "tom@cruise.com", "Tom", "Cruise", "Warks", "High Street", "B11")
  val customer2 = new Customer("Coventry", "UK", "Frank@Sinatra.com", "Frank", "Sinatra", "West Midlands", "High Street", "CV8")
  var id1: Int = customer1.getId
  var id2: Int = customer2.getId

  @Before
  def setUpData(){
    dao.add(customer1)
    dao.add(customer2)
    id1=customer1.getId
    id2=customer2.getId
  }

  @Test
  def testFetchAll(){
    assert(dao.fetchAll().length==2)
  }

  @Test
  def testGet(){
    val customer: Customer = dao.get(customer1.getId)
    assert(customer==customer1)
  }

  @Test
  def testFetchByName(){
    val customers: List[Customer] = dao.fetchByEmail("tom@cruise.com")
    assert(customers.head.getFirst_name=="Tom")
  }
}
