package patterns.behavioral.interpreter;

/*
Abstract expression
*/
interface PermissionExpression {

  boolean interpret(User user);
}
