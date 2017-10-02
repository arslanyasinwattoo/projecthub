package com.bnu.springdemo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bnu.springdemo.entity.Domain;
import com.bnu.springdemo.entity.Institute;
import com.bnu.springdemo.entity.InstituteAdmin;
import com.bnu.springdemo.entity.Project;
import com.bnu.springdemo.entity.Users;
import com.bnu.springdemo.service.userService;

@Controller
public class IniAdminController {
	@Autowired
	private userService userService;

	@RequestMapping(value = "/iniadmin/Institute")
	public String IniAdminInstitute(Model model) {
		List<InstituteAdmin> listOfInstitute = new ArrayList<>();
		// List<Institute> pendingList = new ArrayList<>();
		List<InstituteAdmin> pendingList = new ArrayList<>();

		try {
			Authentication auth = SecurityContextHolder.getContext()
					.getAuthentication();
			String username = auth.getName();
			System.out.println(username);
			listOfInstitute = userService.getAllInstituteOfUser(username);
			pendingList = userService.getpendingInstituteOfUser(username);
			for (InstituteAdmin instituteAdmin : listOfInstitute) {
				Users user = instituteAdmin.getUsers();
				System.out.println(user.getUsername());
				Institute institute = instituteAdmin.getInstitute();
				System.out.println(institute.getInstituteName());
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error");
		}

		model.addAttribute("ListOfInstitute", listOfInstitute);
		model.addAttribute("pendingList", pendingList);
		// model.addAttribute("pendingList", pendingList);

		// logger.info("Going to Load Login Form");
		return "iniadmin-Institute";
	}

	@RequestMapping(value = "/iniadmin/SaveInstitute")
	public String IniAdminSaveInstitute(Model model,
			@RequestParam("name") String name) {
		String url = "";
		InstituteAdmin admin = new InstituteAdmin();
		Institute institute = new Institute();
		institute.setPending(0);
		institute.setBlock(0);
		institute.setInstituteName(name);
		List<Institute> instituteList = new ArrayList<>();
		try {

			userService.addInstitute(institute);
			// Authentication auth = SecurityContextHolder.getContext()
			// .getAuthentication();
			// String username = auth.getName();
			instituteList = userService.getAllInstitute();
			for (Institute institute2 : instituteList) {
				if (institute.getInstituteName().equalsIgnoreCase(
						institute2.getInstituteName())) {
					institute.setInstituteId(institute2.getInstituteId());
				}
				admin.setInstitute(institute);
				userService.addInstituteAdmin(admin);
			}
			url = "redirect:/iniadmin/Inistitute.bnu";
			// logger.info("Going to Load Login Form");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return url;
	}

	@RequestMapping(value = "/iniadmin/BlockedInstitute")
	public String IniAdminBlockedInstitute(Model model) {
		List<InstituteAdmin> blockedInstitute = new ArrayList<>();
		try {
			Authentication auth = SecurityContextHolder.getContext()
					.getAuthentication();
			String username = auth.getName();
			blockedInstitute = userService.getBlockedInstituteOfUser(username);
			for (InstituteAdmin instituteAdmin : blockedInstitute) {
				System.out.println(instituteAdmin.getInstitute()
						.getInstituteName());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("blockedList", blockedInstitute);

		// logger.info("Going to Load Login Form");
		return "iniadmin-BlockedInstitute";
	}

	@RequestMapping(value = "/iniadmin/ListOfInstitute")
	public String IniAdminListOfInstitute(Model model) {
		List<InstituteAdmin> listOfInstitute = new ArrayList<>();
		try {
			Authentication auth = SecurityContextHolder.getContext()
					.getAuthentication();
			String username = auth.getName();
			listOfInstitute = userService.getAllInstituteOfUserp(username);
			// listOfInstitute = userService.getAllInstituteOfUser(username);
			for (InstituteAdmin instituteAdmin : listOfInstitute) {
				System.out.println(instituteAdmin.getInstitute()
						.getInstituteName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("pendingList", listOfInstitute);
		// logger.info("Going to Load Login Form");
		return "iniadmin-ListOfInstitute";
	}

	@RequestMapping(value = "/iniadmin/updateInstituteStatus", method = RequestMethod.GET)
	public String IniAdminUpdateInstituteStatus(Model model,
			@RequestParam(required = false) Long id, String name, byte block,
			byte enabled, int check) {
		String url = "";
		Institute institute = new Institute();

		institute.setInstituteId(id);
		institute.setInstituteName(name);
		institute.setPending(enabled);
		institute.setBlock(block);

		try {
			userService.updateInstituteStatus(institute);
			if (check == 1) {
				url = "redirect:/iniadmin/Institute.bnu";
			}
			if (check == 2) {
				url = "redirect:/iniadmin/BlockedInstitute.bnu";
			}
			if (check == 3) {
				url = "redirect:/iniadmin/ListOfInstitute.bnu";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// logger.info("Going to Load Login Form");
		return url;
	}

	@RequestMapping(value = "/iniadmin/Projects")
	public String iniAdminProjects(Model model) {
		List<Project> pendingProjects = new ArrayList<>();
		List<Project> blockedProjects = new ArrayList<>();
		try {
			Authentication auth = SecurityContextHolder.getContext()
					.getAuthentication();
			String username = auth.getName();
			blockedProjects = userService.getAllblockedProjects();
			pendingProjects = userService.getAllpendingProjects();
			for (Project project : blockedProjects) {
				System.out.println(project.getProjectName());
			}
			// for (Users users : blockedUsers) {
			// System.out.println(users.getFirstName());
			// }

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error");
		}
		model.addAttribute("pendingList", pendingProjects);
		model.addAttribute("blockedList", blockedProjects);

		// logger.info("Going to Load Login Form");
		return "iniadmin-Projects";
	}

	// @RequestMapping(value = "/iniadmin/BlockedProjects")
	// public String iniAdminBlockedProjects(Model model) {
	// List<Project> blockedProjects = new ArrayList<>();
	// try {
	// byte block = 1;
	// blockedProjects = userService.getblockedProjects(block);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// model.addAttribute("blockedList", blockedProjects);
	//
	// // logger.info("Going to Load Login Form");
	// return "iniadmin-BlockedProjects";
	// }
	//
	// @RequestMapping(value = "/iniadmin/ListOfProjects")
	// public String iniAdminListOfProjects(Model model) {
	// List<Users> listOfUsers = new ArrayList<>();
	// try {
	// listOfUsers = userService.getAllUsers();
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// model.addAttribute("ListOfUsers", listOfUsers);
	// // logger.info("Going to Load Login Form");
	// return "sysadmin-ListOfUsers";
	// }
	//
	// @RequestMapping(value = "/sysadmin/updateUsersStatus", method =
	// RequestMethod.GET)
	// public String SysAdminUpdateUsersStatus(Model model,
	// @RequestParam(required = false) String username, byte block,
	// byte enabled, int check) {
	// String url = "";
	// Project project= new Project();
	// List<Project> projectList = new ArrayList<>();
	// // System.out.println(username);
	// try {
	// userList = userService.getUsersByName(username);
	// //for (Users users2 : userList) {
	// // System.out.println(users2.getFirstName());
	// // System.out.println("usersname" + users2.getUsername());
	// //users.setUserContactNo(users2.getUserContactNo());
	// //users.setUserEmailId(users2.getUserEmailId());
	// // users.setPassword(users2.getPassword());
	// // users.setFirstName(users2.getFirstName());
	// // users.setLastName(users2.getLastName());
	// }
	// //users.setUsername(username);
	// //users.setBlock(block);
	// // System.out.println("block:" + block);
	//
	// //users.setEnabled(enabled);
	// // System.out.println("enabled:" + enabled);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// try {
	// userService.updateUserStatus(users);
	// if (check == 1) {
	// url = "redirect:/sysadmin/BlockedUsers.bnu";
	// }
	// if (check == 2) {
	// url = "redirect:/sysadmin/Users.bnu";
	// }
	// if (check == 3) {
	// url = "redirect:/sysadmin/ListOfUsers.bnu";
	// }
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	//
	// // logger.info("Going to Load Login Form");
	// return url;
	// }
	//

}
