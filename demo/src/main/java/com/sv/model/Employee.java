package com.sv.model;

public class Employee {

	private int id;
	private String name;
	private int experience;
	
	

	public Employee() {
		super();
	}
	public Employee(int id, String name, int experience) {
		super();
		this.id = id;
		this.name = name;
		this.experience = experience;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", experience=" + experience + "]";
	}
	
	

}
