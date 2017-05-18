package ru.stga.training.selenium;

import org.junit.After;
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
 * Created by serg on 02.05.2017.
 */
public class AdminSidebarTest extends TestBase {

  @Test
  public void testAdminSidebar() {

    driver.get("http://localhost/litecart/admin/");
    driver.findElement(By.name("username")).sendKeys("admin");
    driver.findElement(By.name("password")).sendKeys("admin");
    driver.findElement(By.cssSelector(".btn[name=login]")).click();
    driver.findElement(By.id("search"));

    int index = 0;
    int sidebarMenuElementsCount = driver.findElements(By.cssSelector("#app-")).size();
    while (index < sidebarMenuElementsCount) {
      List<WebElement> sidebarMenuElements = driver.findElements(By.cssSelector("#app-"));
      sidebarMenuElements.get(index).click();
      driver.findElement(By.cssSelector("h1"));
      index++;

      List<WebElement> submenuElements = driver.findElements(By.cssSelector(".docs span.name"));
      int submenuElementsCount = submenuElements.size();
      if (submenuElementsCount > 0) {
        int subIndex = 0;
        while (subIndex < submenuElementsCount) {
          submenuElements = driver.findElements(By.cssSelector(".docs span.name"));
          submenuElements.get(subIndex).click();
          driver.findElement(By.tagName("h1"));
          subIndex++;
        }
      }
    }
  }
}
