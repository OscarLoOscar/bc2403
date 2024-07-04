package objects;

import java.util.Arrays;
import java.util.Objects;

public class MacbookAir {

  private double inch;

  private double cpu;

  private double ram;

  private double disk;

  private Color color;

  public MacbookAir(double inch, double cpu, double ram, double disk,
      Color color) {
    this.inch = inch;
    this.cpu = cpu;
    this.ram = ram;
    this.disk = disk;
    this.color = color;
  }

  public double getInch() {
    return this.inch;
  }

  public double getCPU() {
    return this.cpu;
  }

  public double getRAM() {
    return this.ram;
  }

  public double getDisk() {
    return this.disk;
  }

  public Color getColor() {
    return this.color;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (!(obj instanceof MacbookAir))
      return false;
    MacbookAir ma = (MacbookAir) obj;
    // return this.inch == ma.getInch() //
    // && this.cpu == ma.getCPU() //
    // && this.ram == ma.getRAM() //
    // && this.disk == ma.getDisk() //
    // && this.color == ma.getColor();
    return Objects.equals(this.inch, ma.getInch())
        && Objects.equals(this.cpu, ma.getCPU())
        && Objects.equals(this.ram, ma.getRAM())
        && Objects.equals(this.disk, ma.getDisk())
        && Objects.equals(this.color, ma.getColor());
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.inch, this.cpu, this.ram, this.disk, this.color);
  }


  public static void main(String[] args) {
    MacbookAir ma1 = new MacbookAir(15, 3, 32, 512, Color.BLACK);
    MacbookAir ma2 = new MacbookAir(15, 3, 32, 512, Color.BLACK);
    System.out.println(ma1.equals(ma2)); // true
    System.out.println(ma1 == ma2); // false

    System.out.println(ma1.hashCode()); // -464244202, Object.class hashCode()
    System.out.println(ma2.hashCode()); // -464244202

    System.out.println(System.identityHashCode(ma1)); // 2124308362
    System.out.println(System.identityHashCode(ma2)); // 146589023

    // Sorting
    int[] arr = new int[] {10, 5, 2, 4};
    Arrays.sort(arr); // merge sort, ascending sorting
    System.out.println(Arrays.toString(arr));

    MacbookAir[] arr2 = new MacbookAir[] {new MacbookAir(0, 0, 0, 0, null),
        new MacbookAir(0, 0, 0, 0, null)};

  }

}
