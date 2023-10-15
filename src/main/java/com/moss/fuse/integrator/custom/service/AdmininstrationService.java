package com.moss.fuse.integrator.custom.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moss.fuse.integrator.custom.dto.OrphanagesLookupDTO;
import com.moss.fuse.integrator.custom.exception.OrphanNotFoundException;
import com.moss.fuse.integrator.custom.exception.OrphanageNotFoundException;
import com.moss.fuse.integrator.custom.mapper.OrphanageMapper;
import com.moss.fuse.integrator.custom.model.common.Administration;
import com.moss.fuse.integrator.custom.model.orphanage.Orphanage;
import com.moss.fuse.integrator.custom.repository.AdministrationRepository;

@Service
public class AdmininstrationService {

	@Autowired
	private AdministrationRepository administrationRepository;

	@Transactional
	public List<OrphanagesLookupDTO> getAdminOrphanages(Long administrationId) throws OrphanageNotFoundException, OrphanNotFoundException {

		Optional<Administration> adminOptional = administrationRepository.findById(administrationId);

		if (!adminOptional.isPresent())
			throw new OrphanNotFoundException(Long.toString(administrationId));

		Set<Orphanage> orphanages = adminOptional.get().getOrphanages();
		
		return orphanages.stream().map((orphanage) -> OrphanageMapper.MAPPER.mapToOrphanagesLookupDTO(orphanage))
				.collect(Collectors.toList());

	}
}
