package edu.ccsu.designpatterns.builder.vehicle;

/**
 * Sport decorator for Seat, for simplicity no methods
 */
public class SportSeat implements Seat{
  private final Seat decoratedSeat;
  public SportSeat(Seat seat){
    this.decoratedSeat = seat;
  }
  public String toString(){
    return "Sport"+decoratedSeat.toString();
  }
}
