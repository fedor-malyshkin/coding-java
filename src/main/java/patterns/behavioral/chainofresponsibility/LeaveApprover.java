package patterns.behavioral.chainofresponsibility;

/*
This represents a handler in chain of responsibility
*/
interface LeaveApprover {

  void processLeaveApplication(LeaveApplication application);

  String getApproverRole();
}
