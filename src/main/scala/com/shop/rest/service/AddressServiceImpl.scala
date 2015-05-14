package com.shop.rest.service

import com.shop.rest.domain.{Address, Customer}
import com.shop.rest.persistence.{AddressDAO}
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
class AddressServiceImpl() extends GenericServiceImpl[Address] with AddressService
{
  @Autowired val dao: AddressDAO = null
}
