package com.shop.rest.persistence

import com.shop.rest.domain.{Address, Customer, Order, LineItem}
import scala.collection.mutable

trait AddressDAO extends GenericDao[Address]
{
}
