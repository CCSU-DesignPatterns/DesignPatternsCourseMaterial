package edu.ccsu.designpatterns.iteratorgeneric;

import java.util.ArrayList;
import java.util.List;

public class Manager<T extends Employee> extends Employee {
	List<T> manages;

	public Manager(String name) {
		super(name);
		manages = new ArrayList<>();
		
	}

	public void addManagee(T person) {
		manages.add(person);
	}

}
