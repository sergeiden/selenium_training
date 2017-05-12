package ru.stga.training.selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/**
 * Created by serg on 11.05.2017.
 */
public class CountiesSoringTests extends TestBase {

  @Test
  public void testCountiesSorting() {

    login();

    driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");

    ArrayList<String> countiesListActual = new ArrayList<>();
    List<WebElement> elements = driver.findElements(By.cssSelector(".table.table-striped.data-table td a:not([title=Edit]"));

    for (WebElement element : elements) {
      countiesListActual.add(element.getAttribute("textContent"));
    }

    ArrayList<String> countriesListSorted = new ArrayList<>();
    for (String s : countiesListActual) {
      countriesListSorted.add(s);
    }

    Collator collator = Collator.getInstance(Locale.GERMANY);
    Collections.sort(countriesListSorted, collator.getInstance());
    Assert.assertEquals(countriesListSorted, countiesListActual);
  }
}
