package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.pojo.Student;

@Service
public class ClassService {
	private List<Student> students = GetStudents.getStudent();
	private List<Student> signStudents = new ArrayList<>();

	// 模拟进入程序后的流程
	public void start() {
		System.out.println("*************************欢迎进入教室，请选择：*************************");
		System.out.println("*********************[1]签到" + "\t      " + "[2]查询" + "\t\t" + "[3]统计" + "\t\t" + "[4]退出"
				+ "*********************");
		Scanner scan = new Scanner(System.in);
		String num = scan.nextLine();
		while (true) {
			if ("1".equals(num)) {
				System.out.println("请输入名字：");
				sign();
				start();
			} else if ("2".equals(num)) {
				search();
				start();
			} else if ("3".equals(num)) {
				collect();
				start();
			} else if ("4".equals(num)) {
				return;
			}
			return;
		}

	}

	// 模拟签到
	public void sign() {
		Scanner scan = new Scanner(System.in);
		String name = scan.nextLine();
		// 使用stream对数据进行操作,返回已经签到的学生集合
		signStudents = students.stream().filter(s -> s.getName().equals(name)).collect(Collectors.toList());
		signStudents.forEach(s -> {
			System.out.println(name + "签到成功！");
		});
		System.out.println(signStudents);
	}

	// 模拟查询
	public void search() {
		List<Student> signStudents = this.signStudents;
		Scanner scan = new Scanner(System.in);
		if (students.isEmpty()) {
			System.out.println("没有学生签到。。");
		} else {
			System.out.println("请输入需要查询的学生的名字：");
			String name = scan.nextLine();
			// 使用stream查询学生是否签到
			signStudents.stream().filter(s -> s.getName().equals(name)).forEach(c -> System.out.println(name+"已经签到过了"));
			if(students.stream().filter(s -> s.getName().equals(name)).collect(Collectors.toList()).isEmpty()) {
				System.out.println("名为"+name+"的学生不存在！");
			}else {
				System.out.println(name+"还没有签到");
			}
			
		}
	}

	// 统计
	public List<Student> collect() {
		students = this.signStudents;
		System.out.println("签到的学生有：" + students);
		return students;
	}
}
