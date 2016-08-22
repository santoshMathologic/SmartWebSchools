/**
 * 
 */
package com.ibx.projects.smartschools.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author SANTOSH
 *
 */

@Entity
@Table(name="class_table")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Class_table implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@Id
    @GeneratedValue
    private Long class_id;
	
	private String className;
	
	private String section_1;
	private String section_2;
	private String section_3;
	private String section_4;
	private String section_5;
	private String section_6;
	private String section_7;
	private String section_8;
	private String section_9;
	private String section_10;
	private double year_fees;
	
	
	@Column(columnDefinition="BIT(1) DEFAULT b'0'")
	private Boolean markDelete;
	
	public Class_table() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param class_id
	 * @param className
	 * @param section_1
	 * @param section_2
	 * @param section_3
	 * @param section_4
	 * @param section_5
	 * @param section_6
	 * @param section_7
	 * @param section_8
	 * @param section_9
	 * @param section_10
	 * @param year_fees
	 * @param markDelete
	 */
	public Class_table(Long class_id, String className, String section_1, String section_2, String section_3,
			String section_4, String section_5, String section_6, String section_7, String section_8, String section_9,
			String section_10, double year_fees, Boolean markDelete) {
		super();
		this.class_id = class_id;
		this.className = className;
		this.section_1 = section_1;
		this.section_2 = section_2;
		this.section_3 = section_3;
		this.section_4 = section_4;
		this.section_5 = section_5;
		this.section_6 = section_6;
		this.section_7 = section_7;
		this.section_8 = section_8;
		this.section_9 = section_9;
		this.section_10 = section_10;
		this.year_fees = year_fees;
		this.markDelete = markDelete;
	}

	public Long getClass_id() {
		return class_id;
	}

	public void setClass_id(Long class_id) {
		this.class_id = class_id;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getSection_1() {
		return section_1;
	}

	public void setSection_1(String section_1) {
		this.section_1 = section_1;
	}

	public String getSection_2() {
		return section_2;
	}

	public void setSection_2(String section_2) {
		this.section_2 = section_2;
	}

	public String getSection_3() {
		return section_3;
	}

	public void setSection_3(String section_3) {
		this.section_3 = section_3;
	}

	public String getSection_4() {
		return section_4;
	}

	public void setSection_4(String section_4) {
		this.section_4 = section_4;
	}

	public String getSection_5() {
		return section_5;
	}

	public void setSection_5(String section_5) {
		this.section_5 = section_5;
	}

	public String getSection_6() {
		return section_6;
	}

	public void setSection_6(String section_6) {
		this.section_6 = section_6;
	}

	public String getSection_7() {
		return section_7;
	}

	public void setSection_7(String section_7) {
		this.section_7 = section_7;
	}

	public String getSection_8() {
		return section_8;
	}

	public void setSection_8(String section_8) {
		this.section_8 = section_8;
	}

	public String getSection_9() {
		return section_9;
	}

	public void setSection_9(String section_9) {
		this.section_9 = section_9;
	}

	public String getSection_10() {
		return section_10;
	}

	public void setSection_10(String section_10) {
		this.section_10 = section_10;
	}

	public double getYear_fees() {
		return year_fees;
	}

	public void setYear_fees(double year_fees) {
		this.year_fees = year_fees;
	}

	public Boolean getMarkDelete() {
		return markDelete;
	}

	public void setMarkDelete(Boolean markDelete) {
		this.markDelete = markDelete;
	}

}
