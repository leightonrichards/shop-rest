package com.shop.rest.domain

import javax.persistence.{Table, Entity}
import scala.beans.BeanProperty

@Entity
@Table(name = "line_item")
class LineItem extends AbstractEntity {
  @BeanProperty
  var quantity: Int = 0

  @BeanProperty
  var date: String = null

  @BeanProperty
  var productId: String = null
}
