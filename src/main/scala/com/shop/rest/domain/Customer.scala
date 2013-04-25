package com.shop.rest.domain

import javax.persistence.{Column, Table, Entity}
import scala.beans.BeanProperty

@Entity
@Table(name = "customer")
class Customer extends AbstractEntity {
  @BeanProperty
  @Column(name = "first_name")
  var firstName: String = null


  @BeanProperty
  @Column(name = "last_name")
  var lastName: String = null

  @BeanProperty
  var street: String = null

  @BeanProperty
  var city: String = null

  @BeanProperty
  var state: String = null

  @BeanProperty
  var zip: String = null

  @BeanProperty
  var country: String = null

  @BeanProperty
  var email: String = null
}
