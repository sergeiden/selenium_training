package ru.stga.training.selenium.tests;

import org.junit.Before;
import ru.stga.training.selenium.app.Application;

/**
 * Created by serg on 22.05.2017.
 */
public class TestBase {
  public static ThreadLocal<Application> tlApp = new ThreadLocal<>();
  public Application app;

  @Before
  public void start() {
    if (tlApp.get() != null) {
      app = tlApp.get();
      return;
    }

    app = new Application();
    tlApp.set(app);

    Runtime.getRuntime().addShutdownHook(
            new Thread(() -> {
              app.quit();
              app = null;}));
  }
}