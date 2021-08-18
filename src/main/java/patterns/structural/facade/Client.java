package patterns.structural.facade;


import patterns.structural.facade.email.Email;
import patterns.structural.facade.email.EmailFacade;
import patterns.structural.facade.email.Mailer;
import patterns.structural.facade.email.Stationary;
import patterns.structural.facade.email.StationaryFactory;
import patterns.structural.facade.email.Template;
import patterns.structural.facade.email.Template.TemplateType;
import patterns.structural.facade.email.TemplateFactory;

class Client {

  void main(String[] args) {
    Order order = new Order("101", 99.99);
    EmailFacade facade = new EmailFacade();

    boolean result = facade.sendOrderEmail(order);

    System.out.println("Order Email " + (result ? "sent!" : "NOT sent..."));

  }

  boolean sendOrderEmailWithoutFacade(Order order) {
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
