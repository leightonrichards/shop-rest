package com.shop.rest.resource

import com.shop.rest.domain.{Address}
import com.sun.jersey.api.client.{ClientResponse, WebResource}
import scala.Predef.String
import scala.Predef.classOf
import junit.framework.Assert
import org.junit.Test

/**
 * Created with IntelliJ IDEA.
 * User: leighton
 * Date: 08/05/13
 * Time: 06:36
 * To change this template use File | Settings | File Templates.
 */
class AddressClientTest extends BaseTestClient{
  @Test
  protected def createCustomer():Unit =
  {
    val address: Address = new Address("city","country","state","street","zip")
    val webResource: WebResource = resource
    val clientResponse: ClientResponse = webResource.post(classOf[ClientResponse], address)
    var location: String = clientResponse.getHeaders.getFirst("Location").substring(getPath.length + resourcePath.length)
    val newAddress: Address = resource.path(location).get(classOf[Address])
    Assert.assertNotNull(newAddress)
  }

  val resourcePath: String = "/addresses"
}
