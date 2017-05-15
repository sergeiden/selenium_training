package ru.stga.training.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import static java.lang.Integer.parseInt;
import static org.junit.Assert.assertEquals;

/**
 * Created by serg on 11.05.2017.
 */
public class CountriesSoringTests extends TestBase {

  @Test
  public void testCountriesSorting() {

    adminLogin();

    driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");

    ArrayList<String> countriesListActual = new ArrayList<>();
    List<WebElement> countries = driver.findElements(By.cssSelector(".table.table-striped.data-table td a:not([title=Edit]"));

    for (WebElement element : countries) {
      countriesListActual.add(element.getAttribute("textContent"));
    }

    ArrayList<String> countriesListSorted = new ArrayList<>();
    for (String s : countriesListActual) {
      countriesListSorted.add(s);
    }

    Collator collator = Collator.getInstance(Locale.GERMANY);
    Collections.sort(countriesListSorted, collator.getInstance());
    assertEquals(countriesListSorted, countriesListActual);

    List<WebElement> zones = driver.findElements(By.cssSelector("#main tr td:nth-child(6)"));
    int index = 0;
    for (WebElement zone : zones) {
      zones = driver.findElements(By.cssSelector("#main tr td:nth-child(6)"));
      countries = driver.findElements(By.cssSelector(".table.table-striped.data-table td a:not([title=Edit]"));
      if (parseInt(zones.get(index).getText()) > 0) {
        countries.get(index).click();
        List<WebElement> zonesInCountry = driver.findElements(By.cssSelector("#main tr td:nth-child(4)"));
        ArrayList<String> zonesInCountryList = new ArrayList<>();
        for (WebElement zoneInCountry : zonesInCountry) {
          zonesInCountryList.add(zoneInCountry.getText());
        }
        ArrayList<String> zonesInCountryListSorted = new ArrayList<>();
        for (String s : zonesInCountryList) {
          zonesInCountryListSorted.add(s);
        }
        Collections.sort(zonesInCountryListSorted);
        assertEquals(zonesInCountryList, zonesInCountryListSorted);
        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
      }
      index++;
    }
  }
}

