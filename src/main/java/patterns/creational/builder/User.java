package patterns.creational.builder;

import java.time.LocalDate;
import lombok.Data;

//Entity class used to construct the DTO
@Data
class User {

  private String firstName;
  private String lastName;
  private LocalDate birthday;
  private Address address;
}
