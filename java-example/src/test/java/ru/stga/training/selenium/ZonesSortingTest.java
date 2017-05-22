package ru.stga.training.selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by serg on 12.05.2017.
 */
public class ZonesSortingTest extends TestBaseOld {

  @Test

  public void testZonesSorting() {

    adminLogin();
    driver.get("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
    List<WebElement> countries = driver.findElements(By.cssSelector("#main td a:not([title=Edit]"));
    int index = 0;
    int countriesCount = countries.size();
    while (index < countriesCount) {
      countries = driver.findElements(By.cssSelector("#main td a:not([title=Edit]"));
      countries.get(index).click();

      List<WebElement> zones = driver.findElements(By.cssSelector("tr td:nth-child(3)"));
      int zonesCount = zones.size();
      if (zonesCount > 0) {
        ArrayList<String> zonesList = new ArrayList<>();
        for (WebElement zone : zones) {
          zonesList.add(zone.getText());
        }
        ArrayList<String> zonesListSorted = new ArrayList<>();
        for (String s : zonesList) {
          zonesListSorted.add(s);
        }
        Collections.sort(zonesListSorted);
        Assert.assertEquals(zonesListSorted, zonesList);
      }
      index++;
      driver.get("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
    }
  }
}


