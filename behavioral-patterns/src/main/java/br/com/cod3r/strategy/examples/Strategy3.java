package br.com.cod3r.strategy.examples;

import java.math.BigDecimal;

public class Strategy3 {

  //context (Acquisition3)
  //context interface (Payment3)
  //strategy interface (PaymentStrategy3 that receives interface Payment3)
  //concrete class (CreditCardPayment3, DebitCardPayment3)

  public static void main(String[] args) {
    Acquisition3 acquisition3 = new Acquisition3(new BigDecimal("1500.22"));
    acquisition3.processPayment(new CreditCardPayment3());
    acquisition3.processPayment(new DebitCardPayment3());

  }

}

interface Payment3 {
  BigDecimal getValue();
}

class Acquisition3 implements Payment3 {
  BigDecimal value;

  Acquisition3(BigDecimal value) {
    this.value = value;
  }

  public void processPayment(PaymentStrategy3 paymentStrategy3){
    paymentStrategy3.pay(this);
  }

  @Override
  public BigDecimal getValue() {
    return value;
  }
}

interface PaymentStrategy3 {
  void pay(Payment3 payment3);

}

class CreditCardPayment3 implements PaymentStrategy3{

  @Override
  public void pay(Payment3 payment3) {
    System.out.println("Payment with credit card " + payment3.getValue());
  }

}

class DebitCardPayment3 implements PaymentStrategy3 {


  @Override
  public void pay(Payment3 payment3) {
    System.out.println("Payment with debit card " + payment3.getValue());
  }
}
