package com.shop.rest.persistence.hibernate

import org.springframework.test.context.{TestExecutionListeners, ContextConfiguration}
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.transaction.TransactionalTestExecutionListener
import org.springframework.test.context.support.{DirtiesContextTestExecutionListener, DependencyInjectionTestExecutionListener}
import org.springframework.transaction.annotation.Transactional
import org.springframework.beans.factory.annotation.Autowired
import com.shop.rest.domain.Product
import org.junit.{Test, Before}
import org.springframework.test.context.junit4.{SpringJUnit4ClassRunner, AbstractTransactionalJUnit4SpringContextTests}
import scala.collection.mutable
import com.shop.rest.service.ProductService
import org.junit.runner.RunWith

@ContextConfiguration
@DirtiesContext
@TestExecutionListeners(Array(classOf[TransactionalTestExecutionListener], classOf[DependencyInjectionTestExecutionListener], classOf[DirtiesContextTestExecutionListener]))
@Transactional
@RunWith(classOf[SpringJUnit4ClassRunner])
class ProductDaoHibernateTest{
  @Autowired
  val Service: ProductService = null

  val product1 = new Product("Baked Beans",2.00f)
  val product2 = new Product("Spaghetti",3.00f)


  @Before
  def setUpData(){
    Service.add(product1)
    Service.add(product2)
  }

  @Test
  def testFetchAll(){
    val all: mutable.Buffer[Product] = Service.fetchAll()
    assert(all.length==2)
  }

  @Test
  def testGet(){
    val product: Product = Service.get(product1.getId).get
    assert(product==product1)
  }
}
