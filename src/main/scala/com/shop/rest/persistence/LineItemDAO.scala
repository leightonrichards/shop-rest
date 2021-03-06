package com.shop.rest.persistence

import com.shop.rest.domain.{Order, LineItem}
import java.util
import scala.collection.mutable

trait LineItemDAO extends GenericDao[LineItem]
{
  def fetchFor(order:Order): mutable.Buffer[LineItem]
}
