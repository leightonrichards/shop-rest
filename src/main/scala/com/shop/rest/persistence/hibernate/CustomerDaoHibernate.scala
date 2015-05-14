package com.shop.rest.persistence.hibernate

import com.shop.rest.domain.{Customer}
import org.springframework.stereotype.Repository
import com.shop.rest.persistence.{CustomerDAO}
import org.hibernate.criterion.Restrictions
import scala.collection.mutable
import scala.collection.convert.WrapAsScala._
import java.util

@Repository
class CustomerDaoHibernate extends HibernateDao[Customer] with CustomerDAO
{
  def fetchFor(email:String): mutable.Buffer[Customer] = fetchFor("email",email)
}
