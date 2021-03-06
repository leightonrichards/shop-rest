package com.shop.rest.service

import com.shop.rest.domain.Customer
import com.shop.rest.persistence.CustomerDAO
import org.springframework.beans.factory.annotation.Autowired
import scala.collection.mutable
import org.springframework.stereotype.Service

/**
 * Created with IntelliJ IDEA.
 * User: leighton
 * Date: 04/05/13
 * Time: 17:22
 * To change this template use File | Settings | File Templates.
 */
@Service
class CustomerServiceImpl() extends GenericServiceImpl[Customer] with CustomerService
{
  @Autowired val dao: CustomerDAO = null
  def fetchFor(email:String): mutable.Buffer[Customer] = dao.fetchFor(email)
}
