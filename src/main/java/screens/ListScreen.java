package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import java.util.HashSet;
import java.util.List;
import org.openqa.selenium.WebElement;

public class ListScreen extends BaseScreen {

  @AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='RNE__LISTITEM__padView']")
  private List<WebElement> listItems;

  public ListScreen(AppiumDriver driver) {
    super(driver);
  }

  public int getListSize() {
    return listItems.size();
  }

  public int getSetSize() {
    return new HashSet<>(listItems).size();
  }

}
