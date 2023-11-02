package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class HomeScreen extends BaseScreen {

  @AndroidFindBy(accessibility = "List Demo")
  private WebElement itemListDemo;

  public HomeScreen(AppiumDriver driver) {
    super(driver);
  }

  public void clickListDemo() {
    click(itemListDemo);
  }

}
