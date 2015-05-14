package com.shop.rest.service

import org.springframework.stereotype.Service
import com.shop.rest.persistence.GenericDao
import scala.collection.mutable
import com.shop.rest.entity.AbstractEntity

/**
 * Created with IntelliJ IDEA.
 * User: leighton
 * Date: 04/05/13
 * Time: 13:38
 * To change this template use File | Settings | File Templates.
 */
@Service
abstract class GenericServiceImpl[T <: AbstractEntity]{

  val dao: GenericDao[T]

  def add(obj: T) {dao.add(obj)}

  def get(id: Int):Option[T] = dao.get(id)

  def update(obj: T) {dao.update(obj)}

  def delete(obj: T) {dao.delete(obj)}

  def fetchAll(): mutable.Buffer[T] = dao.fetchAll()
}
