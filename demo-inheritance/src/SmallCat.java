public class SmallCat extends Cat {

  private double weight;
  
  public SmallCat(int age, String name, double weight) {
    super(age, name); // Construct a cat object -> construct animal object
    this.weight = weight;
  }

  public double getWeight() {
    return this.weight;
  }

  public static void main(String[] args) {
    SmallCat sc = new SmallCat(3, "Jenny", 3.2); // super(); -> Cat()

    System.out.println(sc.getAge()); // 3
    System.out.println(sc.getAnimalName()); // name=Jenny
    System.out.println(sc.getCatName()); // null
    System.out.println(sc.getName()); // "Jenny"
    System.out.println(sc.getWeight()); // 3.2

  }
}
