package ru.stga.training.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;

/**
 * Created by serg on 14.05.2017.
 */
public class UserRegistrationTest extends TestBaseOld {

  @Test

  public void testUserRegistration(){

    String zipcode = randomNumeric(5);
    String email = randomAlphabetic(6) + "@gmail.com";
    String password = "password";

    newUserRegistration(zipcode, email, password);
    userLogout();
    userLogin(email, password);
    userLogout();
  }

  private void userLogin(String email, String password) {
    driver.findElement(By.cssSelector("#sidebar [name=email]")).sendKeys(email);
    driver.findElement(By.cssSelector("#sidebar [name=password]")).sendKeys(password);
    driver.findElement(By.cssSelector("#sidebar [name=login]")).click();
  }

  private void userLogout() {
    driver.findElement(By.cssSelector("#box-account a[href $= logout]")).click();
  }

  private void newUserRegistration(String zipcode, String email, String password) {
    driver.get("http://localhost/litecart/");
    driver.findElement(By.cssSelector(".text-center a")).click();
    driver.findElement(By.name("tax_id")).sendKeys("123456789");
    driver.findElement(By.name("company")).sendKeys("TestCompany");
    driver.findElement(By.name("firstname")).sendKeys("Vasya");
    driver.findElement(By.name("lastname")).sendKeys("Pupkin");
    driver.findElement(By.name("address1")).sendKeys("Lenina, 20-56");
    driver.findElement(By.name("address2")).sendKeys("stroenie 2");
    driver.findElement(By.name("postcode")).sendKeys(zipcode);
    driver.findElement(By.name("city")).sendKeys("Mycity");
    new Select(driver.findElement(By.name("country_code"))).selectByVisibleText("United States");
    new Select(driver.findElement(By.name("zone_code"))).selectByVisibleText("California");
    driver.findElement(By.cssSelector("#box-create-account [name=email]")).sendKeys(email);
    driver.findElement(By.name("phone")).sendKeys("478-58-96");
    driver.findElement(By.cssSelector("#box-create-account [name=password]")).sendKeys(password);
    driver.findElement(By.name("confirmed_password")).sendKeys("password");
    driver.findElement(By.cssSelector("#box-create-account [name=create_account]")).click();
  }
}
