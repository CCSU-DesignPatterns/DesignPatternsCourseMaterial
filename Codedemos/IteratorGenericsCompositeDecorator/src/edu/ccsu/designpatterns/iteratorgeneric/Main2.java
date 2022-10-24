package edu.ccsu.designpatterns.iteratorgeneric;

import java.util.ArrayList;
import java.util.List;

public class Main2 {

	public static List<Employee> findMatchingEmployees(String name, List<? extends Employee> employees) {
		List<Employee> matches = new ArrayList<>();
		for (Employee e : employees) {
			if (e.getName().equals(name)) {
				matches.add(e);
			}
		}
		return matches;
	}

	public static void main(String[] args) {
		List<Manager> managers = new ArrayList<Manager>();
		List<Employee> employees = new ArrayList<Employee>();
		managers.add(new Manager("Alice"));
		managers.add(new Manager("Charlie"));

		employees.add(new Employee("Will"));
		employees.add(new Manager("Charlene"));
		employees.add(new Manager("Charlie"));

		Manager<Manager> ceo = new Manager<Manager>("Jeff B.");

		List<Employee> matches = findMatchingEmployees("Charlie", managers);
		System.out.println(matches.toString());
	}

}
