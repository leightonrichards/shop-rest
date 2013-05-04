package com.shop.rest.persistence

import com.shop.rest.domain.{Order, LineItem}
import java.util

trait LineItemDAO extends GenericDao[LineItem]
{
  def fetchFor(order:Order): util.List[LineItem]
}
