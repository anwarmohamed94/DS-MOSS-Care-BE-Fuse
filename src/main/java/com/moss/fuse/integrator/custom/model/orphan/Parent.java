package com.moss.fuse.integrator.custom.model.orphan;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.moss.fuse.integrator.custom.model.base.PersonBaseEntity;
import com.moss.fuse.integrator.custom.model.common.Governorate;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "parent")
public class Parent extends PersonBaseEntity {

    private Integer passportNumber;

    private String educationalStatus;

    private String educationalLevel;

    private String otherNationality;

    private String personalPhoto;

    private String birthCertificate;

    private String nationalIdPhoto;

    private String criminalStatus;

    private String medicalCertificate;

    private String incomeProof;

    private String virusCcertificate;

    @ManyToOne
    @JoinColumn(name = "birth_governorate_id")
    private Governorate birthGovernorate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "family_id", nullable = false)
    private Family family;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "parent_child",
        joinColumns = { @JoinColumn(name = "parent_id") },
        inverseJoinColumns = { @JoinColumn(name = "child_id") })
    private Set<Child> children = new HashSet<>();


    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "parent_orphan",
        joinColumns = { @JoinColumn(name = "parent_id") },
        inverseJoinColumns = { @JoinColumn(name = "orphan_id") })
    private Set<Orphan> orphans;

}
