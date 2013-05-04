package com.shop.rest.persistence.hibernate

import org.springframework.stereotype.Repository
import com.shop.rest.domain.{Order, Customer, LineItem}
import com.shop.rest.persistence.{LineItemDAO}
import java.util
import org.hibernate.criterion.Restrictions

@Repository
class LineItemDaoHibernate extends HibernateDao[LineItem] with LineItemDAO
{
  def fetchFor(order:Order): util.List[LineItem] = criteria
    .add(Restrictions.eq("order", order)).list().asInstanceOf[util.List[LineItem]]
}
