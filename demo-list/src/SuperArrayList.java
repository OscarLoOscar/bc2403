import java.util.ArrayList;
import java.util.List;

public class SuperArrayList extends ArrayList<Book> {

  private List<Book> books;

  public SuperArrayList() {
    books =  super.subList(0, super.size() - 1); // subList -> new Object
  }

  public void insertHead(Book book) {
    
  }

  // add()

  // contains()
}
