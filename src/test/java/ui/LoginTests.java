package ui;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import screens.HomeScreen;
import screens.SecretScreen;

final class LoginTests extends BaseTest {

  @Test
  void checkSuccessfulLogin_UsingClicks() {
    getScreen(HomeScreen.class)
        .clickLoginScreenItem()
        .enterCredentials("alice", "mypassword")
        .clickLogin();
    Assertions.assertTrue(getScreen(SecretScreen.class).isLoggedIn());
  }

  @Test
  void checkSuccessfulLogin_UsingTaps() {
    getScreen(HomeScreen.class)
        .tapLoginScreenItem()
        .enterCredentials("bob", "totallysecure")
        .tapLogin();
    Assertions.assertTrue(getScreen(SecretScreen.class).isLoggedIn());
  }

  @ParameterizedTest
  @CsvSource({"alice,mypassword", "bob,totallysecure"})
  void checkSuccessfulLogin_Parameterized(final String username, final String password) {
    getScreen(HomeScreen.class)
        .clickLoginScreenItem()
        .enterCredentials(username, password)
        .clickLogin();
    Assertions.assertTrue(getScreen(SecretScreen.class).isLoggedIn());
  }


}
