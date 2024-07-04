package cat;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Cat extends Animal {

  // You have to understand the difference bewteen :
  // 1. <T extends Cat> void addCat4(List<T> cats) -> List<Cat>
  // 2. void addCat(List<? extends Cat> cats) -> List<Cat> or List<RedCat>

  public static <T extends Cat> void addCat4(List<T> cats) { // List<Animal>, add(new Cat()), add(new RedCat())
    
  }

  public static void addCat(List<? super Cat> cats) { // List<Cat> or List<Animal>
    // Compile time check
    cats.add(new Cat()); // OK
    cats.add(new RedCat()); // OK
    
    // becuase compiler does not know the list type is List<Cat> or List<Animal>
    // so, during the compile-time, you can add Animal(), coz it may be wrong.
    // cats.add(new Animal()); 

    
  }

  public static void addCat2(List<Cat> cats) { // Cat or below

  }

  public static <T extends Cat> void addCat3(List<T> cats) { // Cat or below

  }

  public static void main(String[] args) {
    addCat(new ArrayList<>(List.of(new Animal(), new Animal())));
    addCat(new ArrayList<>(List.of(new Cat(), new Cat())));
    addCat(new ArrayList<>(List.of(new RedCat(), new RedCat()))); // ??

    // addCat2(new ArrayList<>(List.of(new Animal(), new Animal()))); //
    addCat2(new ArrayList<>(List.of(new Cat(), new Cat())));
    
    
    List<RedCat> rl = new ArrayList<>(List.of(new RedCat(), new RedCat()));
    // addCat2(rl); // NOT OK, compile-time check -> check type of object reference
    
    addCat2(new ArrayList<>(List.of(new RedCat(), new RedCat()))); // OK? why?
    // new ArrayList<>(List.of(new RedCat(), new RedCat())) -> because it can be stored in List<Cat> or List<Animal>

    List<Cat> cats = new LinkedList<>();
    cats.add(new RedCat());
    cats.add(new Cat());
    // cats.add(new Animal());
    addCat4(cats);

    List<RedCat> redCats = new LinkedList<>();
    addCat4(redCats);

    List<Animal> animals = new LinkedList<>();
    // addCat4(animals);

  }


}
