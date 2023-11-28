package ui;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import screens.HomeScreen;
import screens.ListScreen;
import screens.ModalScreen;

final class ListTests extends BaseTest {

  @Test
  void checkSetSize_ExpectEqualToListSize() {
    getScreen(HomeScreen.class).clickListDemoItem();
    int listSize = getScreen(ListScreen.class).getListSize();
    int setSize = getScreen(ListScreen.class).getSetSize();
    Assertions.assertEquals(listSize, setSize);
  }

  @Test
  void checkListSize_Expect30() {
    getScreen(HomeScreen.class).clickListDemoItem();
    Assertions.assertEquals(30, getScreen(ListScreen.class).getTotalNumberOfListItems());
  }

  @Test
  void checkStratusCloudAlertTitle_ExpectStratus() {
    getScreen(HomeScreen.class).clickListDemoItem().clickStratus().clickLearnMoreAbout();
    Assertions.assertTrue(getScreen(ModalScreen.class).isAlertTitle("Stratus"));
  }


}
