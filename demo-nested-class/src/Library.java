import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Library {
  private List<Book> books;

  public Library() {
    this.books = new LinkedList<>();
  }

  public void add(Book book) {
    this.books.add(book);
  }

  public class BookIterator implements Iterator<Book> { // Inner Class
    private int currentIdx = 0;

    @Override
    public boolean hasNext() {
      return this.currentIdx < books.size(); // but not this.books
    }

    @Override
    public Book next() {
      if (!hasNext())
        throw new IllegalStateException("No more elements in the list");
      return books.get(currentIdx++);
    }

    public void reset() {
      this.currentIdx = 0;
    }
    
   }

  public static class Book {
    private String isbn;
    private String author;
    public Book(String isbn, String author) {
      this.isbn = isbn;
      this.author = author;
    }
    public String getIsbn() {
      return this.isbn;
    }
    public String getAuthor() {
      return this.author;
    }
  }

  public static void main(String[] args) {
    Library library = new Library();
    library.add(new Library.Book("1234", "John Smith"));
    library.add(new Library.Book("2345", "Peter Lau"));
    library.add(new Library.Book("3456", "Vincent Cheng"));

    Library.BookIterator lb = library.new BookIterator();
    while (lb.hasNext()) {
      Library.Book book = lb.next();
      System.out.println(book.getIsbn() + " " + book.getAuthor());
    }
  }
}
