package ui;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import screens.LoginScreen;

final class LogoutTests extends BaseTest {

  @Test
  void checkLogout() {
    logInWithDeepLink("alice", "mypassword").clickLogout();
    Assertions.assertTrue(getScreen(LoginScreen.class).isLoggedOut());
  }

}
