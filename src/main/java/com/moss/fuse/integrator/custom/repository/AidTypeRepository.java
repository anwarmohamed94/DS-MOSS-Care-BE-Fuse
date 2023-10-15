package com.moss.fuse.integrator.custom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moss.fuse.integrator.custom.model.aid.AidType;

@Repository
public interface AidTypeRepository extends JpaRepository<AidType, Long>{

}