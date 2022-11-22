package edu.ccsu.designpatterns.bridge;

import java.util.Arrays;
import java.util.List;

public class StudentRepository extends RepositoryAbstraction<Student> {

  protected StudentRepository(String repositoryName) {
    super(repositoryName);
  }

  @Override
  public void addItem(Student studentToAdd) {
    String id = studentToAdd.getStudentId();
    String[] values =
        {studentToAdd.getFirstName(), studentToAdd.getLastName(), studentToAdd.getEmail()};
    List<String> valuesList = Arrays.asList(values);
    super.addRecord(id, valuesList);
  }

  @Override
  public boolean deleteItem(Student itemToRemove) {
    return deleteRecord(itemToRemove.getStudentId());
  }

  @Override
  public Student readItem(String uniqueId) {
    Student readStudent = null;
    List<String> values = readRecord(uniqueId);
    if (values != null) {
      readStudent = new Student(uniqueId, values.get(0), values.get(1), values.get(2));
    }
    return readStudent;
  }

  @Override
  public List<String> getItemMetaData() {
    String[] itemInfo = {"StudentId", "FirstName", "LastName", "Email"};
    return Arrays.asList(itemInfo);
  }
}
