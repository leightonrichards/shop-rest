package com.shop.rest.domain

import scala.beans.BeanProperty
import javax.persistence.{Table, Entity}
import javax.xml.bind.annotation.XmlRootElement
import com.shop.rest.entity.{AbstractEntity}

/**
 * Created with IntelliJ IDEA.
 * User: leighton
 * Date: 08/05/13
 * Time: 06:43
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "address")
@XmlRootElement
class Address(@BeanProperty var city: String,
              @BeanProperty var country: String,
              @BeanProperty var state: String,
              @BeanProperty var street: String,
              @BeanProperty var zip: String) extends AbstractEntity{
  def this()=this("","","","","")
}
