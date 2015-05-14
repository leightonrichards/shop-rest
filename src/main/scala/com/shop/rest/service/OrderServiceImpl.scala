package com.shop.rest.service

import com.shop.rest.domain.{Customer, Order}
import com.shop.rest.persistence.OrderDAO
import org.springframework.beans.factory.annotation.Autowired
import scala.collection.mutable
import org.springframework.stereotype.Service

/**
 * Created with IntelliJ IDEA.
 * User: leighton
 * Date: 04/05/13
 * Time: 17:22
 * To change this template use File | Settings | File Templates.
 */
@Service
class OrderServiceImpl() extends GenericServiceImpl[Order] with OrderService
{
  @Autowired val dao: OrderDAO = null
  def fetchFor(customer:Customer): mutable.Buffer[Order] = dao.fetchFor(customer)
}
