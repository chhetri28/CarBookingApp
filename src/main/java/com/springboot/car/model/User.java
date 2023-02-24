package com.springboot.car.model;

public class User {
	 	private String userName;
	    private char gender;
	    private int age;
	    
	    public User(){

	    }
	    public User(String userName, char gender, int age) {
	        this.userName = userName;
	        this.gender = gender;
	        this.age = age;
	    }
	    public String getUserName() {
	        return userName;
	    }
	    public void setUserName(String userName) {
	        this.userName = userName;
	    }
	    public char getGender() {
	        return gender;
	    }
	    public void setGender(char gender) {
	        this.gender = gender;
	    }
	    public int getAge() {
	        return age;
	    }
	    public void setAge(int age) {
	        this.age = age;
	    }
	    @Override
	    public String toString() {
	        return "User [userName=" + userName + ", gender=" + gender + ", age=" + age + "]";
	    }
}
