package edu.ccsu.cs417.iteratorgeneric;

import edu.ccsu.cs417.iteratorgeneric.SpecialWidget;
import edu.ccsu.cs417.iteratorgeneric.Widget;
import edu.ccsu.cs417.iteratorgeneric.WidgetCollection;
import java.util.Iterator;

/**
 * Demo of generics and iterator
 */
public class Main {

  /**
   * Specific type specified by iterator
   */
  public static void printWidgetNames(Iterator<Widget> wIterator) {
    while (wIterator.hasNext()) {
      System.out.println(wIterator.next().getWidgetName());
    }
  }

  /**
   * Wild card iterator
   */
  public static void printWildWidgetNames(Iterator<? extends Widget> wIterator) {
    while (wIterator.hasNext()) {
      System.out.println(wIterator.next().getWidgetName());
    }
  }

  public static void main(String[] args) {
    WidgetCollection<Widget> basicWCollection = new WidgetCollection<Widget>();
    basicWCollection.addFirstItem(new Widget());
    basicWCollection.addFirstItem(new SpecialWidget());
    basicWCollection.addSecondItem(new Widget());
    // Iterator over basic Widget collection
    Iterator<Widget> basicWIter = basicWCollection.iterator();
    System.out.println("Basic simple iterator printWidgetNames");
    printWidgetNames(basicWIter);
    basicWIter = basicWCollection.iterator();
    System.out.println("Basic simple iterator printWildWidgetNames");
    printWidgetNames(basicWIter);

    // Iterator over SpecialWidget collection
    WidgetCollection<SpecialWidget> specialWCollection = new WidgetCollection<SpecialWidget>();
    //Next line would cause a compile error
    //specialWCollection.addFirstItem(new Widget());
    specialWCollection.addFirstItem(new SpecialWidget());
    specialWCollection.addFirstItem(new SpecialWidget());
    specialWCollection.addSecondItem(new SpecialWidget());

    // Compile error
    //Iterator<Widget> specialWIterator = specialWCollection.iterator();
    Iterator<SpecialWidget> specialWIterator = specialWCollection.iterator();
    // Compile error
    //printWidgetNames(specialWIterator);
    System.out.println("SpecialWidget iterator");
    printWildWidgetNames(specialWIterator);
  }
}
