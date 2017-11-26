package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.pojo.Student;

public class GetStudents {
	public static List<Student> getStudent(){
		List<Student> listStu = new ArrayList<>();
		for (int i = 0; i < 50; i++) {
			Student student = new Student(i+1,"stu"+i,5*(int)(Math.random()*8+1)+60);
			listStu.add(student);
		}
		return listStu;
	}
}
