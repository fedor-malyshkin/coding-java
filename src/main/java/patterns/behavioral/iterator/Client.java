package patterns.behavioral.iterator;

class Client {

  static void main(String[] args) {
    Iterator<ThemeColor> iter = ThemeColor.getIterator();
    while (iter.hasNext()) {
      System.out.println(iter.next());
    }
  }

}
