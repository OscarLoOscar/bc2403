import java.util.Comparator;

public class SortByDescending implements Comparator<Integer> {

  @Override
  public int compare(Integer x1, Integer x2) {
    return x1 > x2 ? -1 : 1;
  }
  
}
