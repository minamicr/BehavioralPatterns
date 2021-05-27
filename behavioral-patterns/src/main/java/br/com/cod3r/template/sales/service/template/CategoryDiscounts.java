package br.com.cod3r.template.sales.service.template;

import br.com.cod3r.template.sales.model.Cart;
import br.com.cod3r.template.sales.model.Category;
import java.util.HashMap;
import java.util.Map;

public class CategoryDiscounts extends BestOfferTemplate{
  Map<Category, Double> discountsByCategory;

  public CategoryDiscounts(Cart cart){
    super(cart);
    loadDiscounts();
  }

  public void loadDiscounts() {
    discountsByCategory = new HashMap<Category, Double>();
    discountsByCategory.put(Category.ELETRONICS, 0.03);
    discountsByCategory.put(Category.CLOTHES, 0.05);
  }

  @Override
  public boolean isAppliable() {
    return true;
  }

  @Override
  public void calibrateVariables() {
    priceFactor = cart.getItems().stream()
        .reduce(0d,
            (acc, item) -> acc + (
              (discountsByCategory.get(item.getCategory()) != null ?
                (1 - discountsByCategory.get(item.getCategory()))
                : 1d))
            , Double::sum);

  }
}
