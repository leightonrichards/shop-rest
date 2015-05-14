package com.shop.rest.persistence

import com.shop.rest.domain.{Customer, Order}
import java.util
import scala.collection.mutable

trait OrderDAO extends GenericDao[Order]
{
  def fetchFor(customer:Customer): mutable.Buffer[Order]
}
