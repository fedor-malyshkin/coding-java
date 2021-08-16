package patterns.creational.prototype;

public class Swordsman extends GameUnitPrototype {

  private String state = "idle";

  public void attack() {
    this.state = "attacking";
  }

  @Override
  public String toString() {
    return "Swordsman " + state + " @ " + getPosition();
  }

  @Override
  protected void reset() {
    state = "idle";
  }


}
