package com.shop.rest.service

import com.shop.rest.domain.{Order, LineItem}
import scala.collection.mutable

/**
 * Created with IntelliJ IDEA.
 * User: leighton
 * Date: 04/05/13
 * Time: 13:37
 * To change this template use File | Settings | File Templates.
 */
trait LineItemService extends GenericService[LineItem]{
  def fetchFor(order:Order): mutable.Buffer[LineItem]
}
