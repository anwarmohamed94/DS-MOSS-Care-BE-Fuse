package com.moss.fuse.integrator.custom.model.orphanage;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.moss.fuse.integrator.custom.model.base.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "orphanage_department_data")
public class OrphanageDepartmentData extends BaseEntity {

    private String jobType;

    private Integer numberOfEmployees;

    @ManyToOne
    @JoinColumn(name = "orphanage_id")
    private Orphanage orphanage;

}
