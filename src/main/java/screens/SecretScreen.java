package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public final class SecretScreen extends BaseScreen {

  @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == 'Secret Area' AND accessible == 1`]")
  @AndroidFindBy(xpath = "//android.widget.TextView[@text='Secret Area']")
  private WebElement textSecretArea;

  @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'Logout' AND accessible == 1`]")
  @AndroidFindBy(accessibility = "Logout")
  private WebElement buttonLogout;

  public SecretScreen(final AppiumDriver driver) {
    super(driver);
  }

  public boolean isLoggedIn() {
    return isDisplayed(textSecretArea) && isDisplayed(buttonLogout);
  }

  public LoginScreen clickLogout() {
    click(buttonLogout);
    return new LoginScreen(driver);
  }

}
