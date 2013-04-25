package com.shop.rest.persistence

import com.shop.rest.domain.Customer
import org.springframework.stereotype.Repository

@Repository
class CustomerDaoHibernate extends HibernateDao[Customer] with CustomerDAO
