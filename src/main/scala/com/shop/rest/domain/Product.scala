package com.shop.rest.domain

import javax.persistence.{Table, Entity}
import scala.beans.BeanProperty
import javax.xml.bind.annotation.XmlRootElement
import com.shop.rest.entity.AbstractEntity

@Entity
@Table(name = "product")
@XmlRootElement
class Product (@BeanProperty var name:String,
               @BeanProperty var cost:Float) extends AbstractEntity {
  def this()=this("",0f)
}
