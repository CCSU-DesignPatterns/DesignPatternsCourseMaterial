package edu.ccsu.mementoexample;

/**
 * Same model as other Originator but based on java record implementation
 */
public class OriginatorRecordBased {
  private String transferrableInfo;
  private String valueNotInMemento;

  public OriginatorRecordBased() {}

  public OriginatorRecordBased(MementoRecord memento) {
    if (memento instanceof MementoRecordImplementation mementoRI) {
      this.transferrableInfo = mementoRI.transferrableInfo();
    } else {
      throw new IllegalArgumentException("Invalid memento record");
    }
  }

  public OriginatorRecordBased(String valueNotInMemento, String transferrableInfo) {
    this.valueNotInMemento = valueNotInMemento;
    this.transferrableInfo = transferrableInfo;
  }

  public String toString() {
    return "Originator(transferrableInfo: " + transferrableInfo + "  valueNotInMemento: "
        + valueNotInMemento + ")";
  }

  public MementoRecord createMemento() {
    MementoRecord memento = new MementoRecordImplementation(this.transferrableInfo);
    return memento;
  }

  public void restoreFromMemento(MementoRecord memento) {
    if (memento instanceof MementoRecordImplementation mementoRI) {
      this.transferrableInfo = mementoRI.transferrableInfo();
    } else {
      throw new IllegalArgumentException("Invalid memento record");
    }
  }



  public interface MementoRecord {

  }

  private static record MementoRecordImplementation(String transferrableInfo)
      implements MementoRecord {
  }
}
