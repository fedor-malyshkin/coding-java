package patterns.behavioral.iterator;

/*
Iterator interface allowing to iterate over
values of an aggregate
*/
interface Iterator<T> {

  boolean hasNext();

  T next();
}
