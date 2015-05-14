package com.shop.rest.persistence.hibernate

import org.springframework.stereotype.Repository
import com.shop.rest.domain.{Order, LineItem}
import com.shop.rest.persistence.{LineItemDAO}
import scala.collection.convert.WrapAsScala._
import java.util
import org.hibernate.criterion.Restrictions
import scala.collection.mutable

@Repository
class LineItemDaoHibernate extends HibernateDao[LineItem] with LineItemDAO
{
  def fetchFor(order:Order): mutable.Buffer[LineItem] = fetchFor("order", order)
}
