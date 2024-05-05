package com.siddhu.hibernate.dao;

import java.util.List;

import com.siddhu.hibernate.model.Student;

public interface StudentDao {
	String addStudent(Student s);
	String updateStudent(Student s);
	String deleteStudent(Integer id);
	Student findById(Integer id);
	List<Student> showAllStudents();
}
