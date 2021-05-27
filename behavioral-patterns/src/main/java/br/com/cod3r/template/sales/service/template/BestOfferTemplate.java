package br.com.cod3r.template.sales.service.template;

import br.com.cod3r.template.sales.model.Cart;

public abstract class BestOfferTemplate {
  protected Cart cart;
  protected Double regularItemsPrice;
  protected Double deliveryTax;
  protected Double priceFactor = 1d;
  protected Double deliveryFactor = 1d;

  public BestOfferTemplate(Cart cart){
    this.cart = cart;
    regularItemsPrice = calculateRegularItemsPrice();
    deliveryTax = calculateDeliveryTax();
  }

  protected double calculateRegularItemsPrice(){
    return cart.getItems().stream()
        .reduce(0d, (x, item) -> x + item.getValue(), Double::sum);

  }

  protected double calculateDeliveryTax(){
    Integer distance = cart.getBuyer().getDistance();
    Double totalWeight = cart.getItems().stream()
        .reduce(0d, (acc, item) -> acc + item.getWeight(), Double::sum);
    return (distance * totalWeight) / 100;
  }

  public double calculateOffer(Cart cart) {
    calibrateVariables();

    return (regularItemsPrice * priceFactor) + (deliveryTax * deliveryFactor);

  }

  public abstract boolean isAppliable();
  public abstract void calibrateVariables();
}
