package com.shop.rest.persistence

import scala.collection.mutable
import com.shop.rest.entity.AbstractEntity

trait GenericDao [T <: AbstractEntity]{
  def add(obj: T)
  def get(id: Int):Option[T]
  def update(obj: T)
  def delete(obj: T)
  def fetchAll():mutable.Buffer[T]
}
