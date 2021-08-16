package patterns.creational.prototype;

/**
 * This class represents an abstract prototype & defines the clone method
 */
public abstract class GameUnitPrototype implements Cloneable {

  private Point3D position;

  public GameUnitPrototype() {
    position = Point3D.ZERO;
  }


  public GameUnitPrototype(float x, float y, float z) {
    position = new Point3D(x, y, z);
  }

  @Override
  public GameUnitPrototype clone() throws CloneNotSupportedException {
    GameUnitPrototype unit = (GameUnitPrototype) super.clone();
    unit.initialize();
    return unit;
  }

  protected void initialize() {
    this.position = Point3D.ZERO;
    reset();
  }

  protected abstract void reset();

  public void move(Point3D direction, float distance) {
    Point3D finalMove = direction.normalize();
    finalMove = finalMove.multiply(distance);
    position = position.add(finalMove);
  }

  public Point3D getPosition() {
    return position;
  }
}
