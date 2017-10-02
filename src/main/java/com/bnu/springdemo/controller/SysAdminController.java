package com.bnu.springdemo.controller;

import java.util.ArrayList;
import java.util.List;

import javassist.compiler.ast.Keyword;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bnu.springdemo.entity.Domain;
import com.bnu.springdemo.entity.Institute;
import com.bnu.springdemo.entity.Keywords;
import com.bnu.springdemo.entity.ToolsAndTechnology;
import com.bnu.springdemo.entity.Users;
import com.bnu.springdemo.service.userService;

@Controller
public class SysAdminController {
	@Autowired
	private userService userService;

	// <-------------------------------------------------------->
	@RequestMapping(value = "/sysadmin/Users")
	public String SysAdminUsers(Model model) {
		List<Users> pendingUsers = new ArrayList<>();
		List<Users> blockedUsers = new ArrayList<>();
		try {
			byte enabled = 0;
			byte block = 1;
			blockedUsers = userService.getblockedUsers(block);
			pendingUsers = userService.getpendingUsers(enabled);

			for (Users users : blockedUsers) {
				System.out.println(users.getFirstName());
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error");
		}
		model.addAttribute("pendingList", pendingUsers);
		model.addAttribute("blockedList", blockedUsers);

		// logger.info("Going to Load Login Form");
		return "sysadmin-Users";
	}

	@RequestMapping(value = "/sysadmin/BlockedUsers")
	public String SysAdminBlockedUsers(Model model) {
		List<Users> blockedUsers = new ArrayList<>();
		try {
			byte block = 1;
			blockedUsers = userService.getblockedUsers(block);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("blockedList", blockedUsers);

		// logger.info("Going to Load Login Form");
		return "sysadmin-BlockedUsers";
	}

	@RequestMapping(value = "/sysadmin/ListOfUsers")
	public String SysAdminListOfUsers(Model model) {
		List<Users> listOfUsers = new ArrayList<>();
		try {
			listOfUsers = userService.getAllUsers();
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("ListOfUsers", listOfUsers);
		// logger.info("Going to Load Login Form");
		return "sysadmin-ListOfUsers";
	}

	@RequestMapping(value = "/sysadmin/updateUsersStatus", method = RequestMethod.GET)
	public String SysAdminUpdateUsersStatus(Model model,
			@RequestParam(required = false) String username, byte block,
			byte enabled, int check) {
		String url = "";
		Users users = new Users();
		List<Users> userList = new ArrayList<>();
		// System.out.println(username);
		try {
			userList = userService.getUsersByName(username);
			for (Users users2 : userList) {
				// System.out.println(users2.getFirstName());
				// System.out.println("usersname" + users2.getUsername());
				users.setUserContactNo(users2.getUserContactNo());
				users.setUserEmailId(users2.getUserEmailId());
				users.setPassword(users2.getPassword());
				users.setFirstName(users2.getFirstName());
				users.setLastName(users2.getLastName());
			}
			users.setUsername(username);
			users.setBlock(block);
			// System.out.println("block:" + block);

			users.setEnabled(enabled);
			// System.out.println("enabled:" + enabled);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			userService.updateUserStatus(users);
			if (check == 1) {
				url = "redirect:/sysadmin/BlockedUsers.bnu";
			}
			if (check == 2) {
				url = "redirect:/sysadmin/Users.bnu";
			}
			if (check == 3) {
				url = "redirect:/sysadmin/ListOfUsers.bnu";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// logger.info("Going to Load Login Form");
		return url;
	}

	// <-------------------------------------------------------->
	@RequestMapping(value = "/sysadmin/Institute")
	public String SysAdminInstitues(Model model) {
		List<Institute> pendingInstitute = new ArrayList<>();
		List<Institute> blockedInstitute = new ArrayList<>();
		try {
			byte enabled = 0;
			byte block = 1;
			blockedInstitute = userService.getblockedInstitute(block);
			pendingInstitute = userService.getpendingInstitute(enabled);

			for (Institute users : blockedInstitute) {
				System.out.println(users.getInstituteName());
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error");
		}
		model.addAttribute("pendingList", pendingInstitute);
		model.addAttribute("blockedList", blockedInstitute);

		// logger.info("Going to Load Login Form");
		return "sysadmin-Institute";
	}

	@RequestMapping(value = "/sysadmin/BlockedInstitute")
	public String SysAdminBlockedInstitute(Model model) {
		List<Institute> blockedInstitute = new ArrayList<>();
		try {
			byte block = 1;
			blockedInstitute = userService.getblockedInstitute(block);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("blockedList", blockedInstitute);

		// logger.info("Going to Load Login Form");
		return "sysadmin-BlockedInstitute";
	}

	@RequestMapping(value = "/sysadmin/ListOfInstitute")
	public String SysAdminListOfInstitute(Model model) {
		List<Institute> listOfInstitute = new ArrayList<>();
		try {
			listOfInstitute = userService.getAllInstitute();
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("ListOfInstitute", listOfInstitute);
		// logger.info("Going to Load Login Form");
		return "sysadmin-ListOfInstitute";
	}

	@RequestMapping(value = "/sysadmin/updateInstituteStatus", method = RequestMethod.GET)
	public String SysAdminUpdateInstituteStatus(Model model,
			@RequestParam(required = false) Long id, String name, byte block,
			byte enabled, int check) {
		String url = "";
		Institute institute = new Institute();
		List<Institute> instituteList = new ArrayList<>();
		// System.out.println(username);
		// System.out.println("block:" + block);
		institute.setInstituteId(id);
		institute.setInstituteName(name);
		institute.setPending(enabled);
		institute.setBlock(block);

		try {
			userService.updateInstituteStatus(institute);
			if (check == 1) {
				url = "redirect:/sysadmin/BlockedInstitute.bnu";
			}
			if (check == 2) {
				url = "redirect:/sysadmin/Institute.bnu";
			}
			if (check == 3) {
				url = "redirect:/sysadmin/ListOfInstitute.bnu";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// logger.info("Going to Load Login Form");
		return url;
	}

	// <-------------------------------------------------------->
	@RequestMapping(value = "/sysadmin/Domains")
	public String SysAdminDomain(Model model) {
		List<Domain> listOfDomains = new ArrayList<>();

		try {
			byte block = 1;
			// blockedKeywords = userService.getblockedKeywords(block);
			listOfDomains = userService.getAllDomains();
			//
			// for (Keywords users : blockedKeywords) {
			// System.out.println(users.getKeywordName());
			// }

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error");
		}

		model.addAttribute("ListOfDomain", listOfDomains);
		// model.addAttribute("blockedList", blockedKeywords);

		// logger.info("Going to Load Login Form");
		return "sysadmin-Domain";
	}

	@RequestMapping(value = "/sysadmin/SaveDomains")
	public String SysAdminSaveDomain(Model model,
			@RequestParam("name") String name) {
		String url = "";
		Domain domain = new Domain();
		try {
			domain.setDomainName(name);
			userService.addDomain(domain);
			url = "redirect:/sysadmin/Domains.bnu";
			// logger.info("Going to Load Login Form");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return url;
	}

	@RequestMapping(value = "/sysadmin/BlockedDomains")
	public String SysAdminBlockedDomains(Model model) {
		List<Domain> blockedDomain = new ArrayList<>();
		try {
			byte block = 1;
			blockedDomain = userService.getblockedDomain(block);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("blockedList", blockedDomain);

		// logger.info("Going to Load Login Form");
		return "sysadmin-BlockedDomain";
	}

	@RequestMapping(value = "/sysadmin/ListOfDomains")
	public String SysAdminListOfDomains(Model model) {
		List<Domain> listOfDomain = new ArrayList<>();
		try {
			listOfDomain = userService.getAllDomains();
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("ListOfDomain", listOfDomain);
		// logger.info("Going to Load Login Form");
		return "sysadmin-ListOfDomain";
	}

	@RequestMapping(value = "/sysadmin/updateDomainStatus", method = RequestMethod.GET)
	public String SysAdminUpdateDomainStatus(Model model,
			@RequestParam(required = false) Integer id, String name,
			byte block, int check) {
		String url = "";
		Domain domain = new Domain();
		domain.setDomainId(id);
		domain.setDomainName(name);
		domain.setBlock(block);

		try {
			userService.updateDomainStatus(domain);
			if (check == 1) {
				url = "redirect:/sysadmin/Domains.bnu";
			}
			if (check == 2) {
				url = "redirect:/sysadmin/BlockedDomains.bnu";
			}
			if (check == 3) {
				url = "redirect:/sysadmin/ListOfDomains.bnu";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// logger.info("Going to Load Login Form");
		return url;
	}

	// <-------------------------------------------------------->
	@RequestMapping(value = "/sysadmin/Keywords")
	public String SysAdminKeywords(Model model) {
		List<Keywords> blockedKeywords = new ArrayList<>();
		List<Keywords> listOfKeywords = new ArrayList<>();

		try {
			byte block = 1;
			// blockedKeywords = userService.getblockedKeywords(block);
			listOfKeywords = userService.getAllKeywords();
			//
			// for (Keywords users : blockedKeywords) {
			// System.out.println(users.getKeywordName());
			// }

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error");
		}

		model.addAttribute("ListOfKeywords", listOfKeywords);
		// model.addAttribute("blockedList", blockedKeywords);

		// logger.info("Going to Load Login Form");
		return "sysadmin-Keywords";
	}

	@RequestMapping(value = "/sysadmin/SaveKeywords")
	public String SysAdminSaveKeywords(Model model,
			@RequestParam("name") String name) {
		String url = "";
		Keywords keywords = new Keywords();
		try {
			keywords.setKeywordName(name);
			userService.addKeywords(keywords);
			url = "redirect:/sysadmin/Keywords.bnu";
			// logger.info("Going to Load Login Form");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return url;
	}

	@RequestMapping(value = "/sysadmin/BlockedKeywords")
	public String SysAdminBlockedKeywords(Model model) {
		List<Keywords> blockedKeywords = new ArrayList<>();
		try {
			byte block = 1;
			blockedKeywords = userService.getblockedKeywords(block);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("blockedList", blockedKeywords);

		// logger.info("Going to Load Login Form");
		return "sysadmin-BlockedKeywords";
	}

	@RequestMapping(value = "/sysadmin/ListOfKeywords")
	public String SysAdminListOfKeywords(Model model) {
		List<Keywords> listOfKeywords = new ArrayList<>();
		try {
			listOfKeywords = userService.getAllKeywords();
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("ListOfKeywords", listOfKeywords);
		// logger.info("Going to Load Login Form");
		return "sysadmin-ListOfKeywords";
	}

	@RequestMapping(value = "/sysadmin/updateKeywordStatus", method = RequestMethod.GET)
	public String SysAdminUpdatekeywordStatus(Model model,
			@RequestParam(required = false) Integer id, String name,
			byte block, int check) {
		String url = "";
		Keywords keywords = new Keywords();
		keywords.setKeywordsId(id);
		keywords.setKeywordName(name);
		keywords.setBlock(block);
		try {
			userService.updateKeywordStatus(keywords);
			if (check == 1) {
				url = "redirect:/sysadmin/Keywords.bnu";
			}
			if (check == 2) {
				url = "redirect:/sysadmin/BlockedKeywords.bnu";
			}
			if (check == 3) {
				url = "redirect:/sysadmin/ListOfKeywords.bnu";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// logger.info("Going to Load Login Form");
		return url;
	}

	// <-------------------------------------------------------->
	@RequestMapping(value = "/sysadmin/Technology")
	public String SysAdminTechnology(Model model) {
		List<ToolsAndTechnology> blockedTechnology = new ArrayList<>();
		List<ToolsAndTechnology> listOfTechnology = new ArrayList<>();

		try {
			byte block = 1;
			// blockedKeywords = userService.getblockedKeywords(block);
			listOfTechnology = userService.getAllTechnology();
			//
			// for (Keywords users : blockedKeywords) {
			// System.out.println(users.getKeywordName());
			// }

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error");
		}

		model.addAttribute("ListOfTechnology", listOfTechnology);
		// model.addAttribute("blockedList", blockedKeywords);

		// logger.info("Going to Load Login Form");
		return "sysadmin-Technology";
	}

	@RequestMapping(value = "/sysadmin/SaveTechnology")
	public String SysAdminSaveTechnology(Model model,
			@RequestParam("name") String name) {
		String url = "";
		ToolsAndTechnology technology = new ToolsAndTechnology();
		try {
			technology.setToolsAndTechnologyName(name);
			userService.addTechnology(technology);
			url = "redirect:/sysadmin/Technology.bnu";
			// logger.info("Going to Load Login Form");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return url;
	}

	@RequestMapping(value = "/sysadmin/BlockedTechnology")
	public String SysAdminBlockedTechnolgy(Model model) {
		List<ToolsAndTechnology> blockedTechnology = new ArrayList<>();
		try {
			byte block = 1;
			blockedTechnology = userService.getblockedTechnology(block);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("blockedList", blockedTechnology);

		// logger.info("Going to Load Login Form");
		return "sysadmin-BlockedTechnology";
	}

	@RequestMapping(value = "/sysadmin/ListOfTechnology")
	public String SysAdminListOfTechnology(Model model) {
		List<ToolsAndTechnology> listOfTechnology = new ArrayList<>();
		try {
			listOfTechnology = userService.getAllTechnology();
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("ListOfTechnology", listOfTechnology);
		// logger.info("Going to Load Login Form");
		return "sysadmin-ListOfTechnology";
	}

	@RequestMapping(value = "/sysadmin/updateTechnologyStatus", method = RequestMethod.GET)
	public String SysAdminUpdateTechnologyStatus(Model model,
			@RequestParam(required = false) Long id, String name, byte block,
			int check) {
		String url = "";
		ToolsAndTechnology technology = new ToolsAndTechnology();
		technology.setToolsAndTechnologyId(id);
		technology.setToolsAndTechnologyName(name);
		technology.setBlock(block);

		try {
			userService.updateTechnologyStatus(technology);
			if (check == 1) {
				url = "redirect:/sysadmin/Technology.bnu";
			}
			if (check == 2) {
				url = "redirect:/sysadmin/BlockedTechnology.bnu";
			}
			if (check == 3) {
				url = "redirect:/sysadmin/ListOfTechnology.bnu";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// logger.info("Going to Load Login Form");
		return url;
	}
	// <-------------------------------------------------------->

}
