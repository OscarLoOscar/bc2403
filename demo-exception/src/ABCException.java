public class ABCException extends RuntimeException {
  // "extends RuntimeException" implies "ABCException" is a run-time exception
  // compiler would not check if you have handled the exception
  public static void main(String[] args) {
    checkName("Vincent Vincent", "Lau");
  }

  public static String checkName(String firstName, String lastName) throws ABCException {
    if (firstName == null || lastName == null)
      throw new IllegalArgumentException();
    if (firstName.length() + lastName.length() > 10)
      throw new ABCException();
    return firstName.concat(" ").concat(lastName);
  }
}
