package edu.ccsu.designpatterns.builder.vehicle;

import edu.ccsu.designpatterns.util.ListUtil;
import java.util.List;

/**
 *
 * @author cw1491
 */
public class Axel{
  private final List<Wheel> wheels;
  public Axel(List<Wheel> wheels){
    this.wheels = wheels;
  }

  public String toString(){
    return "[Axel "+ ListUtil.listToString(wheels)+ "]";
  }
}
