package patterns.behavioral.strategy;

import java.util.Collection;

/*
Strategy
*/
interface OrderPrinter {

  void print(Collection<Order> orders);
}
