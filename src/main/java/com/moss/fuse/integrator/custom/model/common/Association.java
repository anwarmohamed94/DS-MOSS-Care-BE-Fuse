package com.moss.fuse.integrator.custom.model.common;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.moss.fuse.integrator.custom.enums.AssociationDependencyType;
import com.moss.fuse.integrator.custom.model.base.BaseEntity;
import com.moss.fuse.integrator.custom.model.orphanage.Orphanage;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "association")
public class Association extends BaseEntity {

    private String name;

    private String address;

    private Integer publicationNumber;

    private Integer publicationYear;

    private String chairmanName;

    private String chairmanPhone;

    private String associationManagerName;

    private String associationManagerNumber;

    @Enumerated(EnumType.STRING)
    private AssociationDependencyType associationDependencyType;

    private Boolean hasPublicBenefit;

    private String associationActivities;

    private String telephoneNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "directorate_id")
    private Directorate directorate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "administration_id")
    private Administration administration;

    @OneToMany(mappedBy = "association")
    private Set<Orphanage> orphanages;
}
