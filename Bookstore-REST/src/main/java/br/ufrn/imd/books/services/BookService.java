package br.ufrn.imd.books.services;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import br.ufrn.imd.books.beans.book.BookLocalEJB;
import br.ufrn.imd.books.entity.BookEntity;
import br.ufrn.imd.books.exceptions.BookstoreUnknownException;
import br.ufrn.imd.books.exceptions.BookstoreValidationException;
import br.ufrn.imd.books.utils.ExceptionWrapper;

/**
 * BookService
 * @author Maradona Morais
 */
@Path("/book")
public class BookService {

  @EJB
  private BookLocalEJB bookEJB;

	/**
	 * Create a new book
	 * @param title_ book title
	 * @param authorName_ book's author name
	 * @param isbn_ book isbn code
	 * @param sellPrice_ book sell price
	 * @param costPrice_ book cost price
	 * @return created book
	 */
	@POST
	@Path("/create")
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/x-www-form-urlencoded; charset=UTF-8")
	public Response create(
		  @FormParam("title") final String title_
		, @FormParam("authorName") final String authorName_
		, @FormParam("isbn") final String isbn_
		, @FormParam("sellPrice") final Double sellPrice_
		, @FormParam("costPrice") final Double costPrice_
	) {
		try {
			BookEntity obj = bookEJB.createNew(
				new BookEntity(title_, authorName_, isbn_, sellPrice_, costPrice_)
			);
			return Response.ok(obj).build();
		}  catch(BookstoreValidationException validationErr) {
			// Bad request
			return Response.status(400).entity(new ExceptionWrapper(validationErr)).build();
		} catch(BookstoreUnknownException unknownErr) {
			// Unknown or undefined server error
			return Response.status(500).entity(new ExceptionWrapper(unknownErr)).build();
		}
	}

	/**
	 * Returns all books
	 * @return list containing all existing books
	 */
	@GET
	@Path("/all")
	@Produces("application/json; charset=UTF-8")
	public Response getAll() {
		try {
			List<BookEntity> allBooks = bookEJB.getAll();
			return Response.ok(allBooks).build();
		} catch(BookstoreUnknownException unknownException) {
			// Unknown or undefined server error
			return Response.status(500).entity(new ExceptionWrapper(unknownException)).build();
		}
	}

}
