package lnu.resources;

import lnu.models.Book;
import lnu.dao.booksDAO;
import lnu.models.Catalog;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import javax.ws.rs.DELETE;
import javax.ws.rs.PathParam;
import java.util.*;
import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;


@Produces(MediaType.APPLICATION_JSON)
@Path("/books/{id}")
public class RemoveBookResource {

  	  @DELETE
  		public String deleteBook(@PathParam("id") String id) throws IOException{

        booksDAO bDAO = new booksDAO();
        ArrayList<Book> listOfBooks = new ArrayList<Book>();
        ArrayList<Book> booklist = new ArrayList<Book>();

        // Read from XML and create new list without the book with correct id
        listOfBooks = bDAO.BooksFromFile();

        for (Book book : listOfBooks) {
          if (!id.equals(book.getId())) {   // For each book NOT equal to ID of deleted book,
              booklist.add(book);           // add to booklist
          }
  			}

        // Create a new XML file from array without the deleted book
        bDAO.BooksToFile(booklist);

  	    return null;

  	  }


}
