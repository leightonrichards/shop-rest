package com.shop.rest.persistence.hibernate

import org.springframework.stereotype.Repository
import com.shop.rest.domain.{Customer, Order}
import com.shop.rest.persistence.{OrderDAO}
import scala.collection.convert.WrapAsScala._
import java.util
import org.hibernate.criterion.Restrictions
import scala.collection.mutable

@Repository
class OrderDaoHibernate extends HibernateDao[Order] with OrderDAO
{
  def fetchFor(customer:Customer): mutable.Buffer[Order] = fetchFor("customer", customer)
}
