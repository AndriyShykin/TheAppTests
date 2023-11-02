package ui;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.InteractsWithApps;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.net.MalformedURLException;
import java.net.URL;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import screens.HomeScreen;
import screens.ListScreen;

public abstract class BaseTest {

  private AppiumDriver driver;

  private AndroidDriver androidSetup() throws MalformedURLException {
    final UiAutomator2Options options = new UiAutomator2Options()
        .clearDeviceLogsOnStart()
        .disableWindowAnimation()
        .setApp("https://github.com/appium-pro/TheApp/releases/download/v1.12.0/TheApp.apk")
        .setAppWaitPackage("com.appiumpro.the_app")
        .setAutoGrantPermissions(true)
        .setUdid("emulator-5554");
    return new AndroidDriver(new URL("http://127.0.0.1:1234"), options);
  }

  @BeforeEach
  protected void setup() throws MalformedURLException {
    driver = androidSetup();
  }

  @AfterEach
  protected void teardown() {
    if (getDriver() != null) {
      ((InteractsWithApps) getDriver()).terminateApp("com.appiumpro.the_app");
      getDriver().quit();
    }
  }

  private AppiumDriver getDriver() {
    return driver;
  }

  protected HomeScreen getHomeScreen() {
    return new HomeScreen(getDriver());
  }

  protected ListScreen getListScreen() {
    return new ListScreen(getDriver());
  }
}
