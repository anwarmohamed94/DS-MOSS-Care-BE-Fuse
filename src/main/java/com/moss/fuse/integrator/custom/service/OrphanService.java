package com.moss.fuse.integrator.custom.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moss.fuse.integrator.custom.dto.OrphanDto;
import com.moss.fuse.integrator.custom.exception.OrphanNotFoundException;
import com.moss.fuse.integrator.custom.mapper.OrphanMapper;
import com.moss.fuse.integrator.custom.model.orphan.Orphan;
import com.moss.fuse.integrator.custom.repository.OrphanRepository;

@Service
public class OrphanService {

	@Autowired
	private OrphanRepository orphanRepository;

	public OrphanDto getOrphan(Long id) throws OrphanNotFoundException {

		Optional<Orphan> orphan= orphanRepository.findById(id);
		
		 if(orphan.isPresent())
			 return OrphanMapper.MAPPER.mapToOrphanDTO(orphan.get());
		 
		 else
			 throw new OrphanNotFoundException(Long.toString(id));
	}

}
