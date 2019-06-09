package br.ufrn.imd.books.services;

import java.util.Date;

import javax.ejb.EJB;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import br.ufrn.imd.books.beans.order.OrderLocalEJB;
import br.ufrn.imd.books.entity.OrderEntity;
import br.ufrn.imd.books.exceptions.BookstoreUnknownException;
import br.ufrn.imd.books.utils.ExceptionWrapper;

/**
 * OrderService
 */
@Path("/order")
public class OrderService {

  @EJB
  OrderLocalEJB orderEJB;

  @Path("/create")
  @POST
  @Produces("application/json; charset=UTF-8")
  public Response create() {
    try {
      OrderEntity obj = orderEJB.createNew(new OrderEntity(new Date()));
      return Response.ok(obj).build();
    } catch(BookstoreUnknownException unknownErr) {
			// Unknown or undefined server error
			return Response.status(500).entity(new ExceptionWrapper(unknownErr)).build();
		}
  }

  @Path("/{id}")
  public void get(final @PathParam("id") int id) {

  }

  @Path("/{id}/add")
  public void addItem(final @PathParam("id") int id, final @FormParam("bookId") int bookId
    , final @FormParam("quantity") int quantity) {

  }

  @Path("/{id}/checkout")
  public void checkout(final @PathParam("id") int id, final @FormParam("type") String type) {

  }
}