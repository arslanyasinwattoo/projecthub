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
 * Projectrefernces generated by hbm2java
 */
@Entity
@Table(name = "projectrefernces", catalog = "projectinformationsharingsystem")
public class Projectrefernces implements java.io.Serializable {

	private Integer projectreferncesId;
	private Project projectByProjectRafreeId;
	private Project projectByProjectRafererId;

	public Projectrefernces() {
	}

	public Projectrefernces(Project projectByProjectRafreeId,
			Project projectByProjectRafererId) {
		this.projectByProjectRafreeId = projectByProjectRafreeId;
		this.projectByProjectRafererId = projectByProjectRafererId;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "projectrefernces_id", unique = true, nullable = false)
	public Integer getProjectreferncesId() {
		return this.projectreferncesId;
	}

	public void setProjectreferncesId(Integer projectreferncesId) {
		this.projectreferncesId = projectreferncesId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "project_rafree_id", nullable = false)
	public Project getProjectByProjectRafreeId() {
		return this.projectByProjectRafreeId;
	}

	public void setProjectByProjectRafreeId(Project projectByProjectRafreeId) {
		this.projectByProjectRafreeId = projectByProjectRafreeId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "project_raferer_id", nullable = false)
	public Project getProjectByProjectRafererId() {
		return this.projectByProjectRafererId;
	}

	public void setProjectByProjectRafererId(Project projectByProjectRafererId) {
		this.projectByProjectRafererId = projectByProjectRafererId;
	}

}