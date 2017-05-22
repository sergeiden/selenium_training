package ru.stga.training.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by serg on 22.05.2017.
 */
public class CartPage extends Page {

  public CartPage(WebDriver driver) {
    super(driver);
  }

  public List<WebElement> items() {
    return driver.findElements(By.name("remove_cart_item"));
  }

  public WebElement cartSummary() {
    return driver.findElement(By.cssSelector("#order_confirmation-wrapper"));
  }

  public WebElement removeItem() {
    return driver.findElement(By.name("remove_cart_item"));
  }
}
