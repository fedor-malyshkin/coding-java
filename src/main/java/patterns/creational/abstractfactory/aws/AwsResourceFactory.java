package patterns.creational.abstractfactory.aws;

import patterns.creational.abstractfactory.Instance;
import patterns.creational.abstractfactory.Instance.Capacity;
import patterns.creational.abstractfactory.ResourceFactory;
import patterns.creational.abstractfactory.Storage;

//Factory implementation for Google cloud platform resources
public class AwsResourceFactory implements ResourceFactory {

  @Override
  public Instance createInstance(Capacity capacity) {
    return new Ec2Instance(capacity);
  }

  @Override
  public Storage createStorage(int capMib) {
    return new S3Storage(capMib);
  }


}
