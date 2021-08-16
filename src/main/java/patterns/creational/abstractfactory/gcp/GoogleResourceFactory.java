package patterns.creational.abstractfactory.gcp;


import patterns.creational.abstractfactory.Instance;
import patterns.creational.abstractfactory.Instance.Capacity;
import patterns.creational.abstractfactory.ResourceFactory;
import patterns.creational.abstractfactory.Storage;

//Factory implementation for Google cloud platform resources
public class GoogleResourceFactory implements ResourceFactory {

  @Override
  public Instance createInstance(Capacity capacity) {
    return new GoogleComputeEngineInstance(capacity);
  }

  @Override
  public Storage createStorage(int capMib) {
    return new GoogleCloudStorage(capMib);
  }


}
