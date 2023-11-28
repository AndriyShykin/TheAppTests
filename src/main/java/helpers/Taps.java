package helpers;

import io.appium.java_client.AppiumDriver;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

public final class Taps {

  private Taps() {
    throw new IllegalStateException("Utility class");
  }


  public static void tapElementAtRelXRelY(final AppiumDriver driver, final WebElement element,
      final double relX, final double relY) {
    if ((relX > 1) || (relX < 0) || (relY > 1) || (relY < 0)) {
      throw new IllegalArgumentException("Illegal relative coordinate");
    }
    final Rectangle elementRectangle = element.getRect();
    final Point target = new Point(
        (int) (elementRectangle.x + elementRectangle.getWidth() * relX),
        (int) (elementRectangle.y + elementRectangle.getHeight() * relY));
    final PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
    final Sequence tap = new Sequence(finger, 1);
    tap.addAction(finger.createPointerMove(Duration.ofMillis(100),
        PointerInput.Origin.viewport(), target.x, target.y));
    tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
    tap.addAction(
        finger.createPointerMove(Duration.ofMillis(100), PointerInput.Origin.viewport(), target.x,
            target.y));
    tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
    driver.perform(List.of(tap));
  }


}
