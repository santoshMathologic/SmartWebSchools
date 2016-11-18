package com.ibx.projects.smartschools.models;



import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * Created by santosh
 */
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "station")

public class Station implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	@NotNull
	@Column(unique = true)
	private String code;

	private String name;

	@Column(columnDefinition="BIGINT DEFAULT 30")
	private Long headStationSignOnDuration = 30L;

	@Column(columnDefinition="BIGINT DEFAULT 30")
	private Long headStationSignOffDuration= 30L;
	
	@Column(columnDefinition="INT DEFAULT 1")
	private Integer numberOfBeds= 1;

	@Column(columnDefinition="BIGINT DEFAULT 30")
	private Long outStationSignOnDuration= 30L;

	@Column(columnDefinition="BIGINT DEFAULT 30")
	private Long outStationSignOffDuration= 30L;
	
	
	
	
	


	@JsonBackReference
	@OneToMany(mappedBy = "fromStation", cascade = CascadeType.REMOVE,fetch = FetchType.LAZY)
	private List<Train> fromTrains = new LinkedList<Train>();

	
	@JsonBackReference
	@OneToMany(mappedBy = "toStation", cascade = CascadeType.REMOVE,fetch = FetchType.LAZY)
	private List<Train> toTrains = new LinkedList<Train>();

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getHeadStationSignOnDuration() {
		return headStationSignOnDuration;
	}

	public void setHeadStationSignOnDuration(Long headStationSignOnDuration) {
		this.headStationSignOnDuration = headStationSignOnDuration;
	}

	public Long getHeadStationSignOffDuration() {
		return headStationSignOffDuration;
	}

	public void setHeadStationSignOffDuration(Long headStationSignOffDuration) {
		this.headStationSignOffDuration = headStationSignOffDuration;
	}

	public Integer getNumberOfBeds() {
		return numberOfBeds;
	}

	public void setNumberOfBeds(Integer numberOfBeds) {
		this.numberOfBeds = numberOfBeds;
	}

	public Long getOutStationSignOnDuration() {
		return outStationSignOnDuration;
	}

	public void setOutStationSignOnDuration(Long outStationSignOnDuration) {
		this.outStationSignOnDuration = outStationSignOnDuration;
	}

	public Long getOutStationSignOffDuration() {
		return outStationSignOffDuration;
	}

	public void setOutStationSignOffDuration(Long outStationSignOffDuration) {
		this.outStationSignOffDuration = outStationSignOffDuration;
	}

	

	public List<Train> getFromTrains() {
		return fromTrains;
	}

	public void setFromTrains(List<Train> fromTrains) {
		this.fromTrains = fromTrains;
	}

	public List<Train> getToTrains() {
		return toTrains;
	}

	public void setToTrains(List<Train> toTrains) {
		this.toTrains = toTrains;
	}

	
}
