package com.shop.rest.persistence

import com.shop.rest.domain.AbstractEntity
import java.util

trait AbstractDao [T <: AbstractEntity]{
  def add(obj: T)
  def get(id: Int):T
  def update(obj: T)
  def delete(obj: T)
  def fetchAll():util.List[T]
}
