package patterns.structural.decorator;


/**
 * Decorator. Implements component interface
 **/
public class HtmlEncodedMessage implements Message {

  private Message msg;

  public HtmlEncodedMessage(Message msg) {
    this.msg = msg;
  }

  @Override
  public String getContent() {
    return String.format("<H1>%s</H1>", msg.getContent());
  }


}
