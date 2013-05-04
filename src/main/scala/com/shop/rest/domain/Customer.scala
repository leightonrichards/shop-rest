package com.shop.rest.domain

import javax.persistence.{OneToMany, Table, Entity}
import scala.beans.BeanProperty
import java.util.HashSet
import java.util
import javax.xml.bind.annotation.XmlRootElement

@Entity
@Table(name = "customer")
@XmlRootElement
class Customer(@BeanProperty var city: String,
               @BeanProperty var country: String,
               @BeanProperty var email: String,
               @BeanProperty var first_name: String,
               @BeanProperty var last_name: String,
               @BeanProperty var state: String,
               @BeanProperty var street: String,
               @BeanProperty var zip: String
               ) extends AbstractEntity
{
  def this()=this("","","","","","","","")
}