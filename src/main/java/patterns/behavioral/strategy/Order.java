package patterns.behavioral.strategy;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;

@Getter
class Order {

  private final String id;

  private LocalDate date;

  private Map<String, Double> items = new HashMap<>();

  @Setter
  private double total;

  Order(String id) {
    this.id = id;
    date = LocalDate.now();
  }


  void addItem(String name, double price) {
    items.put(name, price);
    total += price;
  }

}
