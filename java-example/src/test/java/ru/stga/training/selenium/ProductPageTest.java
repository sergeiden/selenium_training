package ru.stga.training.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.*;

/**
 * Created by serg on 12.05.2017.
 */
public class ProductPageTest extends TestBase {

  @Test

  public void testProductPage() {

    driver.get("http://localhost/litecart/en/#campaign-products");

    WebElement mainPageProduct = driver.findElement(By.cssSelector(".info .name"));
    WebElement mainPagePriceRegular = driver.findElement(By.cssSelector(".regular-price"));
    WebElement mainPagePriceDiscount = driver.findElement(By.cssSelector(".campaign-price"));

    String mainPageProductTitle = mainPageProduct.getText();
    String mainPagePriceRegularValue = mainPagePriceRegular.getText();
    String mainPagePriceDiscountValue = mainPagePriceDiscount.getText();

    String[] mainPagePriceRegularColors = mainPagePriceRegular.getCssValue("color").replaceAll("[()rgba ]", "").split(",");
    assertEquals(mainPagePriceRegularColors[0], mainPagePriceRegularColors[1], mainPagePriceRegularColors[2]);
    assertEquals(mainPagePriceRegular.getTagName(), ("s"));

    String[] mainPagePriceDiscountColors = mainPagePriceDiscount.getCssValue("color").replaceAll("[()rgba ]", "").split(",");
    assertEquals(mainPagePriceDiscountColors[1], mainPagePriceDiscountColors[2], "0");
    assertEquals(mainPagePriceDiscount.getTagName(), ("strong"));

    assertTrue(mainPagePriceDiscount.getSize().getHeight() > (mainPagePriceRegular.getSize().getHeight()));
    assertTrue(mainPagePriceDiscount.getSize().getWidth() > (mainPagePriceRegular.getSize().getWidth()));

    mainPageProduct.click();

    String productPageTitle = driver.findElement(By.cssSelector("h1.title")).getText();
    WebElement productPagePriceRegular = driver.findElement(By.cssSelector(".regular-price"));
    WebElement productPagePriceDiscount = driver.findElement(By.cssSelector(".campaign-price"));

    String[] productPagePriceRegularColors = productPagePriceRegular.getCssValue("color").replaceAll("[()rgba ]", "").split(",");
    assertEquals(productPagePriceRegularColors[0], productPagePriceRegularColors[1], productPagePriceRegularColors[2]);
    assertEquals(productPagePriceRegular.getTagName(), ("del"));

    String[] productPagePriceDiscountColors = productPagePriceDiscount.getCssValue("color").replaceAll("[()rgba ]", "").split(",");
    assertEquals(productPagePriceDiscountColors[1], productPagePriceDiscountColors[2], "0");
    assertEquals(productPagePriceDiscount.getTagName(), ("strong"));

    assertTrue(productPagePriceDiscount.getSize().getHeight() > (productPagePriceRegular.getSize().getHeight()));
    assertTrue(productPagePriceDiscount.getSize().getWidth() > (productPagePriceRegular.getSize().getWidth()));

    assertEquals(mainPageProductTitle, productPageTitle);
    assertEquals(mainPagePriceRegularValue, productPagePriceRegular.getText());
    assertEquals(mainPagePriceDiscountValue, productPagePriceDiscount.getText());

  }
}