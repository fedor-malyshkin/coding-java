package patterns.structural.flyweight;

/*
A concrete Flyweight. Instance is shared
*/
class SystemErrorMessage implements ErrorMessage {

  //some error message $errorCode
  private final String messageTemplate;

  //http://somedomain.com/help?error=
  private final String helpUrlBase;

  public SystemErrorMessage(String messageTemplate, String helpUrlBase) {
    this.messageTemplate = messageTemplate;
    this.helpUrlBase = helpUrlBase;
  }

  @Override
  public String getText(String code) {
    return messageTemplate.replace("$errorCode", code) + helpUrlBase + code;
  }

}
