package ru.stga.training.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by serg on 22.05.2017.
 */
public class AddProductPage extends Page {

  public AddProductPage(WebDriver driver) {
    super(driver);
  }

  public void selectSize(int size) {
    new Select(driver.findElement(By.cssSelector("select[name='options[Size]']"))).selectByIndex(size);
  }

  public WebElement quantity() {
    driver.findElement(By.cssSelector("input[name='quantity']")).clear();
    return driver.findElement(By.cssSelector("input[name='quantity']"));
  }

  public void addToCart() {
    driver.findElement(By.name("add_cart_product")).click();
  }
}