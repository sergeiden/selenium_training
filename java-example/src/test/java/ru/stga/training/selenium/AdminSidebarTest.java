package ru.stga.training.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by serg on 02.05.2017.
 */
public class AdminSidebarTest {
  private WebDriver driver;

  private WebDriverWait wait;

  @Before
  public void start() {
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    wait = new WebDriverWait(driver, 10);

  }

  @Test
  public void testAdminSidebar() {

    driver.get("http://localhost/litecart/admin/");
    driver.findElement(By.name("username")).sendKeys("admin");
    driver.findElement(By.name("password")).sendKeys("admin");
    driver.findElement(By.cssSelector(".btn[name=login]")).click();
    driver.findElement(By.id("search"));

    driver.findElement(By.cssSelector("#box-apps-menu #app-:nth-child(1)")).click();
    driver.findElement(By.tagName("h1"));
    driver.findElement(By.cssSelector("#doc-template")).click();
    driver.findElement(By.tagName("h1"));
    driver.findElement(By.cssSelector("#doc-logotype")).click();
    driver.findElement(By.tagName("h1"));

    driver.findElement(By.cssSelector(".list-vertical #app-:nth-child(2)")).click();
    driver.findElement(By.cssSelector("#doc-product_groups")).click();
    driver.findElement(By.tagName("h1"));
    driver.findElement(By.cssSelector("#doc-catalog")).click();
    driver.findElement(By.tagName("h1"));
    driver.findElement(By.cssSelector("#doc-option_groups")).click();
    driver.findElement(By.tagName("h1"));
    driver.findElement(By.cssSelector("#doc-manufacturers")).click();
    driver.findElement(By.tagName("h1"));
    driver.findElement(By.cssSelector("#doc-suppliers")).click();
    driver.findElement(By.tagName("h1"));
    driver.findElement(By.cssSelector("#doc-delivery_statuses")).click();
    driver.findElement(By.tagName("h1"));
    driver.findElement(By.cssSelector("#doc-sold_out_statuses")).click();
    driver.findElement(By.tagName("h1"));
    driver.findElement(By.cssSelector("#doc-quantity_units")).click();
    driver.findElement(By.tagName("h1"));
    driver.findElement(By.cssSelector("#doc-csv")).click();
    driver.findElement(By.tagName("h1"));

    driver.findElement(By.cssSelector(".list-vertical #app-:nth-child(3)")).click();
    driver.findElement(By.tagName("h1"));

    driver.findElement(By.cssSelector(".list-vertical #app-:nth-child(4)")).click();
    driver.findElement(By.tagName("h1"));

    driver.findElement(By.cssSelector(".list-vertical #app-:nth-child(5)")).click();
    driver.findElement(By.tagName("h1"));
    driver.findElement(By.cssSelector("#doc-csv")).click();
    driver.findElement(By.tagName("h1"));
    driver.findElement(By.cssSelector("#doc-customers")).click();
    driver.findElement(By.tagName("h1"));
    driver.findElement(By.cssSelector("#doc-newsletter")).click();
    driver.findElement(By.tagName("h1"));

    driver.findElement(By.cssSelector(".list-vertical #app-:nth-child(6)")).click();
    driver.findElement(By.tagName("h1"));

    driver.findElement(By.cssSelector(".list-vertical #app-:nth-child(7)")).click();
    driver.findElement(By.tagName("h1"));
    driver.findElement(By.cssSelector("#doc-storage_encoding")).click();
    driver.findElement(By.tagName("h1"));
    driver.findElement(By.cssSelector("#doc-languages")).click();
    driver.findElement(By.tagName("h1"));

    driver.findElement(By.cssSelector(".list-vertical #app-:nth-child(8)")).click();
    driver.findElement(By.tagName("h1"));
    driver.findElement(By.cssSelector("#doc-customer")).click();
    driver.findElement(By.tagName("h1"));
    driver.findElement(By.cssSelector("#doc-shipping")).click();
    driver.findElement(By.tagName("h1"));
    driver.findElement(By.cssSelector("#doc-payment")).click();
    driver.findElement(By.tagName("h1"));
    driver.findElement(By.cssSelector("#doc-order")).click();
    driver.findElement(By.tagName("h1"));
    driver.findElement(By.cssSelector("#doc-order_total")).click();
    driver.findElement(By.tagName("h1"));
    driver.findElement(By.cssSelector("#doc-jobs")).click();
    driver.findElement(By.tagName("h1"));

    driver.findElement(By.cssSelector(".list-vertical #app-:nth-child(9)")).click();
    driver.findElement(By.tagName("h1"));
    driver.findElement(By.cssSelector("#doc-order_statuses")).click();
    driver.findElement(By.tagName("h1"));
    driver.findElement(By.cssSelector("#doc-orders")).click();
    driver.findElement(By.tagName("h1"));

    driver.findElement(By.cssSelector(".list-vertical #app-:nth-child(10)")).click();
    driver.findElement(By.tagName("h1"));
    driver.findElement(By.cssSelector("#doc-csv")).click();
    driver.findElement(By.tagName("h1"));
    driver.findElement(By.cssSelector("#doc-pages")).click();
    driver.findElement(By.tagName("h1"));

    driver.findElement(By.cssSelector(".list-vertical #app-:nth-child(11)")).click();
    driver.findElement(By.tagName("h1"));
    driver.findElement(By.cssSelector("#doc-monthly_sales")).click();
    driver.findElement(By.tagName("h1"));
    driver.findElement(By.cssSelector("#doc-most_sold_products")).click();
    driver.findElement(By.tagName("h1"));
    driver.findElement(By.cssSelector("#doc-most_shopping_customers")).click();
    driver.findElement(By.tagName("h1"));

    driver.findElement(By.cssSelector(".list-vertical #app-:nth-child(12)")).click();
    driver.findElement(By.tagName("h1"));
    driver.findElement(By.cssSelector("#doc-store_info")).click();
    driver.findElement(By.tagName("h1"));
    driver.findElement(By.cssSelector("#doc-defaults")).click();
    driver.findElement(By.tagName("h1"));
    driver.findElement(By.cssSelector("#doc-general")).click();
    driver.findElement(By.tagName("h1"));
    driver.findElement(By.cssSelector("#doc-listings")).click();
    driver.findElement(By.tagName("h1"));
    driver.findElement(By.cssSelector("#doc-images")).click();
    driver.findElement(By.tagName("h1"));
    driver.findElement(By.cssSelector("#doc-checkout")).click();
    driver.findElement(By.tagName("h1"));
    driver.findElement(By.cssSelector("#doc-advanced")).click();
    driver.findElement(By.tagName("h1"));
    driver.findElement(By.cssSelector("#doc-security")).click();
    driver.findElement(By.tagName("h1"));

    driver.findElement(By.cssSelector(".list-vertical #app-:nth-child(13)")).click();
    driver.findElement(By.tagName("h1"));

    driver.findElement(By.cssSelector(".list-vertical #app-:nth-child(14)")).click();
    driver.findElement(By.tagName("h1"));
    driver.findElement(By.cssSelector("#doc-tax_rates")).click();
    driver.findElement(By.tagName("h1"));
    driver.findElement(By.cssSelector("#doc-tax_classes")).click();
    driver.findElement(By.tagName("h1"));

    driver.findElement(By.cssSelector(".list-vertical #app-:nth-child(15)")).click();
    driver.findElement(By.tagName("h1"));
    driver.findElement(By.cssSelector("#doc-search")).click();
    driver.findElement(By.tagName("h1"));
    driver.findElement(By.cssSelector("#doc-scan")).click();
    driver.findElement(By.tagName("h1"));
    driver.findElement(By.cssSelector("#doc-csv")).click();
    driver.findElement(By.tagName("h1"));

    driver.findElement(By.cssSelector(".list-vertical #app-:nth-child(16)")).click();
    driver.findElement(By.tagName("h1"));

    driver.findElement(By.cssSelector(".list-vertical #app-:nth-child(17)")).click();
    driver.findElement(By.tagName("h1"));

  }

  @After
  public void stop() {
    driver.quit();
    driver = null;
  }
}
