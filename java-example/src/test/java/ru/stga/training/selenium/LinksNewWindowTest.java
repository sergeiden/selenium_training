package ru.stga.training.selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Set;

/**
 * Created by serg on 18.05.2017.
 */
public class LinksNewWindowTest extends TestBase {

  @Test

  public void testLinksInNewWindow() {
    adminLogin();
    driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
    List<WebElement> countries = driver.findElements(By.cssSelector(".table.table-striped.data-table td a:not([title=Edit]"));
    countries.iterator().next().click();
    List<WebElement> links = driver.findElements(By.cssSelector(".fa.fa-external-link"));
    int index = 0;
    String mainWindow = driver.getWindowHandle();
    while (index < links.size()) {
      links = driver.findElements(By.cssSelector(".fa.fa-external-link"));
      links.get(index).click();
      wait.until(ExpectedConditions.numberOfWindowsToBe(2));
      Set<String> handles = driver.getWindowHandles();
      String newWindow = null;
      for (String handle : handles) {
        if (handle != mainWindow) {
          newWindow = handle;
        }
      }
      driver.switchTo().window(newWindow);
      driver.close();
      driver.switchTo().window(mainWindow);
      Assert.assertTrue(driver.getWindowHandles().size() == 1);
      index++;
    }
  }
}
