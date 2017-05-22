package ru.stga.training.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.openqa.selenium.support.ui.ExpectedConditions.attributeToBe;

/**
 * Created by serg on 22.05.2017.
 */
public class MainPage extends Page {

  public MainPage(WebDriver driver) {
    super(driver);
  }

  public WebElement cart() {
    return driver.findElement(By.cssSelector(".quantity"));
  }

  public WebElement logo() {
    return driver.findElement(By.cssSelector(".logotype"));
  }

  public void selectProduct() {
    driver.findElement(By.cssSelector("#box-campaigns .link")).click();
  }

  public void ensureCartUpdate(int quantity){
    wait.until(attributeToBe(By.cssSelector(".quantity"), "textContent", Integer.toString(quantity)));
  }
}
