package com.shop.rest.persistence.hibernate

import org.springframework.test.context.{TestExecutionListeners, ContextConfiguration}
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.transaction.TransactionalTestExecutionListener
import org.springframework.test.context.support.{DirtiesContextTestExecutionListener, DependencyInjectionTestExecutionListener}
import org.springframework.transaction.annotation.Transactional
import org.springframework.beans.factory.annotation.Autowired
import com.shop.rest.domain.{Customer, Order}
import com.shop.rest.persistence.{CustomerDAO, OrderDAO}
import org.junit.{Test, Before}
import java.util
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests
import java.util.Date

@ContextConfiguration
@DirtiesContext
@TestExecutionListeners(Array(classOf[TransactionalTestExecutionListener], classOf[DependencyInjectionTestExecutionListener], classOf[DirtiesContextTestExecutionListener]))
@Transactional
class OrderDaoHibernateTest extends AbstractTransactionalJUnit4SpringContextTests{
  @Autowired
  val dao: OrderDAO = null

  @Autowired
  val customerDao: CustomerDAO = null

  val customer1 = new Customer("London", "UK", "tom@cruise.com", "Tom", "Cruise", "Warks", "High Street", "B11")
  val customer2 = new Customer("Coventry", "UK", "Frank@Sinatra.com", "Frank", "Sinatra", "West Midlands", "High Street", "CV8")
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
    val all: util.List[Order] = dao.fetchAll()
    assert(all.size()==3)
  }

  @Test
  def testFetchAllOrdersForCustomer(){
    val orders1: util.List[Order] = dao.fetchFor(customer1)
    assert(orders1.size()==2)
    val orders2: util.List[Order] = dao.fetchFor(customer2)
    assert(orders2.size()==1)
  }

  @Test
  def testGet(){
    val order: Order = dao.get(order1.getId)
    assert(order==order1)
  }
}
