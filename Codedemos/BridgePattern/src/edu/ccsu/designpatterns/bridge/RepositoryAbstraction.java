package edu.ccsu.designpatterns.bridge;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import edu.ccsu.designpatterns.bridge.implementation.RepoLoadException;
import edu.ccsu.designpatterns.bridge.implementation.RepoPersistException;
import edu.ccsu.designpatterns.bridge.implementation.RepositoryImpl;
import edu.ccsu.designpatterns.bridge.implementation.RepositoryImplementationFactory;
import edu.ccsu.designpatterns.bridge.implementation.RepositoryTypes;

/**
 * This class provides an abstraction for being able to store and retrieve objects by primary key.
 * It is implemented as an example of the bridge pattern so that types of repositories can be
 * subclasses, and the variations of implementations can be sub-classed independently.
 * 
 * @author Chad Williams
 *
 * @param <T> Types of items held in this repository
 */
public abstract class RepositoryAbstraction<T> {
  private RepositoryImpl inputRepositoryImpl;
  private RepositoryImpl outputRepositoryImpl;

  /**
   * Creates a repository with the specified name using the default implementation.
   * 
   * @param repositoryName Name of the repository
   */
  protected RepositoryAbstraction(String repositoryName) {
    inputRepositoryImpl = RepositoryImplementationFactory
        .getRepositoryImplementation(repositoryName, getItemMetaData());
    outputRepositoryImpl = inputRepositoryImpl;
  }

  /**
   * Creates a repository with the specified name using the specified repository type for
   * implementation.
   * 
   * @param repositoryName Name of the repository
   * @param repoType Requested repository type
   */
  protected RepositoryAbstraction(String repositoryName, RepositoryTypes repoType) {
    inputRepositoryImpl = RepositoryImplementationFactory
        .getRepositoryImplementation(repositoryName, getItemMetaData(), repoType);
    outputRepositoryImpl = inputRepositoryImpl;
  }

  /**
   * Set the input repository implementation that should be used
   * 
   * @param inputRepositoryImpl Input repository implementation to be used.
   */
  public void setInputRepositoryImplementation(RepositoryImpl inputRepositoryImpl) {
    this.inputRepositoryImpl = inputRepositoryImpl;
  }

  /**
   * Set the output repository implementation that should be used
   * 
   * @param outputRepositoryImpl Output repository implementation to be used.
   */
  public void setOutputRepositoryImplementation(RepositoryImpl outputRepositoryImpl) {
    this.outputRepositoryImpl = outputRepositoryImpl;
  }

  /**
   * Adds the passed record to the output repository
   * 
   * @param uniqueId Unique identifier of the record
   * @param values Values to be held with the record
   */
  protected void addRecord(String uniqueId, List<String> values) {
    outputRepositoryImpl.addRecord(uniqueId, values);
  }

  /**
   * Item to be added to the output repository, if another item already exists with its unique
   * identifier it will be replaced by this item
   * 
   * @param itemToAdd New item to be added
   */
  public abstract void addItem(T itemToAdd);

  /**
   * Items to be added to the output repository, items will be added sequentially if another item
   * already exists with its unique identifier only the last item with the duplicate identifier will
   * be kept
   * 
   * @param itemsToAdd New items to be added
   */
  public void addItems(List<T> itemsToAdd) {
    for (T curItem : itemsToAdd) {
      addItem(curItem);
    }
  }

  /**
   * Record with the specified unique identifier will be removed from the output repository
   * returning true if one was found with that id, or false if no record was found with the passed
   * identifier
   * 
   * @param uniqueId Unique identifier of the record
   * @return Returns true if there was a record found with the passed identifier
   */
  protected boolean deleteRecord(String uniqueId) {
    return outputRepositoryImpl.deleteRecord(uniqueId);
  }

  /**
   * Item with the passed unique identifier will be removed from the output repository returning
   * true if one was found with that id, or false if no item was found with the passed identifier
   * 
   * @param uniqueId Unique identifier of the item
   * @return Returns true if there was an item found with the passed identifier
   */
  public boolean deleteItem(String uniqueId) {
    return deleteRecord(uniqueId);
  }

  /**
   * Item with the passed item's unique identifier will be removed from the output repository
   * returning true if one was found with that id, or false if no record was found with the passed
   * identifier
   * 
   * @param uniqueId Unique identifier of the record
   * @return Returns true if there was an item found with the passed identifier
   */
  public abstract boolean deleteItem(T itemToRemove);

  /**
   * Reads the values associated with the passed identifier from the input repository.
   * 
   * @param uniqueId Unique identifier of the record to be read
   * @return Returns the record if found or null if not found
   */
  protected List<String> readRecord(String uniqueId) {
    return inputRepositoryImpl.readRecord(uniqueId);
  }

  /**
   * Returns the item associated with the passed identifier from the input repository.
   * 
   * @param uniqueId Unique identifier of the item to be read
   * @return Returns the item if found or null if not found
   */
  public abstract T readItem(String uniqueId);

  /**
   * Returns the unique identifiers in the input repository
   * 
   * @return Set of unique identifiers
   */
  public Set<String> getInputIds() {
    return inputRepositoryImpl.getIds();
  }

  /**
   * Returns the unique identifiers in the output repository
   * 
   * @return Set of unique identifiers
   */
  public Set<String> getOutputIds() {
    return outputRepositoryImpl.getIds();
  }

  /**
   * Returns all items in the input repository
   * 
   * @return
   */
  public List<T> readItems() {
    Set<String> ids = getInputIds();
    List<T> items = new ArrayList<T>();
    for (String id : ids) {
      items.add(readItem(id));
    }
    return items;
  }

  /**
   * Persists all data currently in the the output repository
   * 
   * @throws RepoPersistException Thrown if the repository could not be persisted
   */
  public void persist() throws RepoPersistException {
    outputRepositoryImpl.persist();
  }

  /**
   * Loads all data for the specified input repository
   * 
   * @throws RepoLoadException Thrown if the repository could not be loaded
   */
  public void load() throws RepoLoadException {
    inputRepositoryImpl.load();
  }

  public abstract List<String> getItemMetaData();

  public String toString() {
    return outputRepositoryImpl.toString();
  }
}
