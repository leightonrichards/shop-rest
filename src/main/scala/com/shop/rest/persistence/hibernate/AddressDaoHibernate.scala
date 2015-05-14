package com.shop.rest.persistence.hibernate

import org.springframework.stereotype.Repository
import com.shop.rest.domain._
import com.shop.rest.persistence.{AddressDAO}
import scala.collection.convert.WrapAsScala._
import scala.collection.mutable

@Repository
class AddressDaoHibernate extends HibernateDao[Address] with AddressDAO
{
}
