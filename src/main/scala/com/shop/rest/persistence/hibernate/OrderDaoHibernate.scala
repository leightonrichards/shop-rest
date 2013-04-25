package com.shop.rest.persistence.hibernate

import org.springframework.stereotype.Repository
import com.shop.rest.persistence.ProductDAO
import com.shop.rest.domain.{Order, LineItem}

@Repository
class OrderDaoHibernate extends HibernateDao[Order] with ProductDAO
