package patterns.structural.facade.email;

import patterns.structural.facade.Order;
import patterns.structural.facade.email.Template.TemplateType;

//Facade provides simple methods for client to use
public class EmailFacade {

  public boolean sendOrderEmail(Order order) {
    Template template = TemplateFactory.createTemplateFor(TemplateType.Email);
    Stationary stationary = StationaryFactory.createStationary();
    Email email = Email.getBuilder()
        .withTemplate(template)
        .withStationary(stationary)
        .forObject(order)
        .build();
    Mailer mailer = Mailer.getMailer();
    return mailer.send(email);
  }
}
