package com.moss.fuse.integrator.custom.dto;

import java.util.Date;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.moss.fuse.integrator.custom.enums.Gender;
import com.moss.fuse.integrator.custom.enums.OrphanLineageType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrphanDto {

	private Long id;
	
	private String fullName;

	private String registrationStatus;
	
	private String nationalID;
	
	@Enumerated(EnumType.STRING)
	private OrphanLineageType lineage;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;

	private Date dateOfBirth;

	private String educationStage;

	private String educationType;
}
