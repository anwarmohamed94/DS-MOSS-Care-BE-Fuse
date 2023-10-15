package com.moss.fuse.integrator.custom.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.moss.fuse.integrator.custom.dto.GeneralLookupDTO;
import com.moss.fuse.integrator.custom.model.aid.AidType;

@Mapper
public interface GeneralLookupMapper {

	GeneralLookupMapper MAPPER = Mappers.getMapper(GeneralLookupMapper.class);
		
	AidType mapToAidType(GeneralLookupDTO aidTypeDto);
}