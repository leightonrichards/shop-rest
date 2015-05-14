package com.shop.rest.resource

import javax.ws.rs._
import javax.ws.rs.core._
import javax.ws.rs.core.Response.Status
import com.shop.rest.domain.{Address, Customer}
import org.springframework.beans.factory.annotation.Autowired
import com.shop.rest.service.{AddressService, CustomerService}
import javax.ws.rs.Path
import org.springframework.stereotype.Service
import org.springframework.security.access.prepost.PreAuthorize

/**
 * Created with IntelliJ IDEA.
 * User: leighton
 * Date: 07/05/13
 * Time: 06:16
 * To change this template use File | Settings | File Templates.
 */
@Path("/addresses")
@Consumes (Array (MediaType.APPLICATION_JSON) )
@Produces(Array(MediaType.APPLICATION_JSON))
@Service
class AddressResource(@Autowired val service: AddressService)
{


  @POST
  @Consumes(Array(MediaType.APPLICATION_JSON))
  @PreAuthorize("hasRole('ROLE_ADMIN')")
  @Path("{id}")
  def createAddress(address: Address): Response =
  {
    if(address == null){
      return Response.status(Status.BAD_REQUEST).build()
    }
    service.add(address)
    Response.created(UriBuilder.fromPath("/" + address.getId).build()).build()
  }

  @GET
  @Path("{id}")
  @Produces(Array(MediaType.APPLICATION_JSON))
  @PreAuthorize("hasRole('ROLE_USER')")
  def getAddress(@PathParam("id") id: Int ):Response =
  {
    for (address <- service.get(id)) return Response.ok(address).build()

    Response.status(Status.NOT_FOUND).build
  }
}
