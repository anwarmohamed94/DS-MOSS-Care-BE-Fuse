package com.moss.fuse.integrator.custom.model.orphanage;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.moss.fuse.integrator.custom.enums.SonsType;
import com.moss.fuse.integrator.custom.model.base.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "orphanage_beneficiaries_data")
public class OrphanageBeneficiariesData extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private SonsType sonsType;

    private Integer childrenMinimumAge;

    private Integer childrenMaximumAge;

    private Integer orphanageFemaleCapacity;

    private Integer orphanageMaleCapacity;

    private Integer actualFemaleNumber;

    private Integer actualMaleNumber;

    private Integer sponsorsNumber;

    private Integer beneficiaryCasesNumber;

    @OneToOne(mappedBy = "orphanageBeneficiariesData")
    private Orphanage orphanage;

}
