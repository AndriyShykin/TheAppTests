package sessionmanager;

import static java.lang.System.getProperty;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import java.net.MalformedURLException;
import java.net.URL;

public final class SessionManager {

  private SessionManager() {
    throw new IllegalStateException("Utility class");
  }

  public static AndroidDriver androidSetup() throws MalformedURLException {
    final UiAutomator2Options options = new UiAutomator2Options()
        .autoGrantPermissions()
        .clearDeviceLogsOnStart()
        .disableWindowAnimation()
        .setApp(getProperty("ANDROID_APP"))
        .setAppWaitPackage("com.appiumpro.the_app")
        .setUdid(getProperty("ANDROID_UDID"));
    return new AndroidDriver(new URL(getProperty("APPIUM_URL")), options);
  }

  public static IOSDriver iosSetup() throws MalformedURLException {
    final XCUITestOptions options = new XCUITestOptions()
        .setApp(getProperty("IOS_APP"))
        .setUdid(getProperty("IOS_UDID"))
        .setWebDriverAgentUrl(getProperty("WDA_URL"));
    return new IOSDriver(new URL(getProperty("APPIUM_URL")), options);
  }

}
