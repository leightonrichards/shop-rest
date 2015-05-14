package com.shop.rest.service

import scala.collection.mutable
import com.shop.rest.entity.AbstractEntity

/**
 * Created with IntelliJ IDEA.
 * User: leighton
 * Date: 04/05/13
 * Time: 13:38
 * To change this template use File | Settings | File Templates.
 */
trait GenericService[T <: AbstractEntity] {

  def add(obj: T)

  def get(id: Int):Option[T]

  def update(obj: T)

  def delete(obj: T)

  def fetchAll(): mutable.Buffer[T]
}
