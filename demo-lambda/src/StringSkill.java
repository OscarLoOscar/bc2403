public interface StringSkill {
  
  String concat(String x, String y);

  public static void main(String[] args) {
    StringSkill ss = (s1, s2) -> {
      if (s1 == null || s2 == null)
        return null;
      return s1.concat(s2);
    };

    System.out.println(ss.concat("hello", "world"));
  }
}
