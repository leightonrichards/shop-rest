package com.shop.rest.domain

import javax.persistence.{Column, Table, Entity}
import scala.beans.BeanProperty

@Entity
@Table(name = "product")
class Product extends AbstractEntity {
  @BeanProperty
  var name: String = null

  @BeanProperty
  @Column(name = "product_id")
  var cost: Float = 0
}
