package lnu.models;

import java.util.ArrayList;
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "catalog")
public class Catalog {

  private ArrayList<Book> listOfBooks;

  public ArrayList<Book> getListOfBooks() {
    return listOfBooks;
  }

  @XmlElement(name = "book")
  public void setListOfBooks(ArrayList<Book> listOfBooks) {
    this.listOfBooks = listOfBooks;
  }

}
