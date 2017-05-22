package ru.stga.training.selenium.tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static java.lang.Integer.parseInt;
import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.support.ui.ExpectedConditions.attributeToBe;
import static org.openqa.selenium.support.ui.ExpectedConditions.stalenessOf;

/**
 * Created by serg on 22.05.2017.
 */
public class ProductsAddToCartTests extends TestBase {

  @Test

  public void testAddProductToCart() throws InterruptedException {
    driver.get("http://localhost/litecart/en/");
    int productQuantity = parseInt((driver.findElement(By.cssSelector(".quantity")).getText()));
    int index = productQuantity;
    while (index < productQuantity + 3) {
      click(By.cssSelector("#box-campaigns .link"));
      if (isElementPresent(By.cssSelector("#view-full-page"))) {
        WebElement window = driver.findElement(By.cssSelector("#view-full-page"));
        click(By.cssSelector("#view-full-page"));
        wait.until(stalenessOf(window));
      }
      new Select(driver.findElement(By.cssSelector("select[name='options[Size]']"))).selectByIndex(index - productQuantity + 1);
      click(By.name("add_cart_product"));
      wait.until(attributeToBe(By.cssSelector(".quantity"), "textContent", Integer.toString(index + 1)));
      click(By.cssSelector(".logotype"));
      index++;
    }
    click(By.cssSelector(".quantity"));
    List<WebElement> removeElements = driver.findElements(By.name("remove_cart_item"));
    for (WebElement element : removeElements) {
      WebElement cartSummary = driver.findElement(By.cssSelector("#order_confirmation-wrapper"));
      click(By.name(("remove_cart_item")));
      wait.until(stalenessOf(cartSummary));
    }
    assertTrue(driver.findElements(By.name("remove_cart_item")).size() == 0);
  }
}
