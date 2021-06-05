package br.com.cod3r.template.examples;


class PaymentProcessorExecute {

  //Template method

  public static void main(String[] args) {
    PaymentProcessor paymentProcessor = new PaymentProcessorCreditCard();
    paymentProcessor.processPayment();

  }
}

abstract class PaymentProcessor {

  public void processPayment() {
    prepare();
    validate();
    payment();
    notifyClient();
    finalize();
  }

  protected abstract void payment();

  private void prepare() {
    System.out.println("Selecting products");
  }

  private void validate(){
    System.out.println("Validate register");
  }

  protected void notifyClient(){
    System.out.println("Nofity client");
  }

  protected void finalize() {
    System.out.println("Finalizing purchase");
  }

}

class PaymentProcessorCreditCard extends PaymentProcessor {

  @Override
  protected void payment() {
    System.out.println("Paying with credit card");
  }

  protected void notifyClient() {
    super.notifyClient();
    System.out.println("Finished order number xxx");
  }
}