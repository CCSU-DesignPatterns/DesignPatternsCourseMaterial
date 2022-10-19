package edu.ccsu.refactor;

public class Main {

	public static void main(String[] args) {
		Food myFood = new Pizza();
		Refuge myRefuge = new Refuge();
		
		System.out.println(myFood.toXML());
		System.out.println(myRefuge.toXML());
	}

}
