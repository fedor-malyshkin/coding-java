package patterns.structural.bridge;

import patterns.structural.bridge.abstr.FifoCollection;
import patterns.structural.bridge.abstr.Queue;
import patterns.structural.bridge.impl.SinglyLinkedList;

class Client {

  static void main(String[] args) {
    FifoCollection<Integer> collection = new Queue<>(new SinglyLinkedList<>());
    collection.offer(10);
    collection.offer(40);
    collection.offer(99);

    System.out.println(collection.poll());
    System.out.println(collection.poll());
    System.out.println(collection.poll());
    //
    System.out.println(collection.poll());
  }
}
