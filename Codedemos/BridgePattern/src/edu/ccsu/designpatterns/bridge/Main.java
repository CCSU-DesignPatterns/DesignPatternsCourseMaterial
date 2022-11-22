package edu.ccsu.designpatterns.bridge;

import java.util.List;

public class Main {

  public static void main(String[] args) {
    try {
      StudentRepository studentRepo = new StudentRepository("students");
      Student john = new Student("12345", "John", "Doe", "johndoe@my.ccsu.edu");
      Student jane = new Student("12346", "Jane", "Doe", "jdoe@my.ccsu.edu");
      System.out.println("Adding John to default students repo");
      studentRepo.addItem(john);
      System.out.println("Adding John to default students repo");
      studentRepo.addItem(jane);
      System.out.println("Persisting default students repo");
      studentRepo.persist();
      System.out.println(studentRepo.toString());
      john.setEmail("john.doe@my.ccsu.edu");
      studentRepo.addItem(john);
      studentRepo.addItem(new Student("12347", "Dylan", "Thomas", "dthomas@my.ccsu.edu"));
      studentRepo.persist();
      System.out.println(studentRepo.toString());

      // Load archived students repo
      StudentRepository archivedStudentRepo = new StudentRepository("archivedstudents");
      archivedStudentRepo.load();
      List<Student> students = archivedStudentRepo.readItems();
      for (Student student : students) {
        System.out.println("Archived student: " + student.toString());
      }

      // Add archived students to current repo
      studentRepo.addItems(students);
      System.out.println(studentRepo.toString());

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
