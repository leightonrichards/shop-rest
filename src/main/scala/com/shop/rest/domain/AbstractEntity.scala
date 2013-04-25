package com.shop.rest.domain

import javax.persistence.{MappedSuperclass, GeneratedValue, Id}
import beans.BeanProperty

@MappedSuperclass
abstract class AbstractEntity {
  @Id
  @GeneratedValue
  @BeanProperty
  var id: Int = -1
}

