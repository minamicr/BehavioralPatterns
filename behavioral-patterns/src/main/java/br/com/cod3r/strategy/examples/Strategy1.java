package br.com.cod3r.strategy.examples;

import java.math.BigDecimal;

public class Strategy1 {

  public static void main(String[] args) {
    BigDecimal value = new BigDecimal("1500.47");
    Acquisition1 acquisition1 = new Acquisition1(value);

    acquisition1.processPayment(new CreditCardPayment1());
    acquisition1.processPayment(new DebitCardPayment1());


  }

}

class Acquisition1 {
  BigDecimal value ;

  public Acquisition1(BigDecimal value){
    this.value = value;
  }

  public void processPayment(PaymentStrategy1 payment){
    payment.pay(value);
  }

}

interface PaymentStrategy1 {
  void pay(BigDecimal value);
}

class CreditCardPayment1 implements PaymentStrategy1 {

  @Override
  public void pay(BigDecimal value) {
    System.out.println(String.format("Credit card payment of %s", value.toString()));
  }
}

class DebitCardPayment1 implements PaymentStrategy1 {

  @Override
  public void pay(BigDecimal value) {
    System.out.println(String.format("Debit card payment for %s", value.toString()));
  }
}