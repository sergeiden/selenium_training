package ru.stga.training.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by serg on 14.05.2017.
 */
public class AddNewProductTest extends TestBase {

  @Test

  public void testAddNewProduct() {
    adminLogin();
    int productsBefore = productsCount();
    goToAddProductPage();
    fillNewProductForm();
    submitNewProductForm();
    int productsAfter = productsCount();
    assertEquals(productsAfter, productsBefore + 1);
  }

  private void submitNewProductForm() {
    click(By.cssSelector("#main [type=submit]"));
  }

  private void fillNewProductForm() {
    fillGeneralTab();
    fillInformationTab();
    fillPricesTab();
  }

  private void fillPricesTab() {
    click(By.cssSelector("a[href='#tab-prices']"));
    type(By.name("purchase_price"), "55");
    new Select(driver.findElement(By.name("purchase_price_currency_code"))).selectByVisibleText("US Dollars");
    type(By.name("gross_prices[USD]"), "60");
  }

  private void fillInformationTab() {
    click(By.cssSelector("a[href='#tab-information']"));
    new Select(driver.findElement(By.name("manufacturer_id"))).selectByVisibleText("ACME Corp.");
    type(By.name("keywords"), "New Duck");
    type(By.name("short_description[en]"), "New Duck short description");
    type(By.cssSelector(".trumbowyg-editor"), "New Duck - full description");
    type(By.name("attributes[en]"), "New\nDuck\nYellow");
    type(By.name("head_title[en]"), "New Yellow Duck");
  }

  private void fillGeneralTab() {
    click(By.xpath("//label[contains(., \"Enabled\")]"));
    type(By.name("code"), "001");
    type(By.name("name[en]"), "New Duck");
    click(By.cssSelector("[data-name='Subcategory']"));
    new Select(driver.findElement(By.name("default_category_id"))).selectByVisibleText("Root");
    type(By.name("sku"), "123");
    type(By.name("gtin"), "123");
    type(By.name("taric"), "123");
    type(By.name("quantity"), "5");
    new Select(driver.findElement(By.name("quantity_unit_id"))).selectByVisibleText("pcs");
    type(By.name("weight"), "320");
    new Select(driver.findElement(By.name("weight_class"))).selectByVisibleText("g");
    type(By.name("dim_x"), "200");
    type(By.name("dim_y"), "350");
    type(By.name("dim_z"), "180");
    new Select(driver.findElement(By.name("dim_class"))).selectByVisibleText("mm");
    click(By.cssSelector("[value='1-3']"));
    new Select(driver.findElement(By.name("sold_out_status_id"))).selectByVisibleText("-- Select --");
    driver.findElement(By.name("date_valid_from")).sendKeys("15052017");
    driver.findElement(By.name("date_valid_to")).sendKeys("15052018");
    File file = new File("src\\test\\resources\\duck.png");
    driver.findElement(By.name("new_images[]")).sendKeys(file.getAbsolutePath());
  }

  private void goToAddProductPage() {
    driver.findElement(By.cssSelector("#box-apps-menu-wrapper li:nth-child(2)")).click();
    driver.findElement(By.cssSelector("#doc-catalog")).click();
    driver.findElement(By.cssSelector("#main li:nth-child(3)")).click();
  }

  private int productsCount() {
    driver.findElement(By.cssSelector("#box-apps-menu-wrapper li:nth-child(2)")).click();
    driver.findElement(By.cssSelector("#doc-catalog")).click();
    List<WebElement> products = driver.findElements(By.cssSelector("#main img"));
    return products.size();
  }
}
