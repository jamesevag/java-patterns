package patterns.creational.abstractFactory.aws;

import patterns.creational.abstractFactory.Instance;
import patterns.creational.abstractFactory.ResourceFactory;
import patterns.creational.abstractFactory.Storage;

//Factory implementation for Google cloud platform resources
public class AwsResourceFactory implements ResourceFactory {

    @Override
    public Instance createInstance(Instance.Capacity capacity) {
        return new Ec2Instance(capacity);
    }

    @Override
    public Storage createStorage(int capMib) {
        return (Storage) new S3Storage(capMib);
    }


}
