package com.shop.rest.domain

import javax.persistence._
import scala.beans.BeanProperty
import java.util.Date
import javax.xml.bind.annotation.XmlRootElement

@Entity
@Table(name = "line_item")
@XmlRootElement
class LineItem(@BeanProperty var quantity: Int,
               @BeanProperty var date: Date,
               p: Product,
               o: Order) extends AbstractEntity {
  @OneToOne
  @JoinColumn(name = "product_id")
  @BeanProperty var product: Product = p

  @ManyToOne
  @JoinColumn(name = "order_id")
  @BeanProperty var order: Order = o

  def this() = this(0,new Date(),new Product(),new Order())
  def ==(that: LineItem): Boolean = { this.getDate==that.getDate &&
    this.getOrder==that.getOrder &&
    this.getProduct == that.getProduct &&
    this.getQuantity == that.getQuantity}
}
