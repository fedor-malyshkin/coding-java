package patterns.structural.proxy;

//Interface implemented by proxy and concrete objects
interface Image {

  Point2D getLocation();

  void setLocation(Point2D point2d);

  void render();

}
