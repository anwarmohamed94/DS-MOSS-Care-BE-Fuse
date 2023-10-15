package com.moss.fuse.integrator.custom.lookup.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moss.fuse.integrator.custom.model.orphanage.OrphanageExpensesSourceType;
import com.moss.fuse.integrator.custom.repository.ExpensesSourceRepository;

@Service
public class ExpensesSourceService {

	@Autowired
	private ExpensesSourceRepository expensesSourceRepository;

	public List<String> getExpensesSourceTypeLookup() {

		List<OrphanageExpensesSourceType> expensesSourceTypes = expensesSourceRepository.findAll();

		return expensesSourceTypes.stream().map((expensesSourceType) -> expensesSourceType.getType())
				.collect(Collectors.toList());
	}
}
