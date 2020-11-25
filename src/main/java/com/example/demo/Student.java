package com.example.demo;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class Student {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer SID;
  
  private String subjectname;

  private String course;
    
  private String email;
	
  private String address;

  public Student(Integer sID, String subjectname, String course, String email, String address) {
	super();
	SID = sID;
	this.subjectname = subjectname;
	this.course = course;
	this.email = email;
	this.address = address;
}



  public Integer getSID() {
	return SID;
}

public void setSID(Integer sID) {
	SID = sID;
}

public String getSubjectname() {
	return subjectname;
}

public void setSubjectname(String subjectname) {
	this.subjectname = subjectname;
}

public String getCourse() {
	return course;
}

public void setCourse(String course) {
	this.course = course;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}



}
