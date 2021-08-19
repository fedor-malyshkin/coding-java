package patterns.behavioral.visitor;

import java.util.Collection;

interface Employee {

  int getPerformanceRating();

  void setPerformanceRating(int rating);

  Collection<Employee> getDirectReports();

  int getEmployeeId();

  void accept(Visitor visitor);
}
