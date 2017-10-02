package com.bnu.springdemo.controller;

import java.util.ArrayList;
import java.util.Date;
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
import com.bnu.springdemo.entity.Keywords;
import com.bnu.springdemo.entity.Project;
import com.bnu.springdemo.entity.ProjectDomain;
import com.bnu.springdemo.entity.ProjectKeywords;
import com.bnu.springdemo.entity.ProjectRole;
import com.bnu.springdemo.entity.Role;
import com.bnu.springdemo.entity.Users;
import com.bnu.springdemo.service.userService;
import com.bnu.springdemo.util.DateTimeUtil;

@Controller
public class UserController {
	@Autowired
	private userService userService;

	@RequestMapping(value = "/user/ManageProject")
	public String userProject(Model model) {
		List<Institute> instituteList = new ArrayList<>();
		List<Project> projectList = new ArrayList<>();
		try {
			instituteList = userService.getAllInstitutes();
			Authentication auth = SecurityContextHolder.getContext()
					.getAuthentication();
			String username = auth.getName();
			projectList = userService.getAllUserProjects(username);
		} catch (Exception e) {
			e.printStackTrace();

		}
		model.addAttribute("ListOfInstitutes", instituteList);
		model.addAttribute("ListOfProjects", projectList);
		return "ManageProject";
	}

	@RequestMapping(value = "/user/SaveProject")
	public String userSaveProject(Model model,
			@RequestParam("projectName") String name,
			@RequestParam("projectDescription") String description,
			@RequestParam("projectDuration") long duration,
			@RequestParam("projectInstitute") long institute,
			@RequestParam("projectStatus") String status) {
		Project project = new Project();

		project.setProjectName(name);
		project.setProjectDescription(description);
		project.setProjectDuration(duration);
		project.setProjectStatus(status);
		Institute institute2 = new Institute();
		institute2.setInstituteId(institute);
		project.setInstitute(institute2);
		try {
			Date date = new Date();
			DateTimeUtil util = new DateTimeUtil();
			project.setProjectDate(util.converToSQLDate(date));
			project.setProjectTime(util.converToSQLTime(date));
			project.setPending(1);
			project.setBlock(0);
			Authentication auth = SecurityContextHolder.getContext()
					.getAuthentication();
			String username = auth.getName();
			Users users = new Users();
			users.setUsername(username);
			project.setUsers(users);

			userService.addProject(project);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/user/ManageProject.bnu";
	}

	@RequestMapping(value = "/user/AddProjectDomain")
	public String userProjectDomain(Model model) {
		List<Project> projectList = new ArrayList<>();
		List<Domain> domainList = new ArrayList<>();
		try {
			// instituteList = userService.getAllInstitutes();
			Authentication auth = SecurityContextHolder.getContext()
					.getAuthentication();
			String username = auth.getName();
			projectList = userService.getAllUserProjects(username);
			domainList = userService.getAllDomains();
		} catch (Exception e) {
			e.printStackTrace();

		}

		model.addAttribute("ListOfProjects", projectList);
		model.addAttribute("ListOfDomains", domainList);
		return "user-domain";
	}

	@RequestMapping(value = "/user/SaveProjectDomain")
	public String userSaveProjectDomain(Model model,
			@RequestParam("projectId") Long id,
			@RequestParam("domainId") Integer name) {
		ProjectDomain projectDomain = new ProjectDomain();
		Domain domain = new Domain();
		Project project = new Project();
		domain.setDomainId(name);
		project.setProjectId(id);
		projectDomain.setDomain(domain);
		projectDomain.setProject(project);
		try {
			userService.addProjectDomain(projectDomain);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/user/AddProjectDomain.bnu";

	}

	@RequestMapping(value = "/user/AddProjectKeywords")
	public String userProjectKeywords(Model model) {
		List<Project> projectList = new ArrayList<>();
		List<Keywords> keywordsList = new ArrayList<>();
		try {
			// instituteList = userService.getAllInstitutes();
			Authentication auth = SecurityContextHolder.getContext()
					.getAuthentication();
			String username = auth.getName();
			projectList = userService.getAllUserProjects(username);
			keywordsList = userService.getAllKeywords();
		} catch (Exception e) {
			e.printStackTrace();

		}
		// model.addAttribute("ListOfInstitutes", instituteList);
		model.addAttribute("ListOfProjects", projectList);
		model.addAttribute("ListOfKeywords", keywordsList);
		return "user-keywords";
	}

	@RequestMapping(value = "/user/SaveProjectKeywords")
	public String userSaveProjectKeywords(Model model,
			@RequestParam("projectId") Long id,
			@RequestParam("keywordId") Integer name) {
		ProjectKeywords projectKeywordd = new ProjectKeywords();
		Keywords keywords = new Keywords();
		Project project = new Project();
		keywords.setKeywordsId(name);
		project.setProjectId(id);
		projectKeywordd.setKeywords(keywords);
		projectKeywordd.setProject(project);
		try {
			userService.addprojectKeywords(projectKeywordd);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/user/AddProjectKeywords.bnu";

	}

	@RequestMapping(value = "/user/ListOfProjects")
	public String userListOfProjects(Model model) {
		List<Project> projectList = new ArrayList<>();
		// List<ProjectDomain> projectDomains = new ArrayList<>();
		// List<ProjectKeywords> projectKeywords = new ArrayList<>();
		// List<Keywords> keywordsList = new ArrayList<>();
		try {
			// instituteList = userService.getAllInstitutes();
			Authentication auth = SecurityContextHolder.getContext()
					.getAuthentication();
			String username = auth.getName();
			projectList = userService.getAllUserProjects(username);
			// projectDomains = userService.getAllProjectDomains();
			// projectKeywords = userService.getAllProjectKeywords();
			// keywordsList = userService.getAllKeywords();
		} catch (Exception e) {
			e.printStackTrace();

		}
		// model.addAttribute("ListOfInstitutes", instituteList);
		model.addAttribute("ListOfProjects", projectList);
		// model.addAttribute("ListOfProjectsDomain", projectDomains);
		// model.addAttribute("ListOfProjectsKeyword", projectKeywords);
		// model.addAttribute("ListOfKeywords", keywordsList);
		return "user-ListOfProjects";
	}

	@RequestMapping(value = "/user/ListOfDomain")
	public String userListOfDomain(Model model, @RequestParam("id") Long id) {
		List<ProjectDomain> projectDomains = new ArrayList<>();
		// List<Keywords> keywordsList = new ArrayList<>();
		try {
			// instituteList = userService.getAllInstitutes();
			projectDomains = userService.getAllProjectDomains(id);
			// keywordsList = userService.getAllKeywords();
			for (ProjectDomain projectDomain : projectDomains) {
				System.out.println(projectDomain.getDomain().getDomainName());
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		// model.addAttribute("ListOfInstitutes", instituteList);
		model.addAttribute("ListOfProjectsDomain", projectDomains);
		// model.addAttribute("ListOfKeywords", keywordsList);
		return "user-ProjectDomain";
	}

	@RequestMapping(value = "/user/ListOfKeywords")
	public String userListOfKeywords(Model model, @RequestParam("id") Long id) {
		List<ProjectKeywords> projectKewords = new ArrayList<>();
		// List<Keywords> keywordsList = new ArrayList<>();
		try {
			// instituteList = userService.getAllInstitutes();
			projectKewords = userService.getAllProjectKeywords(id);
			// keywordsList = userService.getAllKeywords();
			for (ProjectKeywords projectKeywords2 : projectKewords) {
				System.out.println(projectKeywords2.getKeywords()
						.getKeywordName());
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		// model.addAttribute("ListOfInstitutes", instituteList);
		model.addAttribute("ListOfProjectsKeywords", projectKewords);
		// model.addAttribute("ListOfKeywords", keywordsList);
		return "user-ProjectKeywords";
	}

	@RequestMapping(value = "/user/CompletedProjects")
	public String userCompletedProjects(Model model) {
		List<Project> project = new ArrayList<>();
		// List<Keywords> keywordsList = new ArrayList<>();
		try {
			Authentication auth = SecurityContextHolder.getContext()
					.getAuthentication();
			String username = auth.getName();
			// instituteList = userService.getAllInstitutes();
			project = userService.getAllCompletedProject(username);
			// keywordsList = userService.getAllKeywords();
			for (Project project2 : project) {
				System.out.println(project2.getProjectName());
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		// model.addAttribute("ListOfInstitutes", instituteList);
		model.addAttribute("ListOfProjects", project);
		// model.addAttribute("ListOfKeywords", keywordsList);
		return "user-CompletedProjects";
	}

	@RequestMapping(value = "/user/ProjectStatus")
	public String userProjectStatus(Model model) {
		List<Project> project = new ArrayList<>();
		// List<Keywords> keywordsList = new ArrayList<>();
		try {
			Authentication auth = SecurityContextHolder.getContext()
					.getAuthentication();
			String username = auth.getName();
			// instituteList = userService.getAllInstitutes();
			project = userService.getAllCompletedProject(username);
			// keywordsList = userService.getAllKeywords();
			for (Project project2 : project) {
				System.out.println(project2.getProjectName());
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		// model.addAttribute("ListOfInstitutes", instituteList);
		model.addAttribute("ListOfProjects", project);
		// model.addAttribute("ListOfKeywords", keywordsList);
		return "user-ProjectStatus";
	}

	@RequestMapping(value = "/user/BlockedProject")
	public String userBlockedProjects(Model model) {
		List<Project> project = new ArrayList<>();
		// List<Keywords> keywordsList = new ArrayList<>();
		try {
			Authentication auth = SecurityContextHolder.getContext()
					.getAuthentication();
			String username = auth.getName();
			// instituteList = userService.getAllInstitutes();
			project = userService.getAllBlockedProject(username);
			// keywordsList = userService.getAllKeywords();
			for (Project project2 : project) {
				System.out.println(project2.getProjectName());
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		// model.addAttribute("ListOfInstitutes", instituteList);
		model.addAttribute("ListOfProjects", project);
		// model.addAttribute("ListOfKeywords", keywordsList);
		return "user-BlockedProjects";
	}

	// ------------------------------------------------------
	// Man age Team members and manage supervisor

	@RequestMapping(value = "/user/TeamMember")
	public String userTeamMember(Model model) {
		List<Project> projectList = new ArrayList<>();
		List<Users> userList = new ArrayList<>();
		try {
			Authentication auth = SecurityContextHolder.getContext()
					.getAuthentication();
			String username = auth.getName();
			projectList = userService.getAllUserProjects(username);
			userList = userService.getAllUserss(username);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("projectList", projectList);
		model.addAttribute("usersList", userList);

		return "user-TeamMember";
	}

	@RequestMapping(value = "/user/SaveTeamMember")
	public String IniAdminSaveInstitute(Model model,
			@RequestParam("username") String name,
			@RequestParam("projectId") Long projectId,
			@RequestParam("roleId") Integer roleId) {
		String url = "";
		ProjectRole projectRole = new ProjectRole();
		Role role = new Role();
		role.setRoleId(roleId);
		Project project = new Project();
		project.setProjectId(projectId);
		Users users = new Users();
		users.setUsername(name);
		projectRole.setProject(project);
		projectRole.setUsers(users);
		projectRole.setRole(role);
		projectRole.setBlock(0);
		// List<ProjectRole> projectList = new ArrayList<>();
		try {

			userService.addProjectRole(projectRole);

			url = "redirect:/user/TeamMember.bnu";
			// logger.info("Going to Load Login Form");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return url;
	}

	@RequestMapping(value = "/user/BlockedTeamMember")
	public String IniAdminBlockedInstitute(Model model) {
		List<ProjectRole> blockedTeamMemebers = new ArrayList<>();
		List<Project> projects = new ArrayList<>();
		List<ProjectRole> list = new ArrayList<>();
		try {
			Authentication auth = SecurityContextHolder.getContext()
					.getAuthentication();
			String username = auth.getName();
			projects = userService.getAllUserProjects(username);
			Integer id = 1;
			for (Project project : projects) {
				List<ProjectRole> projectRole = new ArrayList<>();

				projectRole = userService.getBlockedTeamMembers(
						project.getProjectId(), id);
				for (ProjectRole projectRole2 : projectRole) {
					list.add(projectRole2);
				}

			}
			for (ProjectRole projectRole : list) {
				System.out.println(projectRole.getUsers().getUsername());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("blockedList", list);

		// logger.info("Going to Load Login Form");
		return "user-BlockedTeamMember";
	}

	@RequestMapping(value = "/user/ListOfTeamMember")
	public String userListOfUser(Model model) {
		// List<ProjectRole> blockedTeamMemebers = new ArrayList<>();
		List<Project> projects = new ArrayList<>();
		List<ProjectRole> list = new ArrayList<>();
		try {
			Authentication auth = SecurityContextHolder.getContext()
					.getAuthentication();
			String username = auth.getName();
			projects = userService.getAllUserProjects(username);

			for (Project project : projects) {
				List<ProjectRole> projectRole = new ArrayList<>();
				Integer roleId = 1;
				projectRole = userService.getAllTeamMembers(
						project.getProjectId(), roleId);
				for (ProjectRole projectRole2 : projectRole) {
					list.add(projectRole2);
				}

			}
			for (ProjectRole projectRole : list) {
				System.out.println(projectRole.getUsers().getUsername());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("TeamMemberList", list);
		return "user-ListOfTeamMember";
	}

	@RequestMapping(value = "/user/SuperVisor")
	public String userSuperVisor(Model model) {
		List<Project> projectList = new ArrayList<>();
		List<Users> userList = new ArrayList<>();
		try {
			Authentication auth = SecurityContextHolder.getContext()
					.getAuthentication();
			String username = auth.getName();
			projectList = userService.getAllUserProjects(username);
			userList = userService.getAllUserss(username);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("projectList", projectList);
		model.addAttribute("usersList", userList);

		return "user-SuperVisor";
	}

	@RequestMapping(value = "/user/BlockedSuperVisor")
	public String userBlockedSupervisor(Model model) {
		List<ProjectRole> blockedTeamMemebers = new ArrayList<>();
		List<Project> projects = new ArrayList<>();
		List<ProjectRole> list = new ArrayList<>();
		try {
			Authentication auth = SecurityContextHolder.getContext()
					.getAuthentication();
			String username = auth.getName();
			projects = userService.getAllUserProjects(username);
			Integer id = 2;
			for (Project project : projects) {
				List<ProjectRole> projectRole = new ArrayList<>();

				projectRole = userService.getBlockedTeamMembers(
						project.getProjectId(), id);
				for (ProjectRole projectRole2 : projectRole) {
					list.add(projectRole2);
				}

			}
			for (ProjectRole projectRole : list) {
				System.out.println(projectRole.getUsers().getUsername());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("blockedList", list);

		// logger.info("Going to Load Login Form");
		return "user-BlockedTeamMember";
	}

	@RequestMapping(value = "/user/ListOfSuperVisor")
	public String userListOfSupervisor(Model model) {
		// List<ProjectRole> blockedTeamMemebers = new ArrayList<>();
		List<Project> projects = new ArrayList<>();
		List<ProjectRole> list = new ArrayList<>();
		try {
			Authentication auth = SecurityContextHolder.getContext()
					.getAuthentication();
			String username = auth.getName();
			projects = userService.getAllUserProjects(username);

			for (Project project : projects) {
				List<ProjectRole> projectRole = new ArrayList<>();
				Integer roleId = 2;
				projectRole = userService.getAllTeamMembers(
						project.getProjectId(), roleId);
				for (ProjectRole projectRole2 : projectRole) {
					list.add(projectRole2);
				}

			}
			for (ProjectRole projectRole : list) {
				System.out.println(projectRole.getUsers().getUsername());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("TeamMemberList", list);
		return "user-ListOfTeamMember";
	}

	@RequestMapping(value = "/user/updateTeammemberStatus", method = RequestMethod.GET)
	public String IniAdminUpdateInstituteStatus(Model model,
			@RequestParam(required = false) Long id, Integer roleid,
			Long projectId, String username, int block, int check) {
		String url = "";
		ProjectRole role = new ProjectRole();
		role.setBlock(block);
		Project project = new Project();
		Role role2 = new Role();
		Users users = new Users();
		users.setUsername(username);
		role2.setRoleId(roleid);
		project.setProjectId(projectId);
		role.setProjectRoleId(id);
		role.setUsers(users);
		role.setRole(role2);
		role.setProject(project);
		try {
			userService.updateTeamMemberStatus(role);
			if (check == 1 && block == 0) {
				url = "redirect:/user/BlockedTeamMember.bnu";
			}
			if (check == 1 && block == 1) {
				url = "redirect:/user/ListOfTeamMember.bnu";
			}
			if (check == 2 && block == 0) {
				url = "redirect:/user/BlockedSuperVisor.bnu";
			}
			if (check == 2 && block == 1) {
				url = "redirect:/user/ListOfSuperVisor.bnu";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// logger.info("Going to Load Login Form");
		return url;
	}

	@RequestMapping(value = "/user/updateProjectStatus", method = RequestMethod.GET)
	public String userUpdateProjectStatus(Model model,
			@RequestParam(required = false) Long id, String status, int block,
			int check, String projectName, Integer projectDuration, Date date,
			Date time, int pending, String projectDescription, Long instituteId) {
		String url = "";
		try {
			Project project = new Project();
			Institute institute = new Institute();
			institute.setInstituteId(instituteId);
			project.setProjectId(id);
			project.setProjectStatus(status);
			project.setBlock(block);
			project.setProjectName(projectName);
			project.setProjectDuration(projectDuration);
			DateTimeUtil util = new DateTimeUtil();
			project.setProjectDate(util.converToSQLDate(date));
			project.setProjectTime(util.converToSQLTime(time));
			project.setPending(pending);
			project.setProjectDescription(projectDescription);
			project.setInstitute(institute);
			userService.updateProjectStatus(project);
			if (check == 1) {
				url = "redirect:/user/ManageProject.bnu";
			}

			if (check == 2) {
				url = "redirect:/user/BlockedProject.bnu";
			}
			if (check == 3) {
				url = "redirect:/user/ProjectStatus.bnu";
			}
			if (check == 4) {
				url = "redirect:/user/ListOfProjects.bnu";
			}
			if (check == 5) {
				url = "redirect:/user/CompletedProjects.bnu";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		// logger.info("Going to Load Login Form");
		return url;
	}
}
