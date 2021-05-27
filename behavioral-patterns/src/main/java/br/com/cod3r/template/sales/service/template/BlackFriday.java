package br.com.cod3r.template.sales.service.template;

import br.com.cod3r.template.sales.model.Cart;
import java.time.LocalDate;
import java.time.Month;

public class BlackFriday extends BestOfferTemplate {

  public BlackFriday(Cart cart){
    super(cart);
  }

  @Override
  public boolean isAppliable() {
    return LocalDate.now().getMonth().equals(Month.NOVEMBER);
  }

  @Override
  public void calibrateVariables() {
    priceFactor = 0.75;
  }
}
