package com.shop.rest.persistence

import com.shop.rest.domain.Customer
import scala.collection.mutable


trait CustomerDAO extends GenericDao[Customer]
{
  def fetchFor(email:String): mutable.Buffer[Customer]
}
