/**
 * 
 */
package com.ibx.projects.smartschools.models;

import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters.LocalDateTimeConverter;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters.LocalTimeConverter;


/**
 * @author SANTOSH
 *
 */

@Entity
@Table(name="train_station")
public class TrainStation {
	
	/*@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;*/
	
	@Id
    @GeneratedValue
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

    
    @Convert(converter = LocalTimeConverter.class)
    private LocalTime arrival = LocalTime.now();

    
    @Convert(converter = LocalTimeConverter.class)
    private LocalTime departure = LocalTime.now();
    
    

    
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

}
