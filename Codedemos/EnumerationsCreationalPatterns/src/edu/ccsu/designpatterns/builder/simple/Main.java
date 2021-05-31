/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ccsu.designpatterns.builder.simple;

import edu.ccsu.designpatterns.builder.simple.Person.PersonBuilder;

/**
 * Demonstration of two options for creation using
 * builder
 */
public class Main {
  public static void main(String[] args){
    // Option 1
    PersonBuilder builder = new Person.PersonBuilder("John", "Doe");
    builder.setMaritialStatus(MaritalStatus.DIVORCED);
    builder.setJobTitle("Writer");
    Person johnDoe = builder.buildPerson();

    // Option 2
    Person janeDoe = new Person.PersonBuilder("Jane", "Doe")
                     .setMaritialStatus(MaritalStatus.MARRIED)
                     .setSignificantOtherName("Jerry Rice")
                     .setJobTitle("Professor").buildPerson();
    System.out.println(johnDoe.toString());
    System.out.println(janeDoe.toString());
  }
}
