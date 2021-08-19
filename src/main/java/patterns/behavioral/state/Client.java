package patterns.behavioral.state;

class Client {

  static void main(String[] args) {
    Order order = new Order();

    order.paymentSuccessful();
    order.dispatched();

    order.cancel();
  }
}
