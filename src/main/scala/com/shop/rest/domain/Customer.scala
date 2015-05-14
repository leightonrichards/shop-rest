package com.shop.rest.domain

import javax.persistence._
import scala.beans.BeanProperty
import java.util.HashSet
import java.util
import javax.xml.bind.annotation.XmlRootElement
import com.shop.rest.entity.AbstractEntity

@Entity
@Table(name = "customer")
@XmlRootElement
class Customer( @BeanProperty var email: String,
                @BeanProperty var firstname: String,
                @BeanProperty var lastname: String,
                @UniqueConstraint(columnNames=Array("username")) @BeanProperty var username: String,
                @BeanProperty var password: String,
                @JoinColumn(name = "address_id") @OneToOne @BeanProperty var address: Address
               ) extends AbstractEntity
{
  def this()=this("","","","","",new Address())
}