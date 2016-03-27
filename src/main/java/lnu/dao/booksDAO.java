package lnu.dao;

import java.util.ArrayList;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import lnu.models.Book;
import lnu.models.Catalog;

public class booksDAO {

  // Method to import XML to java
  public ArrayList<Book> BooksFromFile() {

    // initialize the ArrayList
    ArrayList<Book> listOfBooks = new ArrayList<Book>();

    try {
      JAXBContext context = JAXBContext.newInstance(Catalog.class);
      Unmarshaller un = context.createUnmarshaller();
      Catalog catalog = (Catalog) un.unmarshal(new File("books.xml"));

      listOfBooks = catalog.getListOfBooks();

    } catch (JAXBException e) {
      e.printStackTrace();
    }

    return listOfBooks;
  }

  // Method to export java to XML
  public void BooksToFile(ArrayList<Book> listOfBooks) {

    Catalog catalog = new Catalog();
    catalog.setListOfBooks(listOfBooks);

    try {
      JAXBContext context = JAXBContext.newInstance(Catalog.class);
      Marshaller m = context.createMarshaller();
      m.marshal(catalog, new File("books.xml"));

    } catch (JAXBException e) {
      e.printStackTrace();
    }
  }

}
