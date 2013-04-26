package com.shop.rest.persistence.hibernate

import org.springframework.stereotype.Repository
import com.shop.rest.persistence.{LineItemDAO, ProductDAO}
import com.shop.rest.domain.LineItem

@Repository
class LineItemDaoHibernate extends HibernateDao[LineItem] with LineItemDAO
