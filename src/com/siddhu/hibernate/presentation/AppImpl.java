package com.siddhu.hibernate.presentation;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.siddhu.hibernate.model.Student;
import com.siddhu.hibernate.service.StudentService;
import com.siddhu.hibernate.service.StudentServiceImpl;

public class AppImpl implements App{
	StudentService studentService;
	
	Scanner sc = new Scanner(System.in);
	
	public AppImpl() {
		studentService= new StudentServiceImpl();
	}

	@Override
	public void addStudent() {
		Integer roll;
		String name;
		Long contact;
		while(true) {
			System.out.println("Enter Roll: ");
			roll = sc.nextInt();
			System.out.println("Enter name: ");
			name = sc.next();
			System.out.println("Enter contact: ");
			contact = sc.nextLong();
			Student s = new Student();
			s.setRoll(roll);
			s.setName(name);
			s.setContact(contact);
			System.out.println(studentService.addStudent(s));
			System.out.println("Do you wanna add more Student");
			Character ch = sc.next().charAt(0);
			if(ch.equals('n')|| ch.equals('N')) {
				System.out.println("As you wish");
				break;
			}
		}
		
		
	}

	@Override
	public void updateStudent() {
		Integer roll;
		String name;
		Long contact;
		while(true) {
			System.out.println("Enter roll u wanna Update: ");
			roll = sc.nextInt();
			System.out.println("Enter New Name: ");
			name=sc.next();
			System.out.println("Enter New Contact: ");
			contact = sc.nextLong();
			Student s = new Student();
			s.setRoll(roll);
			s.setName(name);
			s.setContact(contact);
			System.out.println(studentService.updateStudent(s));
			System.out.println("Do you wanna update more Student");
			Character ch = sc.next().charAt(0);
			if(ch.equals('n')|| ch.equals('N')) {
				System.out.println("As you wish");
				break;
			}
		}
		
	}

	@Override
	public void deleteStudent() {
		Integer roll;
		while(true) {
			System.out.println("Enter roll u wanna delete: ");
			roll = sc.nextInt();
			System.out.println(studentService.deleteStudent(roll));
			System.out.println("Do you wanna delete more Student");
			Character ch = sc.next().charAt(0);
			if(ch.equals('n')|| ch.equals('N')) {
				System.out.println("As you wish");
				break;
			}
		}
		
	}

	@Override
	public void findById() {
		Integer roll;
		while(true) {
			System.out.println("Enter roll u wanna Find: ");
			roll = sc.nextInt();
			Student s = new Student();
			s = studentService.findById(roll);
			if(s!=null) {
				System.out.println("Roll number is: "+s.getRoll());
				System.out.println("Name is: "+s.getName());
				System.out.println("Contact is: "+s.getContact());
				System.out.println("Do you wanna Find more");
				Character ch = sc.next().charAt(0);
				if(ch.equals('n')|| ch.equals('N')) {
					System.out.println("As you wish");
					break;
				}
			}
			else {
				System.out.println("Record not found");
				break;
			}
			
		}
		
	}

	@Override
	public void showAllStudents() {
		List<Student> list = studentService.showAllStudents();
		Iterator<Student> itr = list.iterator();
		while(itr.hasNext()) {
			Student s = new Student();
			s = itr.next();
			System.out.println("--------------------------------");
			System.out.println("Roll is: "+s.getRoll());
			System.out.println("Name is: "+s.getName());
			System.out.println("Contact is: "+s.getContact());
			System.out.println("--------------------------------");
		}
	}
}
