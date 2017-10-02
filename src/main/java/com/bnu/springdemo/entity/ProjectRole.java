package com.bnu.springdemo.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * ProjectRole generated by hbm2java
 */
@Entity
@Table(name = "project_role", catalog = "projectinformationsharingsystem")
public class ProjectRole implements java.io.Serializable {

	private Long projectRoleId;
	private Role role;
	private Project project;
	private int block;
	private Users users;
	private Set<RoleRating> roleRatingsForProjectRoleRatererId = new HashSet<RoleRating>(
			0);
	private Set<RatingByRole> ratingByRoles = new HashSet<RatingByRole>(0);
	private Set<RoleRating> roleRatingsForProjectRoleRateeId = new HashSet<RoleRating>(
			0);

	public ProjectRole() {
	}

	public ProjectRole(Role role, Project project, int block, Users users) {
		this.role = role;
		this.project = project;
		this.block = block;
		this.users = users;
	}

	public ProjectRole(Role role, Project project, int block, Users users,
			Set<RoleRating> roleRatingsForProjectRoleRatererId,
			Set<RatingByRole> ratingByRoles,
			Set<RoleRating> roleRatingsForProjectRoleRateeId) {
		this.role = role;
		this.project = project;
		this.block = block;
		this.users = users;
		this.roleRatingsForProjectRoleRatererId = roleRatingsForProjectRoleRatererId;
		this.ratingByRoles = ratingByRoles;
		this.roleRatingsForProjectRoleRateeId = roleRatingsForProjectRoleRateeId;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "project_role_id", unique = true, nullable = false)
	public Long getProjectRoleId() {
		return this.projectRoleId;
	}

	public void setProjectRoleId(Long projectRoleId) {
		this.projectRoleId = projectRoleId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "role_id", nullable = false)
	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "username", nullable = false)
	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "project_id", nullable = false)
	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	@Column(name = "block", nullable = false)
	public int getBlock() {
		return this.block;
	}

	public void setBlock(int block) {
		this.block = block;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "projectRoleByProjectRoleRatererId")
	public Set<RoleRating> getRoleRatingsForProjectRoleRatererId() {
		return this.roleRatingsForProjectRoleRatererId;
	}

	public void setRoleRatingsForProjectRoleRatererId(
			Set<RoleRating> roleRatingsForProjectRoleRatererId) {
		this.roleRatingsForProjectRoleRatererId = roleRatingsForProjectRoleRatererId;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "projectRole")
	public Set<RatingByRole> getRatingByRoles() {
		return this.ratingByRoles;
	}

	public void setRatingByRoles(Set<RatingByRole> ratingByRoles) {
		this.ratingByRoles = ratingByRoles;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "projectRoleByProjectRoleRateeId")
	public Set<RoleRating> getRoleRatingsForProjectRoleRateeId() {
		return this.roleRatingsForProjectRoleRateeId;
	}

	public void setRoleRatingsForProjectRoleRateeId(
			Set<RoleRating> roleRatingsForProjectRoleRateeId) {
		this.roleRatingsForProjectRoleRateeId = roleRatingsForProjectRoleRateeId;
	}

}
