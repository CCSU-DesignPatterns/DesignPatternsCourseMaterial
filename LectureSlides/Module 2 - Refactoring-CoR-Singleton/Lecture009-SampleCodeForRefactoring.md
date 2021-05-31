# Design: Generic refactoring
### Refactor the following (resulting code and UML)
===============================================

```
public class Pizza {
   XMLUtil xmlUtil = new XMLUtil();
   List ingredients;

   public void prepareFood() {
    gatherIngredients(); //uses list of ingredients
    mixIngredients();
    putInCookingVessel();
    cook(); //different implementation details
    plateFood();
   }

   public void cook() {
      // Do something pizza specific
   }
   public String toXML() {
      String returnXML = xmlUtil.simpleAttributesToXML(this);
      returnXML += xmlUtil.complexAttributesToXML(this);
      returnXML = xmlUtil.classToXML(this, returnXML);
      return returnXML;
   }
}
```

```
public class Cake {
   XMLUtil xmlUtil = new XMLUtil();
   List ingredients;
   
   public void prepareFood() {
      gatherIngredients(); //uses list of ingredients
      mixIngredients();
      putInCookingVessel();
      cook(); //different implementation details
      plateFood();
      lightCandles();
   }
   
   public void cook() {
      // Do something cake specific
   }

   public String toXML() {
      String returnXML = xmlUtil.simpleAttributesToXML(this);
      returnXML += xmlUtil.complexAttributesToXML(this);
      returnXML = xmlUtil.classToXML(this, returnXML);
      return returnXML;
   }
}
```

```
public class Refuge extends Land {
   XMLUtil xmlUtil = new XMLUtil();
   
   public String toXML() {
      String returnXML = xmlUtil.simpleAttributesToXML(this);
      returnXML += xmlUtil.complexAttributesToXML(this);
      returnXML = xmlUtil.classToXML(this, returnXML);
      return returnXML;
   }
}
```
