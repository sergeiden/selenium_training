package ru.stga.training.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by serg on 20.05.2017.
 */
public class ProductDetailsLogTest extends TestBaseOld {

  @Test

  public void testProductDetailsLog(){
    driver.manage().logs().get("browser");
    adminLogin();
    driver.get("http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=1");
    List<WebElement> products = driver.findElements(By.xpath("//td/img/../a"));
    int index = 0;
    while (index < products.size()){
      products = driver.findElements(By.xpath("//td/img/../a"));
      products.get(index).click();
      assertTrue(driver.manage().logs().get("browser").getAll().size() == 0);
      driver.navigate().back();
      index++;
    }
  }
}
