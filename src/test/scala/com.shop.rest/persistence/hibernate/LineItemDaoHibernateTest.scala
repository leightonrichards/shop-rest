package com.shop.rest.persistence.hibernate

import org.springframework.test.context.{TestExecutionListeners, ContextConfiguration}
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.transaction.TransactionalTestExecutionListener
import org.springframework.test.context.support.{DirtiesContextTestExecutionListener, DependencyInjectionTestExecutionListener}
import org.springframework.transaction.annotation.Transactional
import org.springframework.beans.factory.annotation.Autowired
import com.shop.rest.domain.{LineItem, Order, Customer, Product}
import com.shop.rest.persistence._
import org.junit.{Test, Before}
import java.util
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests
import java.util.Date

@ContextConfiguration
@DirtiesContext
@TestExecutionListeners(Array(classOf[TransactionalTestExecutionListener], classOf[DependencyInjectionTestExecutionListener], classOf[DirtiesContextTestExecutionListener]))
@Transactional
class LineItemDaoHibernateTest extends AbstractTransactionalJUnit4SpringContextTests{
  @Autowired
  val dao: LineItemDAO = null

  @Autowired
  val orderDao:OrderDAO = null

  @Autowired
  val customerDao:CustomerDAO = null

  @Autowired
  val productDao:ProductDAO  = null

  val product1 = new Product("Baked Beans",2.00f)
  val product2 = new Product("Spaghetti",3.00f)
  val customer1 = new Customer("London", "UK", "tom@cruise.com", "Tom", "Cruise", "Warks", "High Street", "B11")
  val customer2 = new Customer("Coventry", "UK", "Frank@Sinatra.com", "Frank", "Sinatra", "West Midlands", "High Street", "CV8")
  val order1 = new Order(20.00f,new Date(),customer1)
  val order2 = new Order(30.00f,new Date(),customer1)
  val order3 = new Order(40.00f,new Date(),customer2)
  val lineItem1 = new LineItem(1,new Date(),product1,order1)
  val lineItem2 = new LineItem(1,new Date(),product2,order1)
  val lineItem3 = new LineItem(2,new Date(),product2,order2)

  @Before
  def setUpData(){
    customerDao.add(customer1)
    customerDao.add(customer2)
    orderDao.add(order1)
    orderDao.add(order2)
    orderDao.add(order3)
    productDao.add(product1)
    productDao.add(product2)
    dao.add(lineItem1)
    dao.add(lineItem2)
    dao.add(lineItem3)
  }

  @Test
  def testFetchAll(){
    val all: util.List[LineItem] = dao.fetchAll()
    assert(all.size()==3)
  }

  @Test
  def testGet(){
    val lineItem: LineItem = dao.get(lineItem1.getId)
    assert(lineItem==lineItem1)
    assert(lineItem.getProduct.getName=="Baked Beans")
  }

  @Test
  def testFetchAllLineItemsForOrder(){
    val lineItems1: util.List[LineItem] = dao.fetchFor(order1)
    assert(lineItems1.size()==2)
    val lineItems2: util.List[LineItem] = dao.fetchFor(order2)
    assert(lineItems2.size()==1)
  }
}
