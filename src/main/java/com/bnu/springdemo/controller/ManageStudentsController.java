/**
 * @author Muhammad Haris
 * Feb 22, 2014
 */
package com.bnu.springdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bnu.springdemo.service.StudentService;

/**
 *
 */
@Controller
public class ManageStudentsController {

	@Autowired
	private StudentService studentService;

	@RequestMapping(value = "/manageStudents")
	public String getAllStudents(Model model) {
		model.addAttribute("studentsList", studentService.getAllStudents());

		// create the JSP first
		return "ManageStudents";
	}
}
