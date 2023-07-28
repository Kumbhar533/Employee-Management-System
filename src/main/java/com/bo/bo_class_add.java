package com.bo;

public class bo_class_add {

	private int Id;
	private String Name;
    private String City;
    private String Department;
    private String  join;
    private int salary;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getDepartment() {
		return Department;
	}
	public void setDepartment(String department) {
		Department = department;
	}
	public String getJoin() {
		return join;
	}
	public void setJoin(String join) {
		this.join = join;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public bo_class_add(int id, String name, String city, String department, String join, int salary) {
		super();
		Id = id;
		Name = name;
		City = city;
		Department = department;
		this.join = join;
		this.salary = salary;
	}
	public bo_class_add() {
		super();
	}
	@Override
	public String toString() {
		return "bo_class_add [Id=" + Id + ", Name=" + Name + ", City=" + City + ", Department=" + Department + ", join="
				+ join + ", salary=" + salary + "]";
	}
    
}
