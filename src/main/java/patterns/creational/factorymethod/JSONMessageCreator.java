package patterns.creational.factorymethod;

import patterns.creational.factorymethod.message.JSONMessage;
import patterns.creational.factorymethod.message.Message;

/**
 * Provides implementation for creating JSON messages
 */
public class JSONMessageCreator extends MessageCreator {

  @Override
  public Message createMessage() {
    return new JSONMessage();
  }


}
