package patterns.structural.bridge.abstr;

/*
This is the abstraction.
It represents a FIFO collection
*/
public interface FifoCollection<T> {

  //Adds element to collection
  void offer(T element);

  //Removes & returns first element from collection
  T poll();

}
