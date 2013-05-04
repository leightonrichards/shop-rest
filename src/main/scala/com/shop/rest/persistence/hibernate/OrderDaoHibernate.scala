package com.shop.rest.persistence.hibernate

import org.springframework.stereotype.Repository
import com.shop.rest.domain.{Customer, Order}
import com.shop.rest.persistence.{OrderDAO}
import java.util
import org.hibernate.criterion.Restrictions

@Repository
class OrderDaoHibernate extends HibernateDao[Order] with OrderDAO
{
  def fetchFor(customer:Customer): util.List[Order] = criteria
    .add(Restrictions.eq("customer", customer)).list().asInstanceOf[util.List[Order]]
}
