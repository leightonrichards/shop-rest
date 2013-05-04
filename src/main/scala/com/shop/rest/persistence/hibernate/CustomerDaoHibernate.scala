package com.shop.rest.persistence.hibernate

import com.shop.rest.domain.{Customer}
import org.springframework.stereotype.Repository
import com.shop.rest.persistence.{CustomerDAO}
import org.hibernate.criterion.Restrictions

@Repository
class CustomerDaoHibernate extends HibernateDao[Customer] with CustomerDAO
{
  def fetchByEmail(email:String): List[Customer] = criteria
    .add(Restrictions.eq("email", email)).list().asInstanceOf[List[Customer]]
}
