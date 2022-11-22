package edu.ccsu.designpatterns.bridge.implementation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CsvRepositoryImpl extends FileBasedRepositoryImpl {

  public CsvRepositoryImpl(String repositoryName, List<String> itemMetaData) {
    super(repositoryName, itemMetaData);
  }

  @Override
  public void persist() throws RepoPersistException {
    writeToFile(this.toString());
  }

  @Override
  public void load() throws RepoLoadException {
    try {
      BufferedReader reader = new BufferedReader(new FileReader(getFileName()));
      String line = reader.readLine();
      // ignore header line
      line = reader.readLine();
      while (line != null) {
        String[] lineParts = line.split(",");
        String id = lineParts[0];
        List<String> values = Arrays.asList(Arrays.copyOfRange(lineParts, 1, lineParts.length));
        records.put(id, values);
        line = reader.readLine();
      }
    } catch (IOException e) {
      System.err.println("Error reading from repository (" + getFileName() + ")");
      throw new RepoLoadException("Error reading from repository (" + getFileName() + ")", e);
    }

  }

  @Override
  protected String getFileFormatExtension() {
    return ".csv";
  }

  private String getCSVHeader() {
    return String.join(",", itemMetaData);
  }

  /**
   * Return string representation of this repository
   */
  public String toString() {
    StringBuffer buffer = new StringBuffer();
    // Add CSV header
    buffer.append(getCSVHeader() + "\n");
    Set<Map.Entry<String, List<String>>> recordEntries = records.entrySet();
    // Convert each record to a CSV row
    for (Map.Entry<String, List<String>> entry : recordEntries) {
      buffer.append(entry.getKey() + "," + String.join(",", entry.getValue()) + "\n");
    }
    return buffer.toString();
  }
}
