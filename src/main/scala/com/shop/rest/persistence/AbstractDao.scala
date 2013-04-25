package com.shop.rest.persistence

trait AbstractDao [T]{
  def add(obj: T)
  def get(id: Int):T
  def update(obj: T)
  def delete(obj: T)
}
