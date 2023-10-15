package com.moss.fuse.integrator.custom.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.moss.fuse.integrator.custom.dto.OrphanageDto;
import com.moss.fuse.integrator.custom.dto.OrphanagesLookupDTO;
import com.moss.fuse.integrator.custom.model.orphanage.Orphanage;

@Mapper
public interface OrphanageMapper {

	OrphanageMapper MAPPER = Mappers.getMapper(OrphanageMapper.class);

	@Mappings({ @Mapping(target = "directorate", source = "directorate.name"),
			@Mapping(target = "adminstration", source = "administration.name"),
			@Mapping(target = "districtName", source = "district.name") })
	OrphanageDto mapToOrphanageDto(Orphanage orphanage);

	OrphanagesLookupDTO mapToOrphanagesLookupDTO(Orphanage orphan);
}