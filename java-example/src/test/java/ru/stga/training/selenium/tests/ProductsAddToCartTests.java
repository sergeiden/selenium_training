package ru.stga.training.selenium.tests;

import org.junit.Test;
import ru.stga.training.selenium.model.Product;

import static org.junit.Assert.assertTrue;

/**
 * Created by serg on 22.05.2017.
 */
public class ProductsAddToCartTests extends TestBase {

  @Test

  public void testAddProductsToCart() {
    app.goToMainPage();
    int initialCart = app.itemsInCartQuantity();
    int addedProductsCount = 0;
    while (addedProductsCount < initialCart + 3) {
      app.addProductToCart(new Product().withQuantity("1").withSize(addedProductsCount + 1));
      app.cartUpdatedTo(addedProductsCount + initialCart + 1);
      app.returnToMainPage();
      addedProductsCount++;
    }
    app.goToCart();
    app.removeAllItemsFromCart();
    app.returnToMainPage();
    assertTrue(app.itemsInCartQuantity() == 0);
  }
}
