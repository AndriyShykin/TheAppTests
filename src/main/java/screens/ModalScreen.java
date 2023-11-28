package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class ModalScreen extends BaseScreen {

  @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`name BEGINSWITH 'Learn more about'`]")
  @AndroidFindBy(xpath = "//android.widget.Button[starts-with(@text, 'LEARN MORE ABOUT')]")
  private WebElement buttonLearnMoreAbout;

  @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeAlert")
  @AndroidFindBy(id = "android:id/alertTitle")
  private WebElement textAlertTitle;


  public ModalScreen(final AppiumDriver driver) {
    super(driver);
  }

  public ModalScreen clickLearnMoreAbout() {
    click(buttonLearnMoreAbout);
    return this;
  }

  public boolean isAlertTitle(final String title) {
    return textAlertTitle.getText().equals(title);
  }

}
