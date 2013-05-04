package com.shop.rest.service

import com.shop.rest.domain.Customer

/**
 * Created with IntelliJ IDEA.
 * User: leighton
 * Date: 04/05/13
 * Time: 13:37
 * To change this template use File | Settings | File Templates.
 */
trait CustomerService extends GenericService[Customer]{
  def fetchByEmail(email:String): List[Customer]
}
