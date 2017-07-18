package ru.stga.training.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class MyFirstTest {

  private WebDriver driver;

  private WebDriverWait wait;

  @Before
    public void start() {
    FirefoxOptions options = new FirefoxOptions().setLegacy(true);
//    options.setBinary(new FirefoxBinary(new File("d:\\Tools\\FFNightly\\firefox.exe")));
    options.setBinary(new FirefoxBinary(new File("C:\\Program Files\\Mozilla Firefox\\firefox.exe")));
    driver = new FirefoxDriver(options);
    System.out.println(((HasCapabilities) driver).getCapabilities());
    wait = new WebDriverWait(driver, 10);
  }

//  @Test
//  public void myFirstTest() {
//    driver.get("http://www.google.com");
//    driver.findElement(By.name("q")).sendKeys("webdriver");
//    driver.findElement(By.name("btnG")).click();
//    wait.until(titleIs("webdriver - Поиск в Google"));
//  }

  @Test
  public void myTest() {
    driver.get("https://selenium2.ru/docs/introduction.html#chapter01-reference");
    String text = driver.findElement(By.cssSelector("#chapter01-reference")).getText();
    List <WebElement> sections = driver.findElements(By.cssSelector(".section"));
    for (WebElement section : sections){
      System.out.println(section.getText());
    }

//    System.out.println(text);
//
//    System.out.println(driver.getPageSource());
  }






  @After
  public void stop(){
    driver.quit();
    driver = null;
  }
}
