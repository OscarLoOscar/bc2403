package sport;

public class Staff implements Action {

  @Override
  public void run() {
    System.out.println("run ....");
  }

  @Override
  public void walk() {
    System.out.println("walk ....");
  }

}
