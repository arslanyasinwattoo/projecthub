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
 * ProjectKeywords generated by hbm2java
 */
@Entity
@Table(name = "project_keywords", catalog = "projectinformationsharingsystem")
public class ProjectKeywords implements java.io.Serializable {

	private Long projectKeywordsId;
	private Keywords keywords;
	private Project project;

	public ProjectKeywords() {
	}

	public ProjectKeywords(Keywords keywords, Project project) {
		this.keywords = keywords;
		this.project = project;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "project_keywords_id", unique = true, nullable = false)
	public Long getProjectKeywordsId() {
		return this.projectKeywordsId;
	}

	public void setProjectKeywordsId(Long projectKeywordsId) {
		this.projectKeywordsId = projectKeywordsId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "keywords_id", nullable = false)
	public Keywords getKeywords() {
		return this.keywords;
	}

	public void setKeywords(Keywords keywords) {
		this.keywords = keywords;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "project_id", nullable = false)
	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

}