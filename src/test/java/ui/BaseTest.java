package ui;

import static java.lang.System.getProperty;

import helpers.ConfigLoader;
import helpers.UrlCheck;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.InteractsWithApps;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.text.MessageFormat;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Platform;
import screens.BaseScreen;
import screens.SecretScreen;
import sessionmanager.SessionManager;

public abstract class BaseTest {

  private static final Platform PLATFORM;

  private AppiumDriver driver;

  static {
    ConfigLoader.getProperties();
    PLATFORM = Platform.valueOf(getProperty("PLATFORM").toUpperCase());
  }

  @BeforeEach
  protected void setUp() throws MalformedURLException {
    Assumptions.assumeTrue(UrlCheck.isOnline(getProperty("APPIUM_URL") + "/status"));
    if (PLATFORM.is(Platform.ANDROID)) {
      driver = SessionManager.androidSetup();
    } else if (PLATFORM.is(Platform.IOS)) {
      driver = SessionManager.iosSetup();
    } else {
      throw new IllegalArgumentException("Platform not supported: " + PLATFORM);
    }
  }

  @AfterEach
  protected void tearDown() {
    if (getDriver() != null) {
      ((InteractsWithApps) getDriver()).terminateApp("com.appiumpro.the_app");
      getDriver().quit();
    }
  }

  private AppiumDriver getDriver() {
    return driver;
  }

  protected <T extends BaseScreen> T getScreen(final Class<T> pageObjectClass) {
    try {
      return pageObjectClass.getDeclaredConstructor(AppiumDriver.class).newInstance(getDriver());
    } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
             NoSuchMethodException e) {
      throw new RuntimeException(e);
    }
  }

  protected SecretScreen logInWithDeepLink(final String username, final String password) {
    getDriver().get(MessageFormat.format("theapp://login/{0}/{1}", username, password));
    return new SecretScreen(getDriver());
  }

}
