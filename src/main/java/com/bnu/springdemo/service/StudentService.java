/**
 * @author Muhammad Haris
 * Feb 22, 2014
 */
package com.bnu.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bnu.springdemo.dao.StudentDAO;
import com.bnu.springdemo.entity.Student;

/**
 *
 */
@Service
public class StudentService {

	@Autowired
	private StudentDAO studentDAO;

	public List<Student> getAllStudents() {
		return studentDAO.getAllStudents();
	}
}
