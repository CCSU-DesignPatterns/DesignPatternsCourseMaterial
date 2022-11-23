package edu.ccsu.designpatterns.bridge;

import java.util.Arrays;
import java.util.List;
import edu.ccsu.designpatterns.bridge.implementation.RepositoryTypes;

public class BookRepository extends RepositoryAbstraction<Book> {
  /**
   * Creates a repository with the specified name using the default implementation.
   * 
   * @param repositoryName Name of the repository
   */
  public BookRepository(String repositoryName) {
    super(repositoryName);
  }

  /**
   * Creates a repository with the specified name using the specified repository type for
   * implementation.
   * 
   * @param repositoryName Name of the repository
   * @param repoType Requested repository type
   */
  public BookRepository(String repositoryName, RepositoryTypes repoType) {
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
  public BookRepository(String repositoryName, RepositoryTypes inputRepoType,
      RepositoryTypes outputRepoType) {
    super(repositoryName, inputRepoType, outputRepoType);
  }

  @Override
  public void addItem(Book bookToAdd) {
    String id = bookToAdd.getBookId();
    String[] values = {bookToAdd.getBookTitle(), bookToAdd.getPrice().toString()};
    List<String> valuesList = Arrays.asList(values);
    super.addRecord(id, valuesList);
  }

  @Override
  public boolean deleteItem(Book itemToRemove) {
    return deleteRecord(itemToRemove.getBookId());
  }

  @Override
  public Book readItem(String uniqueId) {
    Book readBook = null;
    List<String> values = readRecord(uniqueId);
    if (values != null) {
      readBook = new Book(uniqueId, values.get(0), Double.parseDouble(values.get(1)));
    }
    return readBook;
  }

  @Override
  public List<String> getItemMetaData() {
    String[] itemInfo = {"BookId", "BookTitle", "Price"};
    return Arrays.asList(itemInfo);
  }
}
