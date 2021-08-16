package patterns.creational.abstractfactory;

//Represents an abstract product
public interface Instance {

  void start();

  void attachStorage(Storage storage);

  void stop();

  enum Capacity {
    micro, small, large
  }
}
