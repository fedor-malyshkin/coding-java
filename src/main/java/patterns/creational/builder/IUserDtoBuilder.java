package patterns.creational.builder;

import java.time.LocalDate;

//Abstract builder
interface IUserDtoBuilder {

  //methods to build "parts" of product at a time
  IUserDtoBuilder withFirstName(String fname);

  IUserDtoBuilder withLastName(String lname);

  IUserDtoBuilder withBirthday(LocalDate date);

  IUserDtoBuilder withAddress(Address address);

  //method to "assemble" final product
  IUserDto build();

  //(optional) method to fetch already built object
  IUserDto getUserDto();
}

