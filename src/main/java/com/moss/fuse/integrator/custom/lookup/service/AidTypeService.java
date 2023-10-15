package com.moss.fuse.integrator.custom.lookup.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moss.fuse.integrator.custom.dto.GeneralLookupDTO;
import com.moss.fuse.integrator.custom.mapper.GeneralLookupMapper;
import com.moss.fuse.integrator.custom.model.aid.AidType;
import com.moss.fuse.integrator.custom.repository.AidTypeRepository;

@Service
public class AidTypeService {

	@Autowired
	private AidTypeRepository aidTyoeRepo;

	public List<String> getAidTypeLookup() {

		List<AidType> aidTypes = aidTyoeRepo.findAll();

		return aidTypes.stream().map((aidType) -> aidType.getType())
				.collect(Collectors.toList());
	}

	public void addAid(GeneralLookupDTO aidDto) {
		AidType aidType = GeneralLookupMapper.MAPPER.mapToAidType(aidDto);
		aidTyoeRepo.save(aidType);
	}
}
