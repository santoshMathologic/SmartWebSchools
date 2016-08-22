/**
 * 
 */
package com.ibx.projects.smartschools.models;

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
@Table(name="class_subjects_table")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})	
public class Class_subject_table {

	@Id
    @GeneratedValue
    private Long class_subjects_id;
	
	
	
	private String subject1;
	private String subject2;
	private String subject3;
	private String subject4;
	private String subject5;
	private String subject6;
	private String subject7;
	private String subject8;
	private String subject9;
	private String subject10;
	private String subject11;
	private String subject12;
	private String subject13;
	private String subject15;
	private String class_name;
	
	@Column(columnDefinition="BIT(1) DEFAULT b'0'")
	private Boolean markDelete;
	
	
	public Class_subject_table() {
		
	}


	/**
	 * @param class_subjects_id
	 * @param subject1
	 * @param subject2
	 * @param subject3
	 * @param subject4
	 * @param subject5
	 * @param subject6
	 * @param subject7
	 * @param subject8
	 * @param subject9
	 * @param subject10
	 * @param subject11
	 * @param subject12
	 * @param subject13
	 * @param subject15
	 * @param class_name
	 * @param markDelete
	 */
	public Class_subject_table(Long class_subjects_id, String subject1, String subject2, String subject3,
			String subject4, String subject5, String subject6, String subject7, String subject8, String subject9,
			String subject10, String subject11, String subject12, String subject13, String subject15, String class_name,
			Boolean markDelete) {
		super();
		this.class_subjects_id = class_subjects_id;
		this.subject1 = subject1;
		this.subject2 = subject2;
		this.subject3 = subject3;
		this.subject4 = subject4;
		this.subject5 = subject5;
		this.subject6 = subject6;
		this.subject7 = subject7;
		this.subject8 = subject8;
		this.subject9 = subject9;
		this.subject10 = subject10;
		this.subject11 = subject11;
		this.subject12 = subject12;
		this.subject13 = subject13;
		this.subject15 = subject15;
		this.class_name = class_name;
		this.markDelete = markDelete;
	}


	public Long getClass_subjects_id() {
		return class_subjects_id;
	}


	public String getSubject1() {
		return subject1;
	}


	public String getSubject2() {
		return subject2;
	}


	public String getSubject3() {
		return subject3;
	}


	public String getSubject4() {
		return subject4;
	}


	public String getSubject5() {
		return subject5;
	}


	public String getSubject6() {
		return subject6;
	}


	public String getSubject7() {
		return subject7;
	}


	public String getSubject8() {
		return subject8;
	}


	public String getSubject9() {
		return subject9;
	}


	public String getSubject10() {
		return subject10;
	}


	public String getSubject11() {
		return subject11;
	}


	public String getSubject12() {
		return subject12;
	}


	public String getSubject13() {
		return subject13;
	}


	public String getSubject15() {
		return subject15;
	}


	public String getClass_name() {
		return class_name;
	}


	public Boolean getMarkDelete() {
		return markDelete;
	}


	public void setClass_subjects_id(Long class_subjects_id) {
		this.class_subjects_id = class_subjects_id;
	}


	public void setSubject1(String subject1) {
		this.subject1 = subject1;
	}


	public void setSubject2(String subject2) {
		this.subject2 = subject2;
	}


	public void setSubject3(String subject3) {
		this.subject3 = subject3;
	}


	public void setSubject4(String subject4) {
		this.subject4 = subject4;
	}


	public void setSubject5(String subject5) {
		this.subject5 = subject5;
	}


	public void setSubject6(String subject6) {
		this.subject6 = subject6;
	}


	public void setSubject7(String subject7) {
		this.subject7 = subject7;
	}


	public void setSubject8(String subject8) {
		this.subject8 = subject8;
	}


	public void setSubject9(String subject9) {
		this.subject9 = subject9;
	}


	public void setSubject10(String subject10) {
		this.subject10 = subject10;
	}


	public void setSubject11(String subject11) {
		this.subject11 = subject11;
	}


	public void setSubject12(String subject12) {
		this.subject12 = subject12;
	}


	public void setSubject13(String subject13) {
		this.subject13 = subject13;
	}


	public void setSubject15(String subject15) {
		this.subject15 = subject15;
	}


	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}


	public void setMarkDelete(Boolean markDelete) {
		this.markDelete = markDelete;
	}

}
