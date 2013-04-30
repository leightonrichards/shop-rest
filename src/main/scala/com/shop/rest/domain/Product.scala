package com.shop.rest.domain

import javax.persistence.{Table, Entity}
import scala.beans.BeanProperty

@Entity
@Table(name = "product")
class Product (@BeanProperty var name:String, @BeanProperty var cost:Float) extends AbstractEntity {
  def this()=this("",0f)
}
