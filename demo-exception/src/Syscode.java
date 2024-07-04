public enum Syscode {
  LOGIN_FAIL(1000, "Login Fail."),
  PW_WRONG(1001, "Password is wrong."),
  ID_NOT_FOUND(1002, "User ID is not found."),
  ;

  private int code;
  private String desc;
  
  private Syscode(int code, String desc) {
    this.code = code;
    this.desc = desc;
  }

  public int getCode() {
    return this.code;
  }

  public String getDesc() {
    return this.desc;
  }
}
