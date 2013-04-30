package com.shop.rest.persistence

import com.shop.rest.domain.{Customer, Order}
import java.util

trait OrderDAO extends AbstractDao[Order]
{
  def fetchFor(customer:Customer): util.List[Order]
}
