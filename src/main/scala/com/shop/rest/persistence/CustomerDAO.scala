package com.shop.rest.persistence

import com.shop.rest.domain.Customer


trait CustomerDAO extends GenericDao[Customer]
{
  def fetchByEmail(first_name:String): List[Customer]
}
