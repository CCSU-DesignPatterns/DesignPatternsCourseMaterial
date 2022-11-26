package edu.ccsu.designpatterns.bridge;

import java.util.Objects;

public class Book {
  private String bookId;
  private String bookTitle;
  private Double price;

  public Book(String id, String title, Double price) {
    this.bookId = (id == null) ? "" : id;
    this.bookTitle = (title == null) ? "" : title;
    this.price = (price == null) ? 0.0 : price;
  }

  public String getBookId() {
    return bookId;
  }

  public void setBookId(String id) {
    this.bookId = (id == null) ? "" : id;
  }

  public String getBookTitle() {
    return bookTitle;
  }

  public void setBookTitle(String title) {
    this.bookTitle = (title == null) ? "" : title;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = (price == null) ? 0.0 : price;
  }

  @Override
  public int hashCode() {
    return Objects.hash(bookId, bookTitle, price);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Book other = (Book) obj;
    return Objects.equals(bookId, other.bookId) && Objects.equals(bookTitle, other.bookTitle)
        && Objects.equals(price, other.price);
  }

  @Override
  public String toString() {
    return "Book [bookId=" + bookId + ", bookTitle=" + bookTitle + ", price=" + price + "]";
  }
}
