package patterns.structural.proxy;

//Our concrete class providing actual functionality
class BitmapImage implements Image {

  private Point2D location;
  private String name;

  public BitmapImage(String filename) {
    //Loads image from file on disk
    System.out.println("Loaded from disk:" + filename);
    name = filename;
  }

  @Override
  public Point2D getLocation() {
    return location;
  }

  @Override
  public void setLocation(Point2D point2d) {
    location = point2d;
  }

  @Override
  public void render() {
    //renders to screen
    System.out.println("Rendered " + this.name);
  }

}
