package patterns.behavioral.visitor;

import java.util.Collection;
import java.util.Collections;
import lombok.Data;

@Data
abstract class AbstractEmployee implements Employee {

  private static int employeeIdCounter = 101;
  private int performanceRating;
  private String name;
  private int employeeId;

  public AbstractEmployee(String name) {
    this.name = name;
    employeeId = employeeIdCounter++;
  }

  @Override
  public Collection<Employee> getDirectReports() {
    return Collections.emptyList();
  }


}