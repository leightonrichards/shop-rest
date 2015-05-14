package com.shop.rest.entity

import javax.persistence._
import beans.BeanProperty

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
abstract class AbstractEntity extends Serializable{
  @Id
  @GeneratedValue
  @BeanProperty
  var id: Int = -1
}

