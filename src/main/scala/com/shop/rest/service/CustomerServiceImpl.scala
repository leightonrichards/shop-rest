package com.shop.rest.service

import com.shop.rest.domain.Customer
import com.shop.rest.persistence.{GenericDao, CustomerDAO}
import org.springframework.beans.factory.annotation.Autowired

/**
 * Created with IntelliJ IDEA.
 * User: leighton
 * Date: 04/05/13
 * Time: 17:22
 * To change this template use File | Settings | File Templates.
 */
class CustomerServiceImpl extends GenericServiceImpl[Customer] with CustomerService {

  @Autowired
  val customerDao: CustomerDAO = null

  def fetchByEmail(email:String): List[Customer] = getDao().asInstanceOf[CustomerDAO].fetchByEmail(email)

  def getDao(): GenericDao[Customer] = customerDao
}
