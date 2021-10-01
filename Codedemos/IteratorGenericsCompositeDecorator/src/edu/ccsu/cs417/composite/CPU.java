package edu.ccsu.cs417.composite;

/**
 * Simple leaf implementation would need more functionality
 */
public class CPU extends ComputerComponent {
  /** Number of cores for CPU */
  private int numCores;

  /**
   * Constructs CPU initializing the number of cores
   * 
   * @param number of cores
   */
  public CPU(int numCores) {
    this.numCores = numCores;
  }

  @Override
  public double getPriceTotal() {
    return numCores * 100;
  }

  @Override
  public boolean equals(Object passedObj) {
    if (passedObj == this) {
      return true;
    } else if (passedObj instanceof CPU) {
      return this.numCores == ((CPU) passedObj).numCores;
    } else {
      return false;
    }
  }

  /**
   * @return the numCores
   */
  public int getNumCores() {
    return numCores;
  }

  /**
   * @param numCores the number of cores to set
   */
  public void setNumCores(int numCores) {
    this.numCores = numCores;
  }

  @Override
  public int hashCode() {
    return numCores;
  }

  @Override
  public String toString() {
    return "CPU-" + super.toString();
  }
}
