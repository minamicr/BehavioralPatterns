package br.com.cod3r.strategy.examples;

import java.math.BigDecimal;

public class Strategy2 {

  //context (Acquisition2)
  //interface (PaymentStrategy2 that receives complete context Acquisition2)
  //concrete class (CreditCardPayment2, DebitCardPayment2)

  public static void main(String[] args) {
    Acquisition2 acquisition2 = new Acquisition2(new BigDecimal("1500.22"));
    acquisition2.processPayment(new CreditCardPayment2());
    acquisition2.processPayment(new DebitCardPayment2());

  }

}

class Acquisition2 {
  BigDecimal value;

  Acquisition2(BigDecimal value) {
    this.value = value;
  }

  public void processPayment(PaymentStrategy2 paymentStrategy2){
    paymentStrategy2.pay(this);
  }
}

interface PaymentStrategy2 {
  void pay(Acquisition2 acquisition2);

}

class CreditCardPayment2 implements PaymentStrategy2{

  @Override
  public void pay(Acquisition2 acquisition2) {
    System.out.println("Payment with credit card " + acquisition2.value);
  }

}

class DebitCardPayment2 implements PaymentStrategy2 {


  @Override
  public void pay(Acquisition2 acquisition2) {
    System.out.println("Payment with debit card " + acquisition2.value);
  }
}