package fr.urn.mastersime.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;

import fr.urn.mastersime.domain.*;

@Path("/books")
public class BookResource {
	
	// A new BookResource instance is created for each HTTP request received
	// If we want to save modifications (e.g. new book) from a request to another
	// we need to set this attribute to static so that it is shared by
	// all instances.
	static private Bookshelf books = new Bookshelf();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Book> get() {
		return books.getAllBooks();
	}
	
	@GET
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response getById(@PathParam("id") int id) {
		try {
			Book book = books.get(id);
			return Response.ok(book).build();
		} catch(InvalidBookException e) {
			return Response.status(404).entity(e.getMessage()).build();
		}
    }

	@POST
	@Path("/new")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response create(@FormParam("title") String title, @FormParam("author") String author, 
			@FormParam("rate") double rate, @FormParam("review") String review) throws URISyntaxException {
		Book newBook = new Book();
		newBook.setTitle(title);
		newBook.setAuthor(author);
		newBook.setRate(rate);
		newBook.setReview(review);
		try {
			books.add(newBook);
			URI uri = new URI("http://localhost:8080/bookrest/index.html");
			return Response.temporaryRedirect(uri).build();
		} catch (InvalidBookException e) {
			return Response.status(403).entity(e.getMessage()).build();
		}
	}
	
	@GET
	@Path("/search")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<Book> search(@QueryParam("author") String author, @QueryParam("title") String title) {
		if(author != null) {
			return books.getBooksByAuthor(author);
		}
		if(title != null) {
			return books.getBooksByTitle(title);
		}
		return books.getAllBooks();
    }
	
}
