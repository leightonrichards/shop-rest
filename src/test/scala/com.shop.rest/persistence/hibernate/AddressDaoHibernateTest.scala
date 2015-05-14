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
@RunWith(classOf[SpringJUnit4ClassRunner])
@Transactional
class AddressDaoHibernateTest
{
  @Autowired
  val service: AddressService = null

  val address1 = new Address("London", "UK", "Warks", "High Street", "L11")
  val address2 = new Address("Birmingham", "UK", "West Mids", "Regent Street", "B11")
  val customer1 = new Customer("tom@cruise.com", "Tom", "Cruise", "tom.cruise","password",address1)
  val customer2 = new Customer("Frank@Sinatra.com", "Frank", "Sinatra", "frank.sinatra","password",address2)

  @Before
  def setUpData(){
    service.add(address1)
    service.add(address2)
  }

  @Test
  def testFetchAllAddresses(){
    assert(service.fetchAll().length==2)
  }

  @Test
  def testGetAddressById(){
    val address: Address = service.get(address1.getId).get
    assert(address==address1)
  }
}
