package com.shop.rest.persistence.hibernate

import com.shop.rest.domain.Customer
import org.springframework.stereotype.Repository
import com.shop.rest.persistence.{CustomerDAO}

@Repository
class CustomerDaoHibernate extends HibernateDao[Customer] with CustomerDAO
