package com.moss.fuse.integrator.custom.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrphanageDto {

	private String id;
	
	private String directorate;
	
	private String adminstration;
	
	private String districtName;
	
	private String address;
	
	private OrphanageManagerDto orphanageManager;
	
}
