package patterns.creational.builder;

import java.time.LocalDate;
import java.time.Period;

//The concrete builder for UserWebDTO
class UserWebDtoBuilder implements IUserDtoBuilder {

  private String firstName;
  private String lastName;
  private String age;
  private String address;
  private UserWebDto dto;

  @Override
  public IUserDtoBuilder withFirstName(String fname) {
    firstName = fname;
    return this;
  }

  @Override
  public IUserDtoBuilder withLastName(String lname) {
    lastName = lname;
    return this;
  }

  @Override
  public IUserDtoBuilder withBirthday(LocalDate date) {
    Period ageInYears = Period.between(date, LocalDate.now());
    age = Integer.toString(ageInYears.getYears());
    return this;
  }

  @Override
  public IUserDtoBuilder withAddress(Address address) {
    this.address = address.getHouseNumber() + ", " + address.getStreet()
        + "\n" + address.getCity() + "\n" + address.getState() + " " + address.getZipcode();
    return this;
  }

  @Override
  public IUserDto build() {
    dto = new UserWebDto(firstName + " " + lastName, address, age);
    return dto;
  }

  @Override
  public IUserDto getUserDto() {
    return dto;
  }


}
