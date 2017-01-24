package com.test.student_exam;

import java.util.Date;

public class Student {
	private int no;
	private String name;
	private char gender;
	private int major;
	private int city;
	private Date created_at;
	
	public Student(int no, String name, char gender, int major, int city){
		setNo(no); setName(name); setGender(gender); setMajor(major); setCity(city);
		this.created_at = new Date();
	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public int getMajor() {
		return major;
	}
	public void setMajor(int major) {
		this.major = major;
	}
	public int getCity() {
		return city;
	}
	public void setCity(int city) {
		this.city = city;
	}
	public Date getCreated_at() {
		return created_at;
	}
	
	
}
