package patterns.behavioral.strategy;


import java.util.LinkedList;

/*
Context
*/
class PrintService {

  private OrderPrinter printer;

  PrintService(OrderPrinter printer) {
    this.printer = printer;
  }

  void printOrders(LinkedList<Order> orders) {
    printer.print(orders);
  }
}
