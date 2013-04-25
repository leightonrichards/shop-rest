package com.shop.rest.persistence

import com.shop.rest.domain.Customer
import org.springframework.stereotype.Repository

@Repository
class ProductDaoHibernate extends HibernateDao[Product] with ProductDAO
