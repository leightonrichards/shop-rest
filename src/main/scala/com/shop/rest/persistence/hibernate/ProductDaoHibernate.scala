package com.shop.rest.persistence.hibernate

import com.shop.rest.domain.Product
import org.springframework.stereotype.Repository
import com.shop.rest.persistence.{ProductDAO, AbstractDao}

@Repository
class ProductDaoHibernate extends HibernateDao[Product] with ProductDAO
