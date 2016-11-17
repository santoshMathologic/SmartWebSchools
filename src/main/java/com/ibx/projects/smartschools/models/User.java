/**
 * 
 */
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;






/**
 * @author SANTOSH
 *
 */
@Entity
@Table(name = "user")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User implements Serializable  {

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
	private String address;
	
	@Column(columnDefinition="BIT(1) DEFAULT b'0'")
	private Boolean markDelete;
	
	@Column(columnDefinition="BIT(1) DEFAULT b'0'")
	private Boolean isActive;
	

	@NotNull
	@ManyToOne(fetch=FetchType.LAZY)
	private Role role;
	
	@OneToMany(mappedBy="user",fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
	private List<UserPlan> userPlans = new LinkedList<UserPlan>();

	
	public User() {
		// TODO Auto-generated constructor stub
	}
	


	/**
	 * @param username
	 * @param password
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param mobileNo
	 * @param telephoneNo
	 * @param extension
	 * @param employeeNo
	 * @param role
	 */
	public User(String username, String password, String firstName, String lastName, String email, String mobileNo,
			String telephoneNo, String extension, String employeeNo, Role role) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobileNo = mobileNo;
		this.telephoneNo = telephoneNo;
		this.extension = extension;
		this.employeeNo = employeeNo;
		this.role = role;
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



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public Boolean getMarkDelete() {
		return markDelete;
	}



	public void setMarkDelete(Boolean markDelete) {
		this.markDelete = markDelete;
	}



	public Boolean getIsActive() {
		return isActive;
	}



	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

}
