package com.shop.rest.resource

/**
 * Created with IntelliJ IDEA.
 * User: leighton
 * Date: 08/05/13
 * Time: 06:02
 * To change this template use File | Settings | File Templates.
 */

import java.net.URI
import javax.ws.rs.core.UriBuilder
import org.springframework.web.context.ContextLoaderListener
import com.sun.jersey.spi.spring.container.servlet.SpringServlet
import com.sun.jersey.test.framework.WebAppDescriptor
import scala.Predef.String
import scala.Predef.classOf
import com.sun.jersey.test.framework.JerseyTest
import com.sun.jersey.test.framework.spi.container.TestContainerFactory
import com.sun.jersey.test.framework.spi.container.grizzly.web.GrizzlyWebTestContainerFactory
import com.sun.jersey.api.client.WebResource

abstract class BaseTestClient extends JerseyTest(
  new WebAppDescriptor.Builder("com.shop.rest").
    contextPath("/shop-rest").
    contextParam("contextConfigLocation", "/applicationContext.xml").
    servletClass(classOf[SpringServlet]).
    contextListenerClass(classOf[ContextLoaderListener]).
    build) {

  val CONTEXT_PATH: String = "/shop-rest"
  val resourcePath: String

  protected def getPath: String = super.getBaseURI.toASCIIString + CONTEXT_PATH

  protected override def getTestContainerFactory: TestContainerFactory = new GrizzlyWebTestContainerFactory

  protected override def getBaseURI: URI = UriBuilder.fromUri("http://localhost/").port(getPort(8080)).build()

  override def resource: WebResource = super.resource.path(resourcePath)

}

