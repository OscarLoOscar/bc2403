package customer; // subfolder

import java.util.Arrays;

public class Customer {

  private String username;

  // One Customer has many orders
  private Order[] orders;

  public Customer(String username) {
    this.username = username;
    this.orders = new Order[0];
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public void add(Order order) {
    Order[] copyArr = this.orders;
    this.orders = new Order[this.orders.length + 1];
    int idx = 0;
    for (int i = 0; i < copyArr.length; i++) {
      this.orders[idx++] = copyArr[i];
    }
    this.orders[idx] = order;
  }

  public String toString() {
    return "Customer(" //
        + "username=" + this.username //
        + ", orders=" + Arrays.toString(this.orders) //
        + ")";
  }

  public static void main(String[] args) {
    Customer customer = new Customer("John"); // create a new object
    customer.setUsername("Peter");

  }

}
