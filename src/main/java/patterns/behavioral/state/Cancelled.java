package patterns.behavioral.state;

/*
Concrete state
*/
class Cancelled implements OrderState {

  @Override
  public double handleCancellation() {
    throw new IllegalStateException("Cancelled order. Can't cancel anymore");
  }

}
