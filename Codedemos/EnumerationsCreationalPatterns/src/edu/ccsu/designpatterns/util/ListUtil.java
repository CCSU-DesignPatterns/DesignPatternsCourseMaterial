package edu.ccsu.designpatterns.util;

import java.util.List;

/**
 * Provides some basic common functions for acting on List interface
 */
public class ListUtil {
  public static String listToString(List<?> items){
    String returnString = "{";
    for (Object o : items){
      returnString += o.toString()+" ";
    }
    return returnString +"}";
  }
}
