package ru.stga.training.selenium.app;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.stga.training.selenium.model.Product;
import ru.stga.training.selenium.pages.AddProductPage;
import ru.stga.training.selenium.pages.CartPage;
import ru.stga.training.selenium.pages.MainPage;

import java.util.concurrent.TimeUnit;

import static java.lang.Integer.parseInt;
import static org.openqa.selenium.support.ui.ExpectedConditions.stalenessOf;

/**
 * Created by serg on 22.05.2017.
 */
public class Application {
  private WebDriverWait wait;
  private WebDriver driver;

  private MainPage mainPage;
  private CartPage cartPage;
  private AddProductPage addProductPage;


  public Application() {
    driver = new ChromeDriver();
    wait = new WebDriverWait(driver, 10);

    mainPage = new MainPage(driver);
    cartPage = new CartPage(driver);
    addProductPage = new AddProductPage(driver);

    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    WebDriver.Window window = driver.manage().window();
    window.maximize();
  }

  public void quit() {
    driver.quit();
  }

  public void goToMainPage() {
    driver.get("http://localhost/litecart/en/");
  }

  public int itemsInCartQuantity() {
    return parseInt(mainPage.cart().getText());
  }

  public void addProductToCart(Product product) {
    mainPage.selectProduct();
    goToProductPage();
    addProductPage.selectSize(product.getSize());
    addProductPage.quantity().sendKeys(product.getQuantity());
    addProductPage.addToCart();
  }

  public void cartUpdatedTo(int quantity) {
    mainPage.ensureCartUpdate(quantity);
  }

  public void goToCart() {
    mainPage.cart().click();
  }

  public void removeAllItemsFromCart() {
    for (WebElement element : cartPage.items()) {
      WebElement cartSummary = cartPage.cartSummary();
      cartPage.removeItem().click();
      wait.until(stalenessOf(cartSummary));
    }
  }

  public void returnToMainPage() {
    mainPage.logo().click();
  }

  private void goToProductPage() {
    if (isElementPresent(By.cssSelector("#view-full-page"))) {
      WebElement window = driver.findElement(By.cssSelector("#view-full-page"));
      driver.findElement(By.cssSelector("#view-full-page")).click();
      wait.until(stalenessOf(window));
    }
  }

  public boolean isElementPresent(By locator) {
    try {
      driver.findElement(locator);
      return true;
    } catch (NoSuchElementException ex) {
      return false;
    }
  }
}
