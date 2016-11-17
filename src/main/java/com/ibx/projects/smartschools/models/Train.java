package com.ibx.projects.smartschools.models;



import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * Created by vivek on 3/10/15.
 */
@Entity
@Table(name = "train")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Train implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	@NotNull
	private Integer trainNo;
	
	// Monday, Tuesday, etc.
	//@NotNull
	@Enumerated(EnumType.ORDINAL)
	private Day startDay;

	private String trainName;
	private String SourceStationCode;	
	private String DestinationstationCode;	
	private String TrainType;
	@ManyToOne(fetch = FetchType.LAZY)
	private Station fromStation;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Station toStation;
	
	public Train() {
		super();
		// TODO Auto-generated constructor stub
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
	public String getSourceStationCode() {
		return SourceStationCode;
	}
	public void setSourceStationCode(String sourceStationCode) {
		SourceStationCode = sourceStationCode;
	}
	public String getDestinationstationCode() {
		return DestinationstationCode;
	}
	public void setDestinationstationCode(String destinationstationCode) {
		DestinationstationCode = destinationstationCode;
	}
	public String getTrainType() {
		return TrainType;
	}
	public void setTrainType(String trainType) {
		TrainType = trainType;
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


	
	
	

	
}
