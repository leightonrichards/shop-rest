package com.shop.rest.persistence.hibernate

import org.springframework.test.context.{TestExecutionListeners, ContextConfiguration}
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.transaction.TransactionalTestExecutionListener
import org.springframework.test.context.support.{DirtiesContextTestExecutionListener, DependencyInjectionTestExecutionListener}
import org.springframework.transaction.annotation.Transactional
import org.springframework.beans.factory.annotation.Autowired
import com.shop.rest.domain.{Address, Customer}
import org.junit.{Test, Before}
import org.springframework.test.context.junit4.{SpringJUnit4ClassRunner, AbstractTransactionalJUnit4SpringContextTests}
import com.shop.rest.service.{AddressService, CustomerService}
import scala.collection.mutable
import org.junit.runner.RunWith

@ContextConfiguration
@DirtiesContext
@TestExecutionListeners(Array(classOf[TransactionalTestExecutionListener], classOf[DependencyInjectionTestExecutionListener], classOf[DirtiesContextTestExecutionListener]))
@Transactional
@RunWith(classOf[SpringJUnit4ClassRunner])
class CustomerDaoHibernateTest(){

  @Autowired val service: CustomerService = null
  @Autowired val addressService: AddressService = null

  val address1 = new Address("London", "UK", "Warks", "High Street", "B11")
  val address2 = new Address("Birmingham", "UK", "West Mids", "Regent Street", "B11")
  val customer1 = new Customer("tom@cruise.com", "Tom", "Cruise", "tom.cruise","password",address1)
  val customer2 = new Customer("Frank@Sinatra.com", "Frank", "Sinatra", "frank.sinatra","password",address2)

  @Before
  def setUpData(){
    addressService.add(address1)
    addressService.add(address2)
    service.add(customer1)
    service.add(customer2)
  }

  @Test
  def testFetchAll(){
    assert(service.fetchAll().length==2)
  }

  @Test
  def testGet(){
    val customer: Customer = service.get(customer1.getId).get
    assert(customer==customer1)
  }

  @Test
  def testFetchFor(){
    val customers: mutable.Buffer[Customer] = service.fetchFor("tom@cruise.com")
    assert(customers.head==customer1)
  }

  @Test
  def testFetchByName(){
    val customers: mutable.Buffer[Customer] = service.fetchFor("tom@cruise.com")
    val cust: Customer = customers.head
    assert(cust.getFirstname=="Tom")
    assert(cust.getAddress.getCity=="London")
  }
}
