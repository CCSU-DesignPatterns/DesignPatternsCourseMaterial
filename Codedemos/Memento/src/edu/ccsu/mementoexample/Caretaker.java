package edu.ccsu.mementoexample;

/**
 * Example of how a Caretaker class might use a class that support Mementos
 * 
 * @author Chad Williams
 */
public class Caretaker {
  public static void main(String[] args) {
    try {
      Originator originator1 = new Originator("originator 1", "transferInfo");
      System.out.println(originator1);
      Originator.Memento memento = originator1.createMemento();

      // Two common ways memento is used by Caretaker

      // Way 1: default constructor and restore from saved memento state
      Originator originator2 = new Originator();
      originator2.restoreFromMemento(memento);
      System.out.println(originator2);

      // Way 2: construct the class directly from the saved memento state
      Originator originator3 = new Originator(memento);
      System.out.println(originator3);

      // Record based version
      OriginatorRecordBased originator4 = new OriginatorRecordBased("originator 4", "transferInfo");
      OriginatorRecordBased.MementoRecord mementoR = originator4.createMemento();
      originator4 = new OriginatorRecordBased(mementoR);
      System.out.println(originator4);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
