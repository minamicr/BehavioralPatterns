package br.com.cod3r.template.examples;

class PaymentProcessorExecute2{

  // Template pattern with hook method

  public static void main(String[] args) {
    PaymentProcessor2 paymentProcessor2 = new PaymentProcessorCreditCard2();
    paymentProcessor2.processPayment();

  }

}

abstract class PaymentProcessor2 {
  public void processPayment() {
    prepare();
    validate();
    payment();
    notifyClient();
    extraNotifyClient();
    finalize();
    extraFinalize();

  }

  protected abstract void payment();

  private void prepare() {
    System.out.println("Selecting products");
  }

  private void validate(){
    System.out.println("Validate register");
  }

  private void notifyClient(){
    System.out.println("Nofity client");
  }

  protected void extraNotifyClient(){

  }

  protected void finalize() {
    System.out.println("Finalizing purchase");
  }

  protected void extraFinalize(){

  }

}

class PaymentProcessorCreditCard2 extends PaymentProcessor2{

  @Override
  protected void payment() {
    System.out.println("Payment with credit card");
  }

  protected void extraNotifyClient(){
    System.out.println("extra notification");
  }

  protected void extraFinalize(){
    System.out.println("extra finalize");
  }

}