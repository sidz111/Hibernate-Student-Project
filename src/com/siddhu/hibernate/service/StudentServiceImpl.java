package com.siddhu.hibernate.service;

import java.util.List;

import com.siddhu.hibernate.dao.StudentDao;
import com.siddhu.hibernate.dao.StudentDaoImpl;
import com.siddhu.hibernate.model.Student;

public class StudentServiceImpl implements StudentService{
	StudentDao studentDao;
	
	public StudentServiceImpl() {
		studentDao= new StudentDaoImpl();
	}

	@Override
	public String addStudent(Student s) {
	String ans = null;
	ans = studentDao.addStudent(s);
		return ans;
	}

	@Override
	public String updateStudent(Student s) {
		String ans = null;
		ans = studentDao.updateStudent(s);
		return ans;
	}

	@Override
	public String deleteStudent(Integer id) {
		String ans = null;
		ans = studentDao.deleteStudent(id);
		return ans;
	}

	@Override
	public Student findById(Integer id) {
		Student s  = null;
		s = studentDao.findById(id);
		return s;
	}

	@Override
	public List<Student> showAllStudents() {
		List<Student> list  = null;
		list = studentDao.showAllStudents();
		return list;
	}

}
