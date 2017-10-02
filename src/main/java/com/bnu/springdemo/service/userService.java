package com.bnu.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bnu.springdemo.dao.GenericDAO;
import com.bnu.springdemo.entity.Authorities;
import com.bnu.springdemo.entity.Domain;
import com.bnu.springdemo.entity.Institute;
import com.bnu.springdemo.entity.InstituteAdmin;
import com.bnu.springdemo.entity.Keywords;
import com.bnu.springdemo.entity.Project;
import com.bnu.springdemo.entity.ProjectDomain;
import com.bnu.springdemo.entity.ProjectKeywords;
import com.bnu.springdemo.entity.ProjectRole;
import com.bnu.springdemo.entity.ToolsAndTechnology;
import com.bnu.springdemo.entity.Users;

@Service
public class userService {
	@Autowired
	private GenericDAO genericDAO;

	// <-------------------------------------------------------------------------->
	public void addUsers(Users users) throws Exception {
		genericDAO.insertOrUpdate(users);
	}

	public void addauthority(Authorities authorities) throws Exception {
		genericDAO.insertOrUpdate(authorities);
	}

	// <-------------------------------------------------------------------------->
	public List<Users> getpendingUsers(byte enabled) throws Exception {
		Users users = new Users();
		users.setEnabled(enabled);

		return genericDAO.findByExample(users);
	}

	public List<Users> getblockedUsers(byte block) throws Exception {
		Users users = new Users();
		byte enabled = 1;
		users.setEnabled(enabled);
		users.setBlock(block);
		return genericDAO.findByExample(users);
	}

	public List<Users> getAllUsers() throws Exception {

		return genericDAO.findAll(Users.class);
	}

	@Transactional
	public List<Users> getUsersByName(String username) throws Exception {

		return genericDAO.findByNamedQuery("getUser", username);
	}

	public void updateUserStatus(Users users) throws Exception {
		genericDAO.insertOrUpdate(users);
	}

	// <-------------------------------------------------------------------------->
	public List<Institute> getblockedInstitute(byte block) throws Exception {

		Institute institute = new Institute();
		institute.setBlock(block);
		institute.setPending(1);
		return genericDAO.findByExample(institute);
	}

	public List<Institute> getpendingInstitute(byte enabled) throws Exception {
		Institute institute = new Institute();
		institute.setBlock(0);
		institute.setPending(enabled);

		return genericDAO.findByExample(institute);
	}

	public List<Institute> getAllInstitute() throws Exception {
		// TODO Auto-generated method stub
		return genericDAO.findAll(Institute.class);
	}

	public List<Institute> getAllInstitutes() throws Exception {
		Institute institute = new Institute();
		institute.setPending(1);
		institute.setBlock(0);
		return genericDAO.findByExample(institute);
	}

	public void updateInstituteStatus(Institute institute) throws Exception {
		genericDAO.insertOrUpdate(institute);

	}

	// <-------------------------------------------------------------------------->
	public void updateKeywordStatus(Keywords keywords) throws Exception {
		genericDAO.insertOrUpdate(keywords);

	}

	public List<Keywords> getAllKeywords() throws Exception {
		// TODO Auto-generated method stub
		Keywords keywords = new Keywords();
		keywords.setBlock(0);
		return genericDAO.findByExample(keywords);
	}

	public List<Keywords> getblockedKeywords(byte block) throws Exception {
		Keywords keywords = new Keywords();
		keywords.setBlock(block);
		return genericDAO.findByExample(keywords);
	}

	public void addKeywords(Keywords keywords) throws Exception {
		genericDAO.insertOrUpdate(keywords);
	}

	// <-------------------------------------------------------------------------->
	public List<Domain> getAllDomains() throws Exception {
		Domain domain = new Domain();
		domain.setBlock(0);
		return genericDAO.findByExample(domain);
	}

	public void addDomain(Domain domain) throws Exception {
		genericDAO.insertOrUpdate(domain);
	}

	public List<Domain> getblockedDomain(byte block) throws Exception {
		Domain domain = new Domain();
		domain.setBlock(block);
		return genericDAO.findByExample(domain);
	}

	public void updateDomainStatus(Domain domain) throws Exception {
		genericDAO.insertOrUpdate(domain);

	}

	// <-------------------------------------------------------------------------->
	public void updateTechnologyStatus(ToolsAndTechnology technology)
			throws Exception {
		genericDAO.insertOrUpdate(technology);
	}

	public List<ToolsAndTechnology> getAllTechnology() throws Exception {

		ToolsAndTechnology technology = new ToolsAndTechnology();
		technology.setBlock(0);
		return genericDAO.findByExample(technology);
	}

	public void addTechnology(ToolsAndTechnology technology) throws Exception {
		// TODO Auto-generated method stub
		genericDAO.insertOrUpdate(technology);
	}

	public List<ToolsAndTechnology> getblockedTechnology(byte block)
			throws Exception {

		ToolsAndTechnology technology = new ToolsAndTechnology();
		technology.setBlock(1);
		return genericDAO.findByExample(technology);
	}

	// <-------------------------------------------------------------------------->

	public List<InstituteAdmin> getAllInstituteOfUser(String username)
			throws Exception {
		return genericDAO.findByNamedQuery("getInstituteAdmin", username);
	}

	public List<InstituteAdmin> getAllInstituteOfUserp(String username)
			throws Exception {
		return genericDAO.findByNamedQuery("getAllInstituteAdmin", username);
	}

	public List<InstituteAdmin> getpendingInstituteOfUser(String username) {
		// TODO Auto-generated method stub
		return genericDAO
				.findByNamedQuery("getPendingInstituteAdmin", username);
	}

	public List<InstituteAdmin> getBlockedInstituteOfUser(String username) {
		// TODO Auto-generated method stub
		return genericDAO
				.findByNamedQuery("getBlockedInstituteAdmin", username);
	}

	public void addInstitute(Institute admin) throws Exception {
		// TODO Auto-generated method stub
		genericDAO.insertOrUpdate(admin);
	}

	public void addInstituteAdmin(InstituteAdmin admin) throws Exception {
		// TODO Auto-generated method stub
		genericDAO.insertOrUpdate(admin);
	}

	// <--------------------------------------------------------------------------------------->

	public void addProject(Project project) throws Exception {
		// TODO Auto-generated method stub
		genericDAO.insertOrUpdate(project);
	}

	public List<Project> getAllUserProjects(String username) throws Exception {
		// TODO Auto-generated method stub
		Project project = new Project();
		project.setPending(1);
		project.setBlock(0);
		return genericDAO.findByNamedQuery("getAllProjects",
				project.getPending(), project.getBlock(), username);
	}

	public List<Project> getAllblockedProjects() throws Exception {
		// TODO Auto-generated method stub

		return genericDAO.findByNamedQuery("getAllBlockedProjects", 1);
	}

	public List<Project> getAllpendingProjects() throws Exception {
		// TODO Auto-generated method stub
		Project project = new Project();
		project.setPending(0);
		return genericDAO.findByNamedQuery("getAllPendingProjects", 0);
	}

	public void addProjectDomain(ProjectDomain projectDomain) throws Exception {
		// TODO Auto-generated method stub
		genericDAO.insertOrUpdate(projectDomain);
	}

	public void addprojectKeywords(ProjectKeywords projectKeywordd)
			throws Exception {
		// TODO Auto-generated method stub
		genericDAO.insertOrUpdate(projectKeywordd);
	}

	public List<ProjectDomain> getAllProjectDomains(Long id) throws Exception {
		// TODO Auto-generated method stub
		ProjectDomain domain = new ProjectDomain();
		Project project = new Project();
		domain.setProject(project);
		return genericDAO.findByExample(domain);
	}

	public List<ProjectKeywords> getAllProjectKeywords(Long id)
			throws Exception {

		ProjectKeywords keywords = new ProjectKeywords();
		Project project = new Project();
		keywords.setProject(project);
		return genericDAO.findByExample(keywords);
	}

	public List<Project> getAllCompletedProject(String username)
			throws Exception {
		// TODO Auto-generated method stub

		return genericDAO.findByNamedQuery("getAllCompletedProjects",
				"Completed", username);
	}

	public List<Project> getAllBlockedProject(String username) throws Exception {
		// TODO Auto-generated method stub
		return genericDAO
				.findByNamedQuery("getAllBlockedProjects", 1, username);
	}

	public List<Users> getAllUserss(String username) {
		// TODO Auto-generated method stub
		return genericDAO.findByNamedQuery("getAllusers", username);
	}

	public void addProjectRole(ProjectRole projectrole) throws Exception {
		// TODO Auto-generated method stub
		genericDAO.insertOrUpdate(projectrole);
	}

	public List<ProjectRole> getBlockedTeamMembers(Long projectId,
			Integer roleId) throws Exception {
		// TODO Auto-generated method stub
		return genericDAO.findByNamedQuery("getAllBlockedTeamMembers",
				projectId, 1, roleId);
	}

	public List<ProjectRole> getAllTeamMembers(Long projectId, Integer roleId)
			throws Exception {
		// TODO Auto-generated method stub
		return genericDAO.findByNamedQuery("getAllTeamMembers", projectId,
				roleId);
	}

	public void updateTeamMemberStatus(ProjectRole role) throws Exception {
		// TODO Auto-generated method stub
		genericDAO.insertOrUpdate(role);

	}

	public void updateProjectStatus(Project project) throws Exception {
		// TODO Auto-generated method stub
		genericDAO.insertOrUpdate(project);

	}
}
