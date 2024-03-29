package edu.ccsu.designpatterns.bridge;

import java.util.Arrays;
import java.util.List;
import edu.ccsu.designpatterns.bridge.implementation.RepositoryTypes;

public class StudentRepository extends RepositoryAbstraction<Student> {
  /**
   * Creates a repository with the specified name using the default implementation.
   * 
   * @param repositoryName Name of the repository
   */
  public StudentRepository(String repositoryName) {
    super(repositoryName);
  }

  /**
   * Creates a repository with the specified name using the specified repository type for
   * implementation.
   * 
   * @param repositoryName Name of the repository
   * @param repoType Requested repository type
   */
  public StudentRepository(String repositoryName, RepositoryTypes repoType) {
    super(repositoryName, repoType);
  }

  /**
   * Creates a repository with the specified name with specified repository types for input
   * implementation and output implementation.
   * 
   * @param repositoryName Name of the repository
   * @param inputRepoType Requested input repository type
   * @param outputRepoType Requested output repository type
   */
  public StudentRepository(String repositoryName, RepositoryTypes inputRepoType,
      RepositoryTypes outputRepoType) {
    super(repositoryName, inputRepoType, outputRepoType);
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
