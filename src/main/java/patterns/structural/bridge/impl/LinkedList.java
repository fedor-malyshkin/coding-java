package patterns.structural.bridge.impl;

/*
This is the implementor.
Note that this is also an interface as implementor is defining its own hierarchy which not related
at all to the abstraction hierarchy.
*/
public interface LinkedList<T> {

  void addFirst(T element);

  T removeFirst();

  void addLast(T element);

  T removeLast();

  int getSize();
}
