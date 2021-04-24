package patterns.creational.builder;

import lombok.AllArgsConstructor;
import lombok.Data;

//A product in builder pattern
@Data
@AllArgsConstructor
class UserWebDto implements IUserDto {

  private String name;

  private String address;

  private String age;
}
