package edu.ccsu.designpatterns.bridge.implementation;

import java.util.List;
import java.util.Set;

/**
 * Interface for repository implementations
 * 
 * @author Chad Williams
 */
public interface RepositoryImpl {
  /**
   * Creates a record with the passed values associated with the specified unique identifier, if a
   * record already exists with that identifier it will be replaced by this record.
   * 
   * @param uniqueId Unique identifier for this record
   * @param values List of String values associated with the identifier
   */
  public void addRecord(String uniqueId, List<String> values);

  /**
   * If a record exists with the passed id the record will be removed and true will be returned, if
   * no record with that identifier was in the repository false will be returned.
   * 
   * @param uniqueId Unique identifier of the record to be deleted
   * @return Returns true if a record was found, false otherwise
   */
  public boolean deleteRecord(String uniqueId);

  /**
   * Returns the values associated with the specified unique id.
   * 
   * @param uniqueId Unique identifier of the record values to be returned
   * @return Returns the list of values associated with the passed id or null if no record was found
   */
  public List<String> readRecord(String uniqueId);

  /**
   * Returns a set of unique ids in the repository
   * 
   * @return
   */
  public Set<String> getIds();

  /**
   * Persists the records to the repository
   */
  public void persist() throws RepoPersistException;

  /**
   * Any records that have not been persisted will be lost and the repository will be loaded from
   * the persisted repository.
   */
  public void load() throws RepoLoadException;

}
