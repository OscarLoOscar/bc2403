package objects;

import java.time.LocalDate;

public class Student {

  private String sid;

  private String name;

  private LocalDate dob;

  public Student(String sid, String name, LocalDate dob) {
    this.sid = sid;
    this.name = name;
    this.dob = dob;
  }

  public String getName() {
    return this.name;
  }

  public LocalDate getDOB() {
    return this.dob;
  }

  public String getSID() {
    return this.sid;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (!(obj instanceof Student))
      return false;
    Student student = (Student) obj;
    return this.name.equals(student.getName())
        && this.dob.compareTo(student.getDOB()) == 0
        && this.sid.equals(student.getSID());
  }

  public static void main(String[] args) {
    Student s1 = new Student("S1", "Vincent", LocalDate.of(2000, 10, 4));
    Student s2 = new Student(s1.getSID(), s1.getName(), s1.getDOB());
    System.out.println(s1 == s2); // false
    System.out.println(s1.equals(s2)); // true
  }
}
