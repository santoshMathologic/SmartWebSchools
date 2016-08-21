/**
 * 
 */
package com.ibx.projects.smartschools.models;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "user")
public class User {

	/**
	 * 
	 */
	
	@Id
	@GeneratedValue
	private Long id;

	@NotNull
	@Column(unique = true)
	private String username;

	private String password;

	@NotNull
	private String firstName;
	private String lastName;

	@NotNull
	@Column(unique = true)
	private String email;

	private String mobileNo;
	private String telephoneNo;
	private String extension;
	private String employeeNo;
	

	@NotNull
	@ManyToOne	
	private Role role;

	
	public User() {
		// TODO Auto-generated constructor stub
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getMobileNo() {
		return mobileNo;
	}


	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}


	public String getTelephoneNo() {
		return telephoneNo;
	}


	public void setTelephoneNo(String telephoneNo) {
		this.telephoneNo = telephoneNo;
	}


	public String getExtension() {
		return extension;
	}


	public void setExtension(String extension) {
		this.extension = extension;
	}


	public String getEmployeeNo() {
		return employeeNo;
	}


	public void setEmployeeNo(String employeeNo) {
		this.employeeNo = employeeNo;
	}
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
