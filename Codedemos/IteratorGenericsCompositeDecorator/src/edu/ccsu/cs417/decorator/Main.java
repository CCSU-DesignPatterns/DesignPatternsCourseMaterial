package edu.ccsu.cs417.decorator;

import edu.ccsu.cs417.composite.CPU;
import edu.ccsu.cs417.composite.ComputerComponent;
import edu.ccsu.cs417.composite.ComputerComposite;
import edu.ccsu.cs417.composite.GraphicsCard;
import edu.ccsu.cs417.composite.Motherboard;
import edu.ccsu.cs417.composite.RAMChip;

/**
 * Demonstration of decorator pattern
 */
public class Main {
  public static void main(String[] args){
    // Construct part-whole hierarchy
    ComputerComposite graphicsCard = new GraphicsCard();
    graphicsCard.add(new CPU());
    graphicsCard.add(new RAMChip());
    ComputerComposite motherboard = new Motherboard();
    // Add decorator for price to be adjusted based on market
    motherboard.add(new MarketPriceAdjusterDecorator(graphicsCard));
    motherboard.add(new CPU());
    motherboard.add(new CPU());
    // 10% discount on these all motherboard RAMChips
    motherboard.add(new SaleDecorator(.9,new RAMChip()));
    ComputerComponent chip =new RAMChip();
    chip = new SaleDecorator(.9, chip);
    // Extra 50% off for this chip, so add a decorator on the decorator
    chip = new SaleDecorator(.5, chip);
    motherboard.add(chip);

  }
}
