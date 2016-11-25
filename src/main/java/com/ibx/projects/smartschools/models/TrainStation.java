/**
 * 
 */
package com.ibx.projects.smartschools.models;

import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ibx.project.smartschools.utils.LocalTimeDeserializer;
import com.ibx.project.smartschools.utils.LocalTimeSerializer;;


/**
 * @author SANTOSH
 *
 */

@Entity
@Table(name="train_station")

public class TrainStation {


	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
	

    @NotNull
    @ManyToOne
    private Train train;
    
    @NotNull
    @ManyToOne
    private Station station;

    
    private Integer stopNumber;
    private String arrivalTime;
    private String departureTime;

    
    @JsonSerialize(using = LocalTimeSerializer.class)
    @JsonDeserialize(using = LocalTimeDeserializer.class)
    @Column(name = "arrivalDateTime", columnDefinition = "TIME", nullable = true)
    private LocalTime arrivalDateTime;
    
    
    @JsonSerialize(using = LocalTimeSerializer.class)
    @JsonDeserialize(using = LocalTimeDeserializer.class)
    @Column(name = "departureDateTime", columnDefinition = "TIME", nullable = true)
    private LocalTime departureDateTime;
    

    
    @Enumerated(EnumType.ORDINAL)
	private Day day;
       
    private Integer dayOfJourney;
    private Long distance;
    private Long journeyDuration;

    private int arrivalMinutes;
    private int departureMinutes;
    
    private int arrivalDay;
    private int departureDay;
	public TrainStation() {
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Train getTrain() {
		return train;
	}
	public void setTrain(Train train) {
		this.train = train;
	}
	public Station getStation() {
		return station;
	}
	public void setStation(Station station) {
		this.station = station;
	}
	public Integer getStopNumber() {
		return stopNumber;
	}
	public void setStopNumber(Integer stopNumber) {
		this.stopNumber = stopNumber;
	}
	public String getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public String getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	
	public Day getDay() {
		return day;
	}
	public void setDay(Day day) {
		this.day = day;
	}
	public Integer getDayOfJourney() {
		return dayOfJourney;
	}
	public void setDayOfJourney(Integer dayOfJourney) {
		this.dayOfJourney = dayOfJourney;
	}
	public Long getDistance() {
		return distance;
	}
	public void setDistance(Long distance) {
		this.distance = distance;
	}
	public Long getJourneyDuration() {
		return journeyDuration;
	}
	public void setJourneyDuration(Long journeyDuration) {
		this.journeyDuration = journeyDuration;
	}
	public int getArrivalMinutes() {
		return arrivalMinutes;
	}
	public void setArrivalMinutes(int arrivalMinutes) {
		this.arrivalMinutes = arrivalMinutes;
	}
	public int getDepartureMinutes() {
		return departureMinutes;
	}
	public void setDepartureMinutes(int departureMinutes) {
		this.departureMinutes = departureMinutes;
	}
	public int getArrivalDay() {
		return arrivalDay;
	}
	public void setArrivalDay(int arrivalDay) {
		this.arrivalDay = arrivalDay;
	}
	public int getDepartureDay() {
		return departureDay;
	}
	public void setDepartureDay(int departureDay) {
		this.departureDay = departureDay;
	}
	public LocalTime getArrivalDateTime() {
		return arrivalDateTime;
	}
	public void setArrivalDateTime(LocalTime arrivalDateTime) {
		this.arrivalDateTime = arrivalDateTime;
	}
	public LocalTime getDepartureDateTime() {
		return departureDateTime;
	}
	public void setDepartureDateTime(LocalTime departureDateTime) {
		this.departureDateTime = departureDateTime;
	}
	

}
