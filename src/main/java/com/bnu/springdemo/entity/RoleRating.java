package com.bnu.springdemo.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * RoleRating generated by hbm2java
 */
@Entity
@Table(name = "role_rating", catalog = "projectinformationsharingsystem")
public class RoleRating implements java.io.Serializable {

	private Integer roleRatingId;
	private ProjectRole projectRoleByProjectRoleRateeId;
	private ProjectRole projectRoleByProjectRoleRatererId;

	public RoleRating() {
	}

	public RoleRating(ProjectRole projectRoleByProjectRoleRateeId,
			ProjectRole projectRoleByProjectRoleRatererId) {
		this.projectRoleByProjectRoleRateeId = projectRoleByProjectRoleRateeId;
		this.projectRoleByProjectRoleRatererId = projectRoleByProjectRoleRatererId;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "role_rating_id", unique = true, nullable = false)
	public Integer getRoleRatingId() {
		return this.roleRatingId;
	}

	public void setRoleRatingId(Integer roleRatingId) {
		this.roleRatingId = roleRatingId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "project_role_ratee_id", nullable = false)
	public ProjectRole getProjectRoleByProjectRoleRateeId() {
		return this.projectRoleByProjectRoleRateeId;
	}

	public void setProjectRoleByProjectRoleRateeId(
			ProjectRole projectRoleByProjectRoleRateeId) {
		this.projectRoleByProjectRoleRateeId = projectRoleByProjectRoleRateeId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "project_role_raterer_id", nullable = false)
	public ProjectRole getProjectRoleByProjectRoleRatererId() {
		return this.projectRoleByProjectRoleRatererId;
	}

	public void setProjectRoleByProjectRoleRatererId(
			ProjectRole projectRoleByProjectRoleRatererId) {
		this.projectRoleByProjectRoleRatererId = projectRoleByProjectRoleRatererId;
	}

}
