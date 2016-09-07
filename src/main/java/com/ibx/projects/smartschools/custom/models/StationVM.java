/**
 * 
 */
package com.ibx.projects.smartschools.custom.models;

/**
 * @author SANTOSH
 *
 */
public class StationVM {

	/**
	 * 
	 */
	
	private Long id;
	private String code;
	private String name;
	private int noOfBeds;
	private Long headStationSignOffDuration;
	private Long headStationSignOnDuration;
	private Long outStationSignOffDuration;
	private Long outStationSignOnDuration;
	
	public StationVM() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param code
	 * @param name
	 * @param noOfBeds
	 * @param headStationSignOffDuration
	 * @param headStationSignOnDuration
	 * @param outStationSignOffDuration
	 * @param outStationSignOnDuration
	 */
	public StationVM(Long id, String code, String name, int noOfBeds, Long headStationSignOffDuration,
			Long headStationSignOnDuration, Long outStationSignOffDuration, Long outStationSignOnDuration) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.noOfBeds = noOfBeds;
		this.headStationSignOffDuration = headStationSignOffDuration;
		this.headStationSignOnDuration = headStationSignOnDuration;
		this.outStationSignOffDuration = outStationSignOffDuration;
		this.outStationSignOnDuration = outStationSignOnDuration;
	}

	public Long getId() {
		return id;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public int getNoOfBeds() {
		return noOfBeds;
	}

	public Long getHeadStationSignOffDuration() {
		return headStationSignOffDuration;
	}

	public Long getHeadStationSignOnDuration() {
		return headStationSignOnDuration;
	}

	public Long getOutStationSignOffDuration() {
		return outStationSignOffDuration;
	}

	public Long getOutStationSignOnDuration() {
		return outStationSignOnDuration;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNoOfBeds(int noOfBeds) {
		this.noOfBeds = noOfBeds;
	}

	public void setHeadStationSignOffDuration(Long headStationSignOffDuration) {
		this.headStationSignOffDuration = headStationSignOffDuration;
	}

	public void setHeadStationSignOnDuration(Long headStationSignOnDuration) {
		this.headStationSignOnDuration = headStationSignOnDuration;
	}

	public void setOutStationSignOffDuration(Long outStationSignOffDuration) {
		this.outStationSignOffDuration = outStationSignOffDuration;
	}

	public void setOutStationSignOnDuration(Long outStationSignOnDuration) {
		this.outStationSignOnDuration = outStationSignOnDuration;
	}

}
