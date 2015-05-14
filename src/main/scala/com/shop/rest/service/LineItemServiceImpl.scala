package com.shop.rest.service

import com.shop.rest.domain.{Order, LineItem}
import com.shop.rest.persistence.LineItemDAO
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
class LineItemServiceImpl() extends GenericServiceImpl[LineItem] with LineItemService
{
  @Autowired val dao: LineItemDAO = null
  def fetchFor(order: Order): mutable.Buffer[LineItem] = dao.fetchFor(order)
}
