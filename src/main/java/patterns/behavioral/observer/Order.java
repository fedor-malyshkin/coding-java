package patterns.behavioral.observer;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

/*
A concrete subject
*/
@Data
class Order {

  private String id;

  private double shippingCost;
  //cost of items
  private double itemCost;

  private double discount;
  //no of items
  private int count;

  private List<OrderObserver> observers = new ArrayList<>();

  public Order(String id) {
    this.id = id;
  }

  public void attach(OrderObserver observer) {
    observers.add(observer);
  }

  public void detach(OrderObserver observer) {
    observers.remove(observer);
  }

  public double getTotal() {
    return itemCost - discount + shippingCost;
  }

  public void addItem(double price) {
    itemCost += price;
    count++;
    observers.forEach(o -> o.updated(this));
  }

  @Override
  public String toString() {

    return "Order#" + id + "\nItem cost:" + itemCost + "\nNo. of items:" + count
        + "\nShipping cost:" + shippingCost + "\nDiscount:" + discount
        + "\nTotal:" + getTotal();
  }
}
