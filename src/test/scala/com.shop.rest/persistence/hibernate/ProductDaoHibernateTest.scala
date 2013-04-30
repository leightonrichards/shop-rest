package com.shop.rest.persistence.hibernate

import org.springframework.test.context.{TestExecutionListeners, ContextConfiguration}
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.transaction.TransactionalTestExecutionListener
import org.springframework.test.context.support.{DirtiesContextTestExecutionListener, DependencyInjectionTestExecutionListener}
import org.springframework.transaction.annotation.Transactional
import org.springframework.beans.factory.annotation.Autowired
import com.shop.rest.domain.Product
import com.shop.rest.persistence.ProductDAO
import org.junit.{Test, Before}
import java.util
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests

@ContextConfiguration
@DirtiesContext
@TestExecutionListeners(Array(classOf[TransactionalTestExecutionListener], classOf[DependencyInjectionTestExecutionListener], classOf[DirtiesContextTestExecutionListener]))
@Transactional
class ProductDaoHibernateTest extends AbstractTransactionalJUnit4SpringContextTests{
  @Autowired
  val dao: ProductDAO = null

  val product1 = new Product("Baked Beans",2.00f)
  val product2 = new Product("Spaghetti",3.00f)


  @Before
  def setUpData(){
    dao.add(product1)
    dao.add(product2)
  }

  @Test
  def testFetchAll(){
    val all: util.List[Product] = dao.fetchAll()
    assert(all.size()==2)
  }

  @Test
  def testGet(){
    val product: Product = dao.get(product1.getId)
    assert(product==product1)
  }
}
