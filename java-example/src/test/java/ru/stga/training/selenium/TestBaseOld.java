package ru.stga.training.selenium;

import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by serg on 11.05.2017.
 */
public class TestBaseOld {

  public static ThreadLocal<EventFiringWebDriver> tlDriver = new ThreadLocal<>();
  public EventFiringWebDriver driver;
  public WebDriverWait wait;
  public BrowserMobProxy proxy;

  public static class MyListener extends AbstractWebDriverEventListener {

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
      System.out.println(by);
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
      System.out.println(by + " found");
      ;
    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {
      System.out.println(throwable);
    }
  }


  @Before
  public void start() {
    if (tlDriver.get() != null) {
      driver = tlDriver.get();
      wait = new WebDriverWait(driver, 10);
      return;
    }

    // start the proxy
    proxy = new BrowserMobProxyServer();
    proxy.start(0);

    // get the Selenium proxy object
    Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);
//    Proxy seleniumProxy = new Proxy().setHttpProxy("localhost:8888");

    // configure it as a desired capability
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability(CapabilityType.PROXY, seleniumProxy);

//    Proxy proxy = new Proxy();
//    proxy.setHttpProxy("localhost:8888");
    driver = new EventFiringWebDriver(new ChromeDriver(capabilities));
    driver.register(new MyListener());
    tlDriver.set(driver);
    wait = new WebDriverWait(driver, 5);
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    WebDriver.Window window = driver.manage().window();
    window.maximize();
    Runtime.getRuntime().addShutdownHook(
            new Thread(() -> {
              driver.quit();
              driver = null;
            }));
  }


  public void adminLogin() {
    driver.get("http://localhost/litecart/admin/");
    driver.findElement(By.name("username")).sendKeys("admin");
    driver.findElement(By.name("password")).sendKeys("admin");
    driver.findElement(By.cssSelector(".btn[name=login]")).click();
    driver.findElement(By.id("box-apps-menu-wrapper"));
  }

  protected void click(By locator) {
    driver.findElement(locator).click();
  }

  protected void type(By locator, String text) {
    click(locator);
    if (text != null) {
      String existingText = driver.findElement(locator).getAttribute("value");
      if (!text.equals(existingText)) {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
      }
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

  @After
  public void stop() {
    driver.quit();
    driver = null;
  }
}