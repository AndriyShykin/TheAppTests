package helpers;

import java.io.IOException;

public final class ConfigLoader {

  private ConfigLoader() {
    throw new IllegalStateException("Utility class");
  }

  public static void getProperties() {
    try {
      System.getProperties().load(ClassLoader.getSystemResourceAsStream("config.properties"));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

}
