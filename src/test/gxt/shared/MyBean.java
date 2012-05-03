package test.gxt.shared;

import java.io.Serializable;

public class MyBean implements Serializable {
	private String id;
	private String firstName, lastName;
	private int age;

	public MyBean() {

	}

	public MyBean(String id, String firstName, String lastName, int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "MyBean [firstName=" + firstName + ", lastName=" + lastName
				+ ", age=" + age + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}