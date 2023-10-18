package edu.ccsu.designpatterns.iterator;

public class Main {

  public static void main(String[] args) {
    Object[] originalArray = {"first", "second", "third", "fourth"};
    AList aList = new AList(originalArray);

    List list = aList;
    Iterator iter = list.iterator();
    while (iter.hasNext()) {
      System.out.print(iter.next() + " ");
    }
    System.out.println("");

    iter = aList.backwardIterator();
    while (iter.hasNext()) {
      System.out.print(iter.next() + " ");
    }
    System.out.println("");

    list = new LinkedList(originalArray);
    iter = list.iterator();
    while (iter.hasNext()) {
      System.out.print(iter.next() + " ");
    }
    System.out.println("");
  }

}
