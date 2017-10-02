/**
 * @author Muhammad Haris
 * Feb 22, 2014
 */
package com.bnu.springdemo.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bnu.springdemo.entity.Student;

/**
 *
 */
@Repository
public class StudentDAO {

	private HibernateTemplate hibernateTemplate;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		hibernateTemplate = new HibernateTemplate(sessionFactory);
	}

	@Transactional
	public List<Student> getAllStudents() {
		return hibernateTemplate.loadAll(Student.class);
	}

	@Transactional
	public Student getStudentById(Long id) {
		return hibernateTemplate.get(Student.class, id);
	}

	@Transactional
	public void saveStudent(Student s) {
		hibernateTemplate.saveOrUpdate(s);
	}
	
	public void deleteStudent(Student s) {
		hibernateTemplate.delete(s);
	}
}
