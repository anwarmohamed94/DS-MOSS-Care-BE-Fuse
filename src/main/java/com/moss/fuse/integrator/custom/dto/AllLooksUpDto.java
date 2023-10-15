package com.moss.fuse.integrator.custom.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AllLooksUpDto {

	private List<String> aidTypes;
	
	private List<String> incomeSourceTypes;
	
	private List<String> expensesSourceTypes;
	
	private List<String> requestorTypes;
}
