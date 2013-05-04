package com.shop.rest.service

import org.springframework.stereotype.Service
import com.shop.rest.persistence.GenericDao
import com.shop.rest.domain.{Customer, AbstractEntity}
import scala.collection.convert.WrapAsScala._
import scala.collection.mutable

/**
 * Created with IntelliJ IDEA.
 * User: leighton
 * Date: 04/05/13
 * Time: 13:38
 * To change this template use File | Settings | File Templates.
 */
@Service
abstract class GenericServiceImpl[T <: AbstractEntity]{

  def getDao():GenericDao[T]

  def add(obj: T) {getDao().add(obj)}

  def get(id: Int):T = getDao().get(id)

  def update(obj: T) {getDao().update(obj)}

  def delete(obj: T) {getDao().delete(obj)}

  def fetchAll(): mutable.Buffer[T] = getDao().fetchAll()
}
