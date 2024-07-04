package dice;

import java.util.Arrays;
import java.util.Random;

public class Dice2 implements Roll {

  private final FCP[] fcps = {FCP.FISH, FCP.CRAB, FCP.PRAWN};

  public FCP[] getFcps() {
    return this.fcps;
  };

  @Override
  public int roll() {
    // Random 0-2 numbers -> array index
    int idx = new Random().nextInt(3); // 0-2
    return fcps[idx].getValue();
  }

  public FCP roll2() {
    // Random 0-2 numbers -> array index
    int idx = new Random().nextInt(3); // 0-2
    return fcps[idx];
  }

  @Override
  public String toString() {
    return "Dice2(" //
        + "fcps=" + Arrays.toString(this.fcps) + ")";
  }
}
