package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import java.util.HashSet;
import java.util.List;
import org.openqa.selenium.WebElement;

public final class ListScreen extends BaseScreen {

  @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`name == 'RNE__LISTITEM__padView'`]")
  @AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='RNE__LISTITEM__padView']")
  private List<WebElement> listItems;

  @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`label == 'Stratus' AND accessible == 1`]")
  @AndroidFindBy(accessibility = "Stratus")
  private WebElement itemStratus;

  public ListScreen(final AppiumDriver driver) {
    super(driver);
  }

  public int getListSize() {
    return listItems.size();
  }

  public int getSetSize() {
    return new HashSet<>(listItems).size();
  }

  public int getTotalNumberOfListItems() {
    return getVerticalListSize(driver, listItems);
  }

  public ModalScreen clickStratus() {
    scrollToElement(itemStratus);
    click(itemStratus);
    return new ModalScreen(driver);
  }
}
