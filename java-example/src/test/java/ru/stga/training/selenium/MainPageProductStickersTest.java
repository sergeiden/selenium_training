package ru.stga.training.selenium;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by serg on 03.05.2017.
 */
public class MainPageProductStickersTest {

  private WebDriver driver;

  private WebDriverWait wait;

  @Before
  public void start() {
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    wait = new WebDriverWait(driver, 10);

  }

  @Test
  public void testProductStickers() {

    driver.get("http://localhost/litecart/");

    List<WebElement> products = driver.findElements(By.cssSelector(".col-xs-halfs.col-sm-thirds.col-md-fourths.col-lg-fifths"));
    for (WebElement product : products) {
      List<WebElement> sticker = product.findElements(By.cssSelector(".sticker"));
      System.out.println(sticker.size());
      Assert.assertEquals(sticker.size(), 1);
    }
  }

  @After
  public void stop() {
    driver.quit();
    driver = null;
  }
}
