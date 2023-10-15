package com.moss.fuse.integrator.custom.lookup.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moss.fuse.integrator.custom.model.aid.RequestorType;
import com.moss.fuse.integrator.custom.repository.RequestorTypeRepository;

@Service
public class RequestorTypeService {

	@Autowired
	private RequestorTypeRepository requestorTypeRepository;

	public List<String> getRequestorTypeLookup() {

		List<RequestorType> requestorTypes = requestorTypeRepository.findAll();

		return requestorTypes.stream().map((requestorType) -> requestorType.getType())
				.collect(Collectors.toList());
	}
}
