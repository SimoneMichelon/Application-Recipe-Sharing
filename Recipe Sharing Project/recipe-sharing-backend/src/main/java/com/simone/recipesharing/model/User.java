package com.simone.recipesharing.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class User {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long id;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;
	private String email;
	private String fullName;
}
