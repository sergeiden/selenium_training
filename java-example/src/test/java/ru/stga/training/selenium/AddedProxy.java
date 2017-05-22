package ru.stga.training.selenium;

import net.lightbody.bmp.core.har.Har;
import org.junit.Test;
import org.openqa.selenium.By;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

/**
 * Created by serg on 20.05.2017.
 */
public class AddedProxy extends TestBaseOld {

  @Test
  public void testProxy() {
    proxy.newHar();
    driver.get("http://www.google.com");
    driver.findElement(By.name("q")).sendKeys("webdriver");
    driver.findElement(By.name("btnG")).click();
    wait.until(titleIs("webdriver - Поиск в Google"));
    Har har = proxy.endHar();
    har.getLog().getEntries().forEach(l -> System.out.println(l.getResponse().getStatus() + ":" + l.getRequest().getUrl()));
  }

}
