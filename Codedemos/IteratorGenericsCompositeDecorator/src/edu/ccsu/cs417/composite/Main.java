package edu.ccsu.cs417.composite;

import java.util.Iterator;

/**
 * Demonstrate composite pattern
 */
public class Main {

  public static void main(String[] args) {
    // Construct part-whole hierarchy
    ComputerComposite graphicsCard = new GraphicsCard(300, "GC1");
    graphicsCard.add(new CPU(4));
    graphicsCard.add(new RAMChip(200));
    ComputerComposite motherboard = new Motherboard(600, 2.5);
    motherboard.add(graphicsCard);
    motherboard.add(new CPU(4));
    motherboard.add(new CPU(6));
    motherboard.add(new RAMChip(200));
    motherboard.add(new RAMChip(200));

    ComputerComposite composite = motherboard;
    // What client would see
    double price = composite.getPriceTotal();
    System.out.println("Total price: " + price);

    System.out.println("Shallow iterator");
    Iterator<ComputerComponent> iterator = composite.iterator();
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }
    System.out.println("Deep leaf iterator");
    iterator = composite.deepLeafIterator();
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }

    // Demonstration of well behaved...
    System.out.println("Demonstration of well behaved equals and hashCode...");
    CPU cpu1 = new CPU(4);
    CPU cpu2 = new CPU(4);
    RAMChip rc1 = new RAMChip(200);
    RAMChip rc2 = new RAMChip(200);
    ComputerComposite gc1 = new GraphicsCard(300, "GC1");
    gc1.add(cpu1);
    gc1.add(rc1);
    ComputerComposite gc2 = new GraphicsCard(300, "GC1");
    gc2.add(cpu2);
    gc2.add(rc2);
    ComputerComposite mb1 = new Motherboard(600, 2.5);
    mb1.add(gc1);
    mb1.add(new CPU(4));
    ComputerComposite mb2 = new Motherboard(600, 2.5);
    mb2.add(gc2);
    mb2.add(new CPU(4));
    System.out.println("MB1: " + mb1.toString());
    System.out.println("MB2: " + mb2.toString());
    System.out.println("MB1 equals MB2: " + mb1.equals(mb2));
    System.out.println("MB1 hash: " + mb1.hashCode() + "  MB2 hash: " + mb2.hashCode());
    System.out.println("Now change property on CPU deep within composite...");
    cpu2.setNumCores(3);
    System.out.println("MB1: " + mb1.toString());
    System.out.println("MB2: " + mb2.toString());
    System.out.println("MB1 equals MB2: " + mb1.equals(mb2));
    System.out.println("MB1 hash: " + mb1.hashCode() + "  MB2 hash: " + mb2.hashCode());
  }
}
