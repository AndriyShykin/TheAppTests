package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public final class HomeScreen extends BaseScreen {

  @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == 'List Demo' AND accessible == 1`]")
  @AndroidFindBy(accessibility = "List Demo")
  private WebElement itemListDemo;

  @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == 'Login Screen' AND accessible == 1`]")
  @AndroidFindBy(accessibility = "Login Screen")
  private WebElement itemLoginScreen;

  public HomeScreen(final AppiumDriver driver) {
    super(driver);
  }

  public ListScreen clickListDemoItem() {
    click(itemListDemo);
    return new ListScreen(driver);
  }

  public LoginScreen clickLoginScreenItem() {
    click(itemLoginScreen);
    return new LoginScreen(driver);
  }

  public LoginScreen tapLoginScreenItem() {
    tap(driver, itemLoginScreen);
    return new LoginScreen(driver);
  }

}
