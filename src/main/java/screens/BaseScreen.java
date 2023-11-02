package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BaseScreen {

  private final AppiumDriver driver;
  private final WebDriverWait wait;

  protected BaseScreen(AppiumDriver driver) {
    this.driver = driver;
    PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(1));
  }

  protected void click(final WebElement element) {
    wait.until(ExpectedConditions.elementToBeClickable(element)).click();
  }

}
