package customer;

import java.math.BigDecimal;
import java.util.Arrays;

public class Order {

  private String orderNo;

  private Item[] items;

  public Order(String orderNo) {
    this.orderNo = orderNo;
    this.items = new Item[0];
  }

  public double total() {
    BigDecimal total = BigDecimal.valueOf(0.0d);
    for (int i = 0; i < items.length; i++) {
      total = total.add(BigDecimal.valueOf(items[i].subtotal()));
    }
    return total.doubleValue();
  }

  public void add(Item item) {
    Item[] copyArr = this.items;
    this.items = new Item[this.items.length + 1];
    int idx = 0;
    for (int i = 0; i < copyArr.length; i++) {
      items[idx++] = copyArr[i];
    }
    items[idx] = item;
  }

  public String toString() {
    return "Order(" //
        + "orderNo=" + this.orderNo //
        + ", items=" + Arrays.toString(this.items) //
        + ")";
  }

}
