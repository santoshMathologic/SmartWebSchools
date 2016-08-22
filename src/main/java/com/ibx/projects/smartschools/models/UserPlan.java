package com.ibx.projects.smartschools.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



/**
 * Created by santosh on  8-20-2016
 */
@Entity
@Table(name = "user_plan")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class UserPlan implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue
    private Long id;

    @NotNull
	@Column(unique = true)
    private String planName;
    
    
	private String owner;
    
	@ManyToOne
	private User user;
	
	@Column(columnDefinition="BIT(1) DEFAULT b'0'")
	private Boolean markDelete;
	
	//@Column(unique=true,columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	//private LocalDateTime createdTime = LocalDateTime.now();
	
	
	private String co_planner;
	@Column(columnDefinition="BIT(1) DEFAULT b'0'")
	private Boolean isUnderReviewer;
	
	private String reviewer;
	
	
	public UserPlan(){
		
	}
    
    
	public UserPlan(Long id, String planName, String owner, User user, Boolean markDelete, LocalDateTime createdTime,
			String co_planner, Boolean isUnderReviewer, String reviewer) {
		super();
		this.id = id;
		this.planName = planName;
		this.owner = owner;
		this.user = user;
		this.markDelete = markDelete;
		//this.createdTime = createdTime;
		this.co_planner = co_planner;
		this.isUnderReviewer = isUnderReviewer;
		this.reviewer = reviewer;
	}

    
   
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Boolean getMarkDelete() {
		return markDelete;
	}

	public void setMarkDelete(Boolean markDelete) {
		this.markDelete = markDelete;
	}

	/*
	public LocalDateTime getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(LocalDateTime createdTime) {
		this.createdTime = createdTime;
	}
	*/
	

	public String getCo_planner() {
		return co_planner;
	}

	public void setCo_planner(String co_planner) {
		this.co_planner = co_planner;
	}

	public Boolean getIsUnderReviewer() {
		return isUnderReviewer;
	}

	public void setIsUnderReviewer(Boolean isUnderReviewer) {
		this.isUnderReviewer = isUnderReviewer;
	}

	public String getReviewer() {
		return reviewer;
	}

	public void setReviewer(String reviewer) {
		this.reviewer = reviewer;
	}

  
}