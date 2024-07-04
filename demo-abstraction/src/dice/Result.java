package dice;

public class Result {
  
  private FCP fcp;
  private Color color;

  public void setFCP(FCP fcp) {
    this.fcp = fcp;
  }

  public void setColor(Color color) {
    this.color = color;
  }

  public int score() {
    return fcp.getValue() + color.getValue();
  }

}
