/**
 * @author Muhammad Haris
 * Feb 22, 2014
 */
package com.bnu.springdemo.controller;

import java.security.MessageDigest;
import java.security.Security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bnu.springdemo.entity.Authorities;
import com.bnu.springdemo.entity.Users;
import com.bnu.springdemo.service.userService;
import com.sun.org.apache.xml.internal.security.utils.Base64;

/**
 *
 */
@Controller
public class LoginController {
	@Autowired
	private userService userService;

	// private static final Logger logger =
	// LoggerFactory.getLogger(HomePageController.class);

	@RequestMapping(value = "/login")
	public String showLoginPage() {
		// logger.info("Going to Load Login Form");
		return "LoginForm";
	}

	@RequestMapping(value = "/common/home", method = RequestMethod.GET)
	public String showHomePage() {
		return "home";
	}

	@RequestMapping(value = "/common/RegisterUser")
	public String UserRegisterPage(Model model) {
		// logger.info("Going to Load Login Form");
		model.addAttribute("check", 1);
		return "RegisterUser";
	}

	@RequestMapping(value = "/sysadmin/RegisterUser")
	public String SysAdminRegisterPage(Model model) {
		model.addAttribute("check", 2);
		// logger.info("Going to Load Login Form");
		return "RegisterUser";
	}

	@RequestMapping(value = "/iniadmin/RegisterUser")
	public String IniAdminRegisterPage(Model model) {
		model.addAttribute("check", 3);
		// logger.info("Going to Load Login Form");
		return "RegisterUser";
	}

	@RequestMapping(value = "/saveRegister")
	public String SaveRegister(Model model,
			@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName,
			@RequestParam("userName") String userName,
			@RequestParam("contactNo") String contactNo,
			@RequestParam("emailId") String emailId,
			@RequestParam("password") String password,
			@RequestParam("check") int check) {
		Users users = new Users();
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			md.update(password.getBytes());

			byte byteData[] = md.digest();

			// convert the byte to hex format method 1
			// StringBuffer sb = new StringBuffer();
			// for (int i = 0; i < byteData.length; i++) {
			// sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16)
			// .substring(1));
			// }
			//
			// System.out.println("Hex format : " + sb.toString());
			//
			// // convert the byte to hex format method 2
			// StringBuffer hexString = new StringBuffer();
			// for (int i = 0; i < byteData.length; i++) {
			// String hex = Integer.toHexString(0xff & byteData[i]);
			// if (hex.length() == 1)
			// hexString.append('0');
			// hexString.append(hex);
			// }
			// System.out.println("Hex format : " + hexString.toString());
			String ppp = Base64.encode(byteData);
			System.out.println(ppp);
			users.setFirstName(firstName);
			users.setLastName(lastName);
			users.setUsername(userName);
			users.setPassword(ppp);
			byte a = 0;
			users.setEnabled(a);
			users.setUserContactNo(contactNo);
			users.setUserEmailId(emailId);
			byte block = 0;
			users.setBlock(block);
			userService.addUsers(users);
			Authorities authorities = new Authorities();
			authorities.setUsers(users);
			if (check == 1) {
				authorities.setAuthority("ROLE_USER");
			} else if (check == 2) {
				authorities.setAuthority("ROLE_SYSADMIN");
			} else if (check == 3) {
				authorities.setAuthority("ROLE_INIADMIN");
			}
			userService.addauthority(authorities);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "LoginForm";
	}
}
