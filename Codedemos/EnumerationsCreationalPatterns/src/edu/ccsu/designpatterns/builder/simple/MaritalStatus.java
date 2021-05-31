package edu.ccsu.designpatterns.builder.simple;

/**
 * Example enumeration of marital status
 */
public enum MaritalStatus {

  MARRIED("married"),
  DIVORCED("divorced"),
  SEPARATED("separated"),
  SINGLE("single");

  private final String description;

  private MaritalStatus(String description) {
    this.description = description;
  }

  @Override
  public String toString() {
    return description;
  }
}
