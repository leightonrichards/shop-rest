package com.shop.rest.resource

import javax.ws.rs._
import javax.ws.rs.core._
import javax.ws.rs.core.Response.{ResponseBuilder, Status}
import com.shop.rest.domain.Customer
import org.springframework.beans.factory.annotation.Autowired
import com.shop.rest.service.CustomerService
import javax.ws.rs.Path
import org.springframework.stereotype.Service
import scala.collection.mutable

/**
 * Created with IntelliJ IDEA.
 * User: leighton
 * Date: 07/05/13
 * Time: 06:16
 * To change this template use File | Settings | File Templates.
 */
@Path("/customers")
@Consumes (Array (MediaType.APPLICATION_JSON) )
@Produces(Array(MediaType.APPLICATION_JSON))
@Service
class CustomerResource
{
  @Autowired val  service: CustomerService = null

  @POST
  @Path("{id}")
  @Consumes(Array(MediaType.APPLICATION_JSON))
  def createCustomer(customer: Customer): Response =
  {
    if(customer == null){
      return Response.status(Status.BAD_REQUEST).build()
    }
    service.add(customer)
    Response.created(UriBuilder.fromPath("/" + customer.getId).build()).build()
  }

  @GET
  @Produces(Array(MediaType.APPLICATION_JSON))
  def getCustomers(@PathParam("id") id: Int ):Response =
  {
    val all: mutable.Buffer[Customer] = service.fetchAll()
    Response.ok(all).build()
  }

  @GET
  @Path("{id}")
  @Produces(Array(MediaType.APPLICATION_JSON))
  def getCustomer(@PathParam("id") id: Int ):Response =
  {
    for (customer <- service.get(id))
    {
      return Response.ok(customer).build()
    }
    Response.status(Status.NOT_FOUND).build
  }

}
