package patterns.behavioral.state;

/*
Concrete state
*/
class New implements OrderState {

  @Override
  public double handleCancellation() {
    System.out.println("It's a new Order. No processing done");
    return 0;
  }


}
