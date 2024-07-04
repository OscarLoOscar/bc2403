package customer;

import java.math.BigDecimal;
import java.util.Arrays;

public class Item {

  private String desc; // description

  private double price;

  private int quantity;

  public Item(String desc, double price, int quantity) {
    this.desc = desc;
    this.price = price;
    this.quantity = quantity;
  }

  public double subtotal() {
    return BigDecimal.valueOf(this.price) //
        .multiply(BigDecimal.valueOf(this.quantity)) //
        .doubleValue();
  }

  public String toString() {
    return "Item(" //
        + "description=" + this.desc //
        + ", price=" + this.price //
        + ", quantity=" + this.quantity //
        + ")";
  }

  public static void main(String[] args) {
    Item item1 = new Item("APPLE", 4.5, 2);
    System.out.println(item1.subtotal()); // 9.0

    Item item2 = new Item("ORANGE", 5.0, 4);
    System.out.println(item2.subtotal()); // 20.0
    // Item[] items = new Item[2];
    // items[0] = item1;
    // items[1] = item2;

    Order order1 = new Order("V00001"); // ????
    // orders[0] = order1;
    order1.add(item1);
    System.out.println(order1);
    order1.add(item2);
    System.out.println(order1); // Order(orderNo=V00001, items=[Item(description=APPLE, price=4.5, quantity=2), Item(description=ORANGE, price=5.0, quantity=4)])

    System.out.println(order1.total()); // 29.0

    // Order2
    // Order[] orders = new Order[2];
    Customer c = new Customer("sallychan");
    c.add(order1);
    System.out.println(c); // Customer(username=sallychan, orders=[Order(orderNo=V00001, items=[Item(description=APPLEprice=4.5quantity=2), Item(description=ORANGEprice=5.0quantity=4)])])

  }

}
