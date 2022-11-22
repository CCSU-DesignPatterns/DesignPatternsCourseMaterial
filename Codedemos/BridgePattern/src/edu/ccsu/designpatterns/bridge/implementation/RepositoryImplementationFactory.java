package edu.ccsu.designpatterns.bridge.implementation;

import java.util.List;

/**
 * Factory for creating repository implementations
 * 
 * @author Chad Williams
 */
public class RepositoryImplementationFactory {
  /**
   * Return default repository implementation
   * 
   * @return Returns a repository implementation with the specified repository name
   */
  public static RepositoryImpl getRepositoryImplementation(String repositoryName,
      List<String> itemMetaData) {
    return new CsvRepositoryImpl(repositoryName, itemMetaData);
  }

  /**
   * Returns repository implementation of the specified type if available otherwise return a default
   * repository type
   * 
   * @return Returns a repository implementation with the specified repository name
   */
  public static RepositoryImpl getRepositoryImplementation(String repositoryName,
      List<String> itemMetaData, RepositoryTypes repoType) {
    switch (repoType) {
      case CSV:
        return new CsvRepositoryImpl(repositoryName, itemMetaData);
      // Specified type has not been implemented yet so use default repository
      default:
        return new CsvRepositoryImpl(repositoryName, itemMetaData);
    }
  }
}
