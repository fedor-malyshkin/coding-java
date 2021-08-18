package patterns.structural.flyweight;


import patterns.structural.flyweight.ErrorMessageFactory.ErrorType;

class Client {

  static void main(String[] args) {
    // get a shared instance (heavy in memory for instance)
    SystemErrorMessage msg1 =
        ErrorMessageFactory.getInstance().getError(ErrorType.GenericSystemError);
    System.out.println(msg1.getText("4056"));

    // get a lightweight instance
    UserBannedErrorMessage msg2 = ErrorMessageFactory.getInstance().getUserBannedMessage("1202");
    System.out.println(msg2.getText(null));
  }

}
