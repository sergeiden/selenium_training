package ru.stga.training.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

/**
 * Created by serg on 19.04.2017.
 */
public class LoginTest {
  private WebDriver driver;
  private WebDriverWait wait;

  @Before
  public void start() {
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    wait = new WebDriverWait(driver, 10);
  }

  @Test
  public void loginTest() {
    driver.get("http://localhost/litecart/admin/");
    driver.findElement(By.name("username")).sendKeys("admin");
    driver.findElement(By.name("password")).sendKeys("admin");
    driver.findElement(By.xpath(".//*[@id='box-login']/form/div[2]/button")).click();
    driver.findElement(By.id("box-apps-menu-wrapper"));
  }

  @After
  public void stop() {
    driver.quit();
    driver = null;
  }
}
