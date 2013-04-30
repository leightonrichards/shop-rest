package com.shop.rest.domain

import javax.persistence._
import scala.beans.BeanProperty
import java.util.Date

@Entity
@Table(name = "cust_order")
class Order(@BeanProperty var total: Float,
            @BeanProperty var date: Date,
            c: Customer
             ) extends AbstractEntity {
  @OneToOne
  @JoinColumn(name = "customer_id")
  @BeanProperty var customer: Customer = c

  def this()=this(0f,new Date,new Customer())
}
