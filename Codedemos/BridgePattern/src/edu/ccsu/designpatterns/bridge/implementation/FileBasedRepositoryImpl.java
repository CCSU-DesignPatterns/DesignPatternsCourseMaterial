package edu.ccsu.designpatterns.bridge.implementation;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class FileBasedRepositoryImpl implements RepositoryImpl {
  protected Map<String, List<String>> records = new HashMap<String, List<String>>();
  protected final String repositoryName;
  protected final List<String> itemMetaData;

  public FileBasedRepositoryImpl(String repositoryName, List<String> itemMetaData) {
    this.repositoryName = repositoryName;
    this.itemMetaData = itemMetaData;
  }

  @Override
  public void addRecord(String uniqueId, List<String> values) {
    records.put(uniqueId, values);
  }

  @Override
  public boolean deleteRecord(String uniqueId) {
    return (records.remove(uniqueId) != null);
  }

  @Override
  public List<String> readRecord(String uniqueId) {
    return records.get(uniqueId);
  }

  @Override
  public Set<String> getIds() {
    return records.keySet();
  }

  /**
   * Writes the passed repository contents to the associate repository file
   * 
   * @param repoContents Contents to be written
   * @throws RepoPersistException Exception thrown if repository was not able to be written
   */
  protected void writeToFile(String repoContents) throws RepoPersistException {
    try {
      FileOutputStream stream =
          new FileOutputStream(new File(repositoryName + getFileFormatExtension()));
      stream.write(repoContents.getBytes());
      stream.flush();
      stream.close();
    } catch (IOException e) {
      System.err.println("Unable to write repo: " + e.getMessage());
      throw new RepoPersistException("Unable to write repo(" + repositoryName + ")", e);
    }
  }

  protected String getFileName() {
    return repositoryName + getFileFormatExtension();
  }

  /**
   * Return the file format extension for file repository (ex. csv, xml, txt)
   * 
   * @return file extension that should be added to the repository file
   */
  protected abstract String getFileFormatExtension();
}
