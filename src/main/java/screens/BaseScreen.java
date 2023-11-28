package screens;

import helpers.Swipes;
import helpers.Taps;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BaseScreen {

  protected final AppiumDriver driver;
  private WebDriverWait wait;
  private int timeoutSec = Integer.parseInt(System.getProperty("DEFAULT_TIMEOUT_S"));

  protected BaseScreen(final AppiumDriver driver) {
    this.driver = driver;
    PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSec));
  }

  protected void click(final WebElement element) {
    wait.until(ExpectedConditions.elementToBeClickable(element)).click();
  }

  protected void tap(final AppiumDriver driver, final WebElement element) {
    Taps.tapElementAtRelXRelY(driver, wait.until(ExpectedConditions.elementToBeClickable(element)),
        0.5, 0.5);
  }

  protected WebElement find(final WebElement element) {
    return wait.until(ExpectedConditions.visibilityOf(element));
  }

  protected void type(final WebElement element, final String text) {
    click(element);
    element.clear();
    element.sendKeys(text);
  }

  protected boolean isDisplayed(final WebElement element) {
    try {
      find(element);
    } catch (TimeoutException e) {
      return false;
    }
    return true;
  }

  protected int getVerticalListSize(final AppiumDriver driver, final List<WebElement> list) {
    final Set<WebElement> set = new HashSet<>(list);
    int sizeAtStartOfIteration = 0;
    while (set.size() > sizeAtStartOfIteration) {
      sizeAtStartOfIteration = set.size();
      Swipes.swipeAtRelXFromRelY1ToRelY2(driver, 0.5, 0.7, 0.3);
      set.addAll(list);
    }
    return set.size();
  }

  protected void scrollToElement(final WebElement element) {
    final WebDriverWait scrollWait = new WebDriverWait(driver, Duration.ofSeconds(1));
    for (int i = 0; i < 3; i++) {
      try {
        scrollWait.until(ExpectedConditions.visibilityOf(element));
        break;
      } catch (TimeoutException e) {
        Swipes.swipeAtRelXFromRelY1ToRelY2(driver, 0.5, 0.7, 0.3);
      }
    }
  }
}
