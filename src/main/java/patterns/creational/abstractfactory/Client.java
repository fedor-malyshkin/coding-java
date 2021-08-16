package patterns.creational.abstractfactory;

import patterns.creational.abstractfactory.Instance.Capacity;
import patterns.creational.abstractfactory.aws.AwsResourceFactory;
import patterns.creational.abstractfactory.gcp.GoogleResourceFactory;

class Client {

  private final ResourceFactory factory;

  public Client(ResourceFactory factory) {
    this.factory = factory;
  }

  static void main(String[] args) {
    Client aws = new Client(new AwsResourceFactory());
    Instance i1 = aws.createServer(Capacity.micro, 20480);
    i1.start();
    i1.stop();

    System.out.println("***************************************");
    Client gcp = new Client(new GoogleResourceFactory());
    i1 = gcp.createServer(Capacity.micro, 20480);
    i1.start();
    i1.stop();

  }

  public Instance createServer(Instance.Capacity cap, int storageMib) {
    Instance instance = factory.createInstance(cap);
    Storage storage = factory.createStorage(storageMib);
    instance.attachStorage(storage);
    return instance;
  }


}
