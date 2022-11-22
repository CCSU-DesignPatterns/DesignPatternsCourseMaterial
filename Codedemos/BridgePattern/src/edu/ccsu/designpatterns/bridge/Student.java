package edu.ccsu.designpatterns.bridge;

import java.util.Objects;

public class Student {
  private String studentId;
  private String firstName;
  private String lastName;
  private String email;

  public Student(String id, String first, String last, String email) {
    this.studentId = (id == null) ? "" : id;
    this.firstName = (first == null) ? "" : first;
    this.lastName = (last == null) ? "" : last;
    this.email = (email == null) ? "" : email;
  }

  @Override
  public int hashCode() {
    return Objects.hash(email, firstName, lastName, studentId);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Student other = (Student) obj;
    return Objects.equals(studentId, other.studentId) && Objects.equals(email, other.email)
        && Objects.equals(firstName, other.firstName) && Objects.equals(lastName, other.lastName);
  }

  public String getStudentId() {
    return studentId;
  }

  public void setStudentId(String studentId) {
    this.studentId = (studentId == null) ? "" : studentId;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = (firstName == null) ? "" : firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = (lastName == null) ? "" : lastName;
  }



  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = (email == null) ? "" : email;
  }

  @Override
  public String toString() {
    return "Student [studentId=" + studentId + ", firstName=" + firstName + ", lastName=" + lastName
        + ", email=" + email + "]";
  }

}
