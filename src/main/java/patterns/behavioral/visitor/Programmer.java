package patterns.behavioral.visitor;

import lombok.Getter;

@Getter
class Programmer extends AbstractEmployee {

  private final String skill;

  public Programmer(String name, String skill) {
    super(name);
    this.skill = skill;
  }

  @Override
  public void accept(Visitor visitor) {
    visitor.visit(this);
  }
}
