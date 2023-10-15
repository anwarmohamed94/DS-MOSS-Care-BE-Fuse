package com.moss.fuse.integrator.custom.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moss.fuse.integrator.custom.dto.OrphanageDto;
import com.moss.fuse.integrator.custom.dto.OrphansLookupDTO;
import com.moss.fuse.integrator.custom.exception.OrphanageNotFoundException;
import com.moss.fuse.integrator.custom.mapper.OrphanMapper;
import com.moss.fuse.integrator.custom.mapper.OrphanageMapper;
import com.moss.fuse.integrator.custom.model.orphan.Orphan;
import com.moss.fuse.integrator.custom.model.orphanage.Orphanage;
import com.moss.fuse.integrator.custom.repository.OrphanageRepository;

@Service
public class OrphanageService {

	@Autowired
	private OrphanageRepository orphanageRepository;

	@Transactional
	public OrphanageDto getOrphanage(Long orphanageId) throws OrphanageNotFoundException {

		Optional<Orphanage> orphanage = orphanageRepository.findById(orphanageId);

		if (!orphanage.isPresent())
			throw new OrphanageNotFoundException(Long.toString(orphanageId));
		
		return OrphanageMapper.MAPPER.mapToOrphanageDto(orphanage.get());
	}
	
	@Transactional
	public List<OrphansLookupDTO> getOrphanageOrphans(Long orphanageId) throws OrphanageNotFoundException {

		Optional<Orphanage> orphanage = orphanageRepository.findById(orphanageId);

		if (!orphanage.isPresent())
			throw new OrphanageNotFoundException(Long.toString(orphanageId));

		Set<Orphan> orphans = orphanage.get().getOrphans();
		
		return orphans.stream().map((orphan) -> OrphanMapper.MAPPER.mapToOrphansLookupDTO(orphan))
				.collect(Collectors.toList());
	}
}
