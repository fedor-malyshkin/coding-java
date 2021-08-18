package patterns.structural.decorator;

class Client {

  static void main(String[] args) {
    Message message = new TextMessage("The <FORCE> is strong with this one!");
    System.out.println(message.getContent());

    Message decorator = new HtmlEncodedMessage(message);
    System.out.println(decorator.getContent());

    decorator = new Base64EncodedMessage(decorator);
    System.out.println(decorator.getContent());
  }
}
