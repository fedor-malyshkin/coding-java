package patterns.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

/*
Flyweight factory. Returns shared flyweight based on key
*/
class ErrorMessageFactory {

  private static final ErrorMessageFactory FACTORY = new ErrorMessageFactory();
  private Map<ErrorType, SystemErrorMessage> errorMessages = new HashMap<>();

  private ErrorMessageFactory() {
    errorMessages.put(ErrorType.GenericSystemError,
                      new SystemErrorMessage(
                          "A genetic error of type $errorCode occured. Please refer to:\n",
                          "http://google.com/q="));
    errorMessages.put(ErrorType.PageNotFoundError,
                      new SystemErrorMessage(
                          "Page not foun. An error of type $errorCode occured. Please refer to:\n",
                          "http://google.com/q="));
  }

  public static ErrorMessageFactory getInstance() {
    return FACTORY;
  }

  public SystemErrorMessage getError(ErrorType type) {
    return errorMessages.get(type);
  }

  public UserBannedErrorMessage getUserBannedMessage(String caseId) {
    return new UserBannedErrorMessage(caseId);
  }

  //This serves as key for getting flyweight instance
  public enum ErrorType {GenericSystemError, PageNotFoundError, ServerError}
}
