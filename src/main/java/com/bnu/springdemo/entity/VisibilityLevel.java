package com.bnu.springdemo.entity;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * VisibilityLevel generated by hbm2java
 */
@Entity
@Table(name = "visibility_level", catalog = "projectinformationsharingsystem")
public class VisibilityLevel implements java.io.Serializable {

	private Long visibilityLevelId;
	private String visibilityLevelName;
	private Set<ProjectVisibility> projectVisibilities = new HashSet<ProjectVisibility>(
			0);

	public VisibilityLevel() {
	}

	public VisibilityLevel(String visibilityLevelName) {
		this.visibilityLevelName = visibilityLevelName;
	}

	public VisibilityLevel(String visibilityLevelName,
			Set<ProjectVisibility> projectVisibilities) {
		this.visibilityLevelName = visibilityLevelName;
		this.projectVisibilities = projectVisibilities;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "visibility_level_id", unique = true, nullable = false)
	public Long getVisibilityLevelId() {
		return this.visibilityLevelId;
	}

	public void setVisibilityLevelId(Long visibilityLevelId) {
		this.visibilityLevelId = visibilityLevelId;
	}

	@Column(name = "visibility_level_name", nullable = false, length = 11)
	public String getVisibilityLevelName() {
		return this.visibilityLevelName;
	}

	public void setVisibilityLevelName(String visibilityLevelName) {
		this.visibilityLevelName = visibilityLevelName;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "visibilityLevel")
	public Set<ProjectVisibility> getProjectVisibilities() {
		return this.projectVisibilities;
	}

	public void setProjectVisibilities(
			Set<ProjectVisibility> projectVisibilities) {
		this.projectVisibilities = projectVisibilities;
	}

}