package com.shop.rest.service

import com.shop.rest.persistence.GenericDao
import scala.collection.mutable
import com.shop.rest.domain.AbstractEntity

/**
 * Created with IntelliJ IDEA.
 * User: leighton
 * Date: 04/05/13
 * Time: 13:38
 * To change this template use File | Settings | File Templates.
 */
trait GenericService[T <: AbstractEntity] {
  def getDao():GenericDao[T]

  def add(obj: T)

  def get(id: Int):T

  def update(obj: T)

  def delete(obj: T)

  def fetchAll(): mutable.Buffer[T]
}
