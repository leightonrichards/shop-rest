package com.shop.rest.persistence.hibernate

import org.springframework.test.context.{TestExecutionListeners, ContextConfiguration}
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.transaction.TransactionalTestExecutionListener
import org.springframework.test.context.support.{DirtiesContextTestExecutionListener, DependencyInjectionTestExecutionListener}
import org.springframework.transaction.annotation.Transactional
import org.springframework.beans.factory.annotation.Autowired
import com.shop.rest.domain._
import com.shop.rest.persistence._
import org.junit.{Test, Before}
import org.springframework.test.context.junit4.{SpringJUnit4ClassRunner, AbstractTransactionalJUnit4SpringContextTests}
import java.util.Date
import com.shop.rest.service._
import scala.collection.mutable
import org.junit.runner.RunWith

@ContextConfiguration
@DirtiesContext
@TestExecutionListeners(Array(classOf[TransactionalTestExecutionListener], classOf[DependencyInjectionTestExecutionListener], classOf[DirtiesContextTestExecutionListener]))
@Transactional
@RunWith(classOf[SpringJUnit4ClassRunner])
class LineItemDaoHibernateTest{
  @Autowired
  val service: LineItemService = null

  @Autowired
  val orderService:OrderService = null

  @Autowired
  val customerService:CustomerService = null

  @Autowired
  val productService:ProductService  = null

  @Autowired
  val addressService: AddressService = null

  val product1 = new Product("Baked Beans",2.00f)
  val product2 = new Product("Spaghetti",3.00f)
  val address1 = new Address("London", "UK", "Warks", "High Street", "B11")
  val address2 = new Address("Birmingham", "UK", "West Mids", "Regent Street", "B11")
  val customer1 = new Customer("tom@cruise.com", "Tom", "Cruise", "tom.cruise","password",address1)
  val customer2 = new Customer("Frank@Sinatra.com", "Frank", "Sinatra", "frank.sinatra","password",address2)
  val order1 = new Order(20.00f,new Date(),customer1)
  val order2 = new Order(30.00f,new Date(),customer1)
  val order3 = new Order(40.00f,new Date(),customer2)
  val lineItem1 = new LineItem(1,new Date(),product1,order1)
  val lineItem2 = new LineItem(1,new Date(),product2,order1)
  val lineItem3 = new LineItem(2,new Date(),product2,order2)

  @Before
  def setUpData(){
    addressService.add(address1)
    addressService.add(address2)
    customerService.add(customer1)
    customerService.add(customer2)
    orderService.add(order1)
    orderService.add(order2)
    orderService.add(order3)
    productService.add(product1)
    productService.add(product2)
    service.add(lineItem1)
    service.add(lineItem2)
    service.add(lineItem3)
  }

  @Test
  def testFetchAll(){
    val all: mutable.Buffer[LineItem] = service.fetchAll()
    assert(all.length==3)
  }

  @Test
  def testGet(){
    val lineItem: LineItem = service.get(lineItem1.getId).get
    assert(lineItem==lineItem1)
    assert(lineItem.getProduct.getName=="Baked Beans")
  }

  @Test
  def testFetchFor(){
    val lineItems: mutable.Buffer[LineItem] = service.fetchFor(order1)
    assert(lineItems.head==lineItem1)
  }

  @Test
  def testFetchAllLineItemsForOrder(){
    val lineItems1: mutable.Buffer[LineItem] = service.fetchFor(order1)
    assert(lineItems1.length==2)
    val lineItems2: mutable.Buffer[LineItem] = service.fetchFor(order2)
    assert(lineItems2.length==1)
  }
}
