package com.bootcamp.demo2403;

import java.util.LinkedList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode
public class Customer {
  private String name;
  private List<Order> orders; // c1.getOrders().size()

  // public Customer(String name, List<Order> orders) {
  //   name = this.name;
  //   orders = this.orders;
  // }

  public Customer(String name) {
    name = this.name;
    orders = new LinkedList<>();
  }

  public void add(Order order) {
    orders.add(order);
  }

  public int orderCount() {
    return this.getOrders().size();
  }

  public boolean isVIP() {
    return this.orderCount() >= 10;
  }

  // static method: input parameter -> produce -> output
  // instance method: Class attribute -> similar to static method parameter
  public static int orderCount(Customer customer) {
    return customer.orderCount();
  }

  
}
