package com.shop.rest.domain

import javax.persistence.{Column, Table, Entity}
import scala.beans.BeanProperty

@Entity
@Table(name = "cust_order")
class Order extends AbstractEntity {
  @BeanProperty
  var total: Float = 0

  @BeanProperty
  var date: String = null

  @BeanProperty
  @Column(name = "customer_id")
  var customerId: Int =0
}
