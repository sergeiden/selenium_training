package ru.stga.training.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/**
 * Created by serg on 12.07.2017.
 */
public class Game2 {
  private WebDriver driver;

  private WebDriverWait wait;

  @Before
  public void start() {
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    wait = new WebDriverWait(driver, 50);
  }

  @Test
  public void game() throws InterruptedException {
    driver.get("https://freebitco.in/?op=home#");
    driver.findElement(By.cssSelector(".login_menu_button")).click();
    driver.findElement(By.name("btc_address")).sendKeys("mineac2017@gmail.com");
    driver.findElement(By.id("login_form_password")).sendKeys("zx1009qw");
    driver.findElement(By.id("login_button")).click();

//    Thread.sleep(3000);
//
//    ((JavascriptExecutor)driver).executeScript("scroll(0,1200)");
//    if (driver.findElement(By.id("free_play_form_button")).isDisplayed()){
//      driver.findElement(By.id("free_play_form_button")).click();
//    }

    driver.findElement(By.cssSelector(".double_your_btc_link")).click();

    double minBet = 0.00000001;
    double maxBet = 0.00000010;

    int index = 0;

    while (index < 50) {
      int losecount = 0;
      int wincount = 0;
      while (losecount != 6 && wincount != 6) {
        betLow(minBet);
        if (win() == false) {
          losecount = losecount + 1;
        } else {
          losecount = 0;
        }
        if (win() == true){
          wincount = wincount + 1;
        } else {
          wincount = 0;
        }
//        System.out.println("Lose " + losecount);
//        System.out.println("Win  " + wincount);
      }
        if (losecount == 8) {
          System.out.println("BETTING LOW");
          betLow(maxBet);
          if (win() != true) betLow(maxBet * 2);
          if (win() != true) betLow(maxBet * 2);
        }
        if (wincount == 8) {
          System.out.println("BETTING HI");
          betHi(maxBet);
          if (win() != true) betHi(maxBet * 2);
          if (win() != true) betHi(maxBet * 2);
        }
        index++;
        System.out.println(index);
      }
      driver.findElement(By.cssSelector(".logout_link")).click();
    }

  public void setBet(double bet) {
    driver.findElement(By.name("stake")).clear();
    driver.findElement(By.name("stake")).sendKeys(BigDecimal.valueOf(bet).toPlainString());
  }

  public void betLow(double bet) {
    setBet(bet);
    driver.findElement(By.id("double_your_btc_bet_lo_button")).click();
    wait.until(ExpectedConditions.elementToBeClickable(By.id("double_your_btc_bet_lo_button")));
  }

  public void betHi(double bet) {
    setBet(bet);
    driver.findElement(By.id("double_your_btc_bet_hi_button")).click();
    wait.until(ExpectedConditions.elementToBeClickable(By.id("double_your_btc_bet_lo_button")));
  }

  public boolean win() {
    WebElement result = driver.findElement(By.id("double_your_btc_result"));
    if (result.getText().contains("win")) {
      return true;
    } else {
      return false;
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
