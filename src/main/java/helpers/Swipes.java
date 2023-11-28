package helpers;

import io.appium.java_client.AppiumDriver;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;


public final class Swipes {

  private static final int SWIPE_DURATION_MS = 1000;

  private Swipes() {
    throw new IllegalStateException("Utility class");
  }

  public static void swipeAtRelXFromRelY1ToRelY2(final AppiumDriver driver, final double relX,
      final double relY1, final double relY2) {
    if ((relX > 1) || (relX < 0) || (relY1 > 1) || (relY1 < 0) || (relY2 > 1) || (relY2 < 0)) {
      throw new IllegalArgumentException("Illegal relative coordinate");
    }
    final Dimension windowSize = driver.manage().window().getSize();
    final Point source = new Point(
        (int) (windowSize.getWidth() * relX),
        (int) (windowSize.getHeight() * relY1));
    final Point target = new Point(
        (int) (windowSize.getWidth() * relX),
        (int) (windowSize.getHeight() * relY2));
    final PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
    final Sequence swipe = new Sequence(finger, 1);
    swipe.addAction(finger.createPointerMove(Duration.ofMillis(100),
        PointerInput.Origin.viewport(), source.x, source.y));
    swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
    swipe.addAction(finger.createPointerMove(Duration.ofMillis(SWIPE_DURATION_MS),
        PointerInput.Origin.viewport(), target.x, target.y));
    swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
    driver.perform(List.of(swipe));
  }


}
