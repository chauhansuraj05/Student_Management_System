package sms;

import java.util.*;

public class StudentService {
    
    Map<Integer , Student> studentMap = new HashMap<>();
    
    //CREATE
    public void addStudent(int id , String name, int age) {
    	if(studentMap.containsKey(id)) {
    		System.out.println("Stduent is Already Exists!!");
    		return;
    	}
    	
    	studentMap.put(id, new Student(id , name , age));
    	System.out.println("Stdent ID is Created!");
    }
    
  //READ
    public void viewStudent() {
    	
    	if(studentMap.isEmpty()) {
    		System.out.println("Student iS not Found!!");
    		return;
    	}
    	
    	for(Student s :studentMap.values()) {
    		System.out.println(s);
    	}
    	
    }
    
    
    //UPDATE
    public void updateStudent(int id , String name, int age) {
    	Student s = studentMap.get(id);
    	
    	if(s == null) {
    		System.out.println(" Student Not Found!!");
    		return;
    	}
    	
    	s.setName(name);
    	s.setAge(age);
    	System.out.println("Stduent Updated Successfully");
    }
    
    //DELETE
    public void deleteStudent(int id) {
    	if(studentMap.remove(id)!= null) {
    		System.out.println("Student Deleted Successfully!!");
    		return;
    	}else {
    		System.out.println("Student Not Found");
    	}
    }
 }
