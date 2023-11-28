package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public final class LoginScreen extends BaseScreen {

  @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`label == 'username' AND accessible == 1`]")
  @AndroidFindBy(accessibility = "username")
  private WebElement inputUsername;
  @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeSecureTextField[`label == 'password' AND accessible == 1`]")
  @AndroidFindBy(accessibility = "password")
  private WebElement inputPassword;

  @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'loginBtn'`]")
  @AndroidFindBy(accessibility = "loginBtn")
  private WebElement buttonLogin;

  public LoginScreen(final AppiumDriver driver) {
    super(driver);
  }

  public LoginScreen enterCredentials(final String username, final String password) {
    type(inputUsername, username);
    type(inputPassword, password);
    return this;
  }

  public SecretScreen clickLogin() {
    click(buttonLogin);
    return new SecretScreen(driver);
  }

  public SecretScreen tapLogin() {
    tap(driver, buttonLogin);
    return new SecretScreen(driver);
  }

  public boolean isLoggedOut() {
    return isDisplayed(inputUsername) && isDisplayed(inputPassword) && isDisplayed(buttonLogin);
  }

}
