package com.gk.restapi.model;

import java.sql.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity
@Table(name = "tbl_employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//@JsonProperty("full_name") | Changes JSON Property Name
	//@JsonIgnore | Ignores From Json
	// If Variable and database name are same, we don't need to use @Column Annotation
	
	@NotBlank(message = "Name should not be Null")
	private String name;
	
	private Long age = 0L;
	
	private String location;
	
	@Email(message = "Please enter the valid email address")
	private String email;
	
	@NotBlank(message = "Department should not be Null")
	private String department;
	
	@CreationTimestamp
	@Column(name = "created_at", nullable = false, updatable = false)
	private Date createdAt;
	 
	@UpdateTimestamp
	@Column(name = "updated_at")
	private Date updatedAt;
	
}
