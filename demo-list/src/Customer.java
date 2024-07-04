import java.util.Objects;

public class Customer {

  private String name;

  public Customer(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  @Override
  public String toString() {
    return "Customer(" //
        + "name=" + this.name //
        + ")";
  }

  // equals()
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (!(obj instanceof Customer))
      return false;
    Customer customer = (Customer) obj;
    return Objects.equals(this.name, customer.getName());
  }

  // hashCode()
  // @Override
  // public int hashCode() {
  // return Objects.hash(this.name);
  // }

}
