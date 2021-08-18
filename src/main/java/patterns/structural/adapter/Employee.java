package patterns.structural.adapter;

import lombok.Data;

/**
 * An existing class used in our system
 * Adaptee
 */
@Data
public class Employee {

  private String fullName;

  private String jobTitle;

  private String officeLocation;

}
