package ui;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

final class ListTests extends BaseTest {

  @Test
  void listSetSizeTest() {
    getHomeScreen().clickListDemo();
    int listSize = getListScreen().getListSize();
    int setSize = getListScreen().getSetSize();
    Assertions.assertEquals(setSize, listSize);
  }

}
