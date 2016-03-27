package lnu.models;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlID;

@XmlRootElement(name = "book")
@XmlType(propOrder = {"id", "author", "title", "genre", "price", "publishDate", "description"})
public class Book {
  @XmlAttribute(name="id")  // needed to add attribute to get the id
  public String id;
  public String title;
  public String author;
  public String genre;
  public String price;
  @XmlElement(name = "publish_date")    // hade to make sure to redo the string to be correct
  public String publishDate;
  public String description;

  public String getId() {
    return this.id;
  }

  //Constructor
  public Book() {

  }

  public Book(String id, String title, String author, String genre, String price, String publishDate, String description) {
    this.id = id;
    this.title = title;
    this.author = author;
    this.genre = genre;
    this.price = price;
    this.publishDate = publishDate;
    this.description = description;
  }

  @Override
  public String toString() {
    return ("Id: "+this.id+"\n Title: "+this.title+"\n Author: "+this.author+"\n Genre: "+this.genre+"\n Price: "+this.price+"\n Date: "+this.publishDate+"\n Description: "+this.description);
  }

}
