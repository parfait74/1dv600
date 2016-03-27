package lnu.resources;

import lnu.models.Book;
import lnu.dao.booksDAO;
import lnu.models.Catalog;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import java.io.IOException;
import java.util.*;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;


// Response will be JSON
@Produces(MediaType.APPLICATION_JSON)

// This is the class that will be called when "localhost:9090/api/books" get called by the browser.
// FOR THE CURIOUS: Take a look in the config.yml to find out why "/api" is present in the path.
@Path("/books")
public class GetBooksResource {

	@GET
	public String getBooks() throws IOException{

		// list for new books and call for BooksFromFile to import from XML
		ArrayList<Book> listOfBooks = new ArrayList<Book>();
		booksDAO bDAO = new booksDAO();
		listOfBooks = bDAO.BooksFromFile();

			// JSON for the objects in listOfBooks
			ObjectMapper mapper = new ObjectMapper();
			ArrayList<String> BookList = new ArrayList<String>();
      for (Book book : listOfBooks) {
				BookList.add(mapper.writeValueAsString(book));
			}

			return BookList.toString();

		}



}

/**
// Convert to JSON
ObjectMapper mapper = new ObjectMapper();
String jsonInString1 = mapper.writeValueAsString(book1);
System.out.println(jsonInString1);
String jsonInString2 = mapper.writeValueAsString(book2);
System.out.println(jsonInString2);


// TODO: Task 1 C
ArrayList<String> BookList = new ArrayList<String>();
BookList.add(jsonInString1);
BookList.add(jsonInString2);

System.out.println(BookList.toString());
return BookList.toString();
*/
