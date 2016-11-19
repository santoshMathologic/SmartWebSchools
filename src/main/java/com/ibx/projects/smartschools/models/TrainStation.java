/**
 * 
 */
package com.ibx.projects.smartschools.models;

import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


/**
 * @author SANTOSH
 *
 */

@Entity
@Table(name="train_station")
public class TrainStation {
	
	@Id
    @GeneratedValue
    private Long id;

    @NotNull
    @ManyToOne
    private Train train;
    
    @NotNull
    @ManyToOne
    private Station station;

    @NotNull
    private Integer stopNumber;

    
    
    @NotNull
    private LocalTime arrival;

    @NotNull
    private LocalTime departure;

    @NotNull
    @Enumerated(EnumType.ORDINAL)
	private Day day;
    
    @NotNull
    private Integer dayOfJourney;

    @NotNull
    private Long distance;

    @NotNull
    private Long journeyDuration;

	
	public TrainStation() {
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


	public Integer getStopNumber() {
		return stopNumber;
	}


	public void setStopNumber(Integer stopNumber) {
		this.stopNumber = stopNumber;
	}


	public Station getStation() {
		return station;
	}


	public void setStation(Station station) {
		this.station = station;
	}


	public LocalTime getArrival() {
		return arrival;
	}


	public void setArrival(LocalTime arrival) {
		this.arrival = arrival;
	}


	public LocalTime getDeparture() {
		return departure;
	}


	public void setDeparture(LocalTime departure) {
		this.departure = departure;
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

}
