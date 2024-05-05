package com.siddhu.hibernate.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.siddhu.hibernate.model.Student;

public class StudentDaoImpl implements StudentDao{
	EntityManager entityManager;
	EntityTransaction entityTransaction;
	Query query;
	String jpql;
	
	public StudentDaoImpl() {
		entityManager = MyConnection.getConnection();
	}

	@Override
	public String addStudent(Student s) {
		entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(s);
		entityTransaction.commit();
		return "1 Student Added";
	}

	@Override
	public String updateStudent(Student s) {
		Student s1 = entityManager.find(Student.class, s.getRoll());
		if(s1!=null) {
			entityTransaction=entityManager.getTransaction();
			s1.setName(s.getName());
			s1.setContact(s.getContact());
			entityTransaction.begin();
			entityManager.persist(s1);
			entityTransaction.commit();
			return "1 Student Updated";
		}
		else {
			return "Record not found";
		}
		
		
	}

	@Override
	public String deleteStudent(Integer id) {
		Student s = entityManager.find(Student.class, id);
		if(s!=null) {
			entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(s);
			entityTransaction.commit();
			return "1 Student deleted";
		}
		else {
			return "Record not found";
		}
		
	}

	@Override
	public Student findById(Integer id) {
		Student s =entityManager.find(Student.class, id);
		return s;
	}

	@Override
	public List<Student> showAllStudents() {
		jpql = "select s from Student s";  //jpql = "from Student s";  <--- can do this
		query = entityManager.createQuery(jpql);
		List<Student> list = query.getResultList();
		return list;
	}

}
