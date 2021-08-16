package patterns.creational.prototype;

import lombok.Value;

@Value
class Point3D {

  public static final Point3D ZERO = new Point3D(0, 0, 0);
  float xc;
  float yc;
  float zc;

  public Point3D normalize() {
    // do nothing in fact
    return this;
  }

  public Point3D multiply(float distance) {
    // do nothing in fact
    return this;
  }

  public Point3D add(Point3D finalMove) {
    // do nothing in fact
    return this;
  }
}
