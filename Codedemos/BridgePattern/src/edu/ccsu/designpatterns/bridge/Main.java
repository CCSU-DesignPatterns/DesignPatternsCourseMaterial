package edu.ccsu.designpatterns.bridge;

import java.util.List;
import edu.ccsu.designpatterns.bridge.implementation.RepositoryTypes;

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

      // Load an XML repository
      StudentRepository xmlRepo = new StudentRepository("student", RepositoryTypes.XML);
      xmlRepo.load();
      xmlRepo.addItem(jane);
      System.out.println(xmlRepo.toString());

      // Create a mixed repo that can read from XML, but outputs CSV
      StudentRepository mixedRepo =
          new StudentRepository("student", RepositoryTypes.XML, RepositoryTypes.CSV);
      mixedRepo.load();
      mixedRepo.addItems(mixedRepo.readItems());
      System.out.println(mixedRepo.toString());

      // Variation of abstraction sub classing
      BookRepository bookRepo = new BookRepository("books");
      bookRepo.addItem(new Book("1", "Carrie", 11.99));
      bookRepo.addItem(new Book("2", "The Bell Jar", 9.95));
      bookRepo.addItem(new Book("3", "The Name of the Wind", 17.23));
      bookRepo.persist();
      BookRepository bookRepo2 = new BookRepository("books");
      bookRepo2.load();
      System.out.println(bookRepo2.toString());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
