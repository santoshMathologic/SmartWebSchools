package com.ibx.projects.smartschools.models;



import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;



/**
 * Created by santosh 
 */
@Entity
@Table(name = "train")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Train implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@NotNull
	private Integer trainNo;
	
	// Monday, Tuesday, etc.
	//@NotNull
	@Enumerated(EnumType.ORDINAL)
	private Day startDay;

	private String trainName;
	
	
	
	
	@JsonManagedReference
	@ManyToOne(fetch = FetchType.LAZY)
	private Station fromStation;
	
	
	@JsonManagedReference
	@ManyToOne(fetch = FetchType.LAZY)
	private Station toStation;
	
	
	@JsonManagedReference	
	@ManyToOne(fetch = FetchType.LAZY)
	private TrainType trainType;
	
	@OneToMany(mappedBy="train", cascade = CascadeType.REMOVE,fetch = FetchType.LAZY)
	private List<TrainStation> trainStations = new LinkedList<TrainStation>();
	
	
	public Train() {
		super();
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getTrainNo() {
		return trainNo;
	}
	public void setTrainNo(Integer trainNo) {
		this.trainNo = trainNo;
	}
	public Day getStartDay() {
		return startDay;
	}
	public void setStartDay(Day startDay) {
		this.startDay = startDay;
	}
	public String getTrainName() {
		return trainName;
	}
	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}
	

	public Station getFromStation() {
		return fromStation;
	}

	public void setFromStation(Station fromStation) {
		this.fromStation = fromStation;
	}

	public Station getToStation() {
		return toStation;
	}

	public void setToStation(Station toStation) {
		this.toStation = toStation;
	}

	public void setTrainType(TrainType trainType) {
		this.trainType = trainType;
	}


	
	
	

	
}
