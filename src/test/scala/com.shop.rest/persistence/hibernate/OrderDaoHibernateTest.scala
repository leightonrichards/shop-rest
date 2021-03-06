package com.shop.rest.persistence.hibernate

import org.springframework.test.context.{TestExecutionListeners, ContextConfiguration}
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.transaction.TransactionalTestExecutionListener
import org.springframework.test.context.support.{DirtiesContextTestExecutionListener, DependencyInjectionTestExecutionListener}
import org.springframework.transaction.annotation.Transactional
import org.springframework.beans.factory.annotation.Autowired
import com.shop.rest.domain.{Address, Customer, Order}
import com.shop.rest.persistence.{CustomerDAO, OrderDAO}
import org.junit.{Test, Before}
import java.util
import org.springframework.test.context.junit4.{SpringJUnit4ClassRunner, AbstractTransactionalJUnit4SpringContextTests}
import java.util.Date
import scala.collection.mutable
import com.shop.rest.service.AddressService
import org.junit.runner.RunWith

@ContextConfiguration
@DirtiesContext
@TestExecutionListeners(Array(classOf[TransactionalTestExecutionListener], classOf[DependencyInjectionTestExecutionListener], classOf[DirtiesContextTestExecutionListener]))
@Transactional
@RunWith(classOf[SpringJUnit4ClassRunner])
class OrderDaoHibernateTest{
  @Autowired
  val dao: OrderDAO = null

  @Autowired
  val customerDao: CustomerDAO = null

  @Autowired
  val addressService: AddressService = null

  val address1 = new Address("London", "UK", "Warks", "High Street", "B11")
  val address2 = new Address("Birmingham", "UK", "West Mids", "Regent Street", "B11")
  val customer1 = new Customer("tom@cruise.com", "Tom", "Cruise", "tom.cruise","password",address1)
  val customer2 = new Customer("Frank@Sinatra.com", "Frank", "Sinatra", "frank.sinatra","password",address2)
  val order1 = new Order(20.00f,new Date(),customer1)
  val order2 = new Order(30.00f,new Date(),customer1)
  val order3 = new Order(40.00f,new Date(),customer2)


  @Before
  def setUpData(){
    customerDao.add(customer1)
    customerDao.add(customer2)
    dao.add(order1)
    dao.add(order2)
    dao.add(order3)
  }

  @Test
  def testFetchAll(){
    val all: mutable.Buffer[Order] = dao.fetchAll()
    assert(all.length==3)
  }

  @Test
  def testFetchAllOrdersForCustomer(){
    val orders1: mutable.Buffer[Order] = dao.fetchFor(customer1)
    assert(orders1.length==2)
    val orders2: mutable.Buffer[Order] = dao.fetchFor(customer2)
    assert(orders2.length==1)
  }

  @Test
  def testGet(){
    val order: Order = dao.get(order1.getId).get
    assert(order==order1)
  }
}
