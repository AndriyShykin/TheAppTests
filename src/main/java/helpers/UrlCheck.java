package helpers;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public final class UrlCheck {

  private UrlCheck() {
    throw new IllegalStateException("Utility class");
  }

  public static boolean isOnline(final String url) throws MalformedURLException {
    return isOnline(new URL(url));
  }

  public static boolean isOnline(final URL url) {
    try {
      return ((HttpURLConnection) url.openConnection()).getResponseCode() == 200;
    } catch (IOException e) {
      return false;
    }
  }

}
