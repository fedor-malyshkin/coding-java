package patterns.creational.factorymethod;


import patterns.creational.factorymethod.message.Message;

class Client {

  public static void main(String[] args) {
    printMessage(new JSONMessageCreator());

    printMessage(new TextMessageCreator());
  }

  public static void printMessage(MessageCreator creator) {
    Message msg = creator.getMessage();
    System.out.println(msg);
  }
}
