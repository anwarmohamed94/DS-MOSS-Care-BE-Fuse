package com.moss.fuse.integrator.custom.model.orphanage;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.moss.fuse.integrator.custom.enums.OrphanageCategory;
import com.moss.fuse.integrator.custom.enums.OrphanageConstructionType;
import com.moss.fuse.integrator.custom.enums.OrphanageDependencyType;
import com.moss.fuse.integrator.custom.enums.OrphanageLicenseStatus;
import com.moss.fuse.integrator.custom.enums.OrphanageStatus;
import com.moss.fuse.integrator.custom.model.base.BaseEntity;
import com.moss.fuse.integrator.custom.model.common.Administration;
import com.moss.fuse.integrator.custom.model.common.Association;
import com.moss.fuse.integrator.custom.model.common.Directorate;
import com.moss.fuse.integrator.custom.model.common.District;
import com.moss.fuse.integrator.custom.model.orphan.Orphan;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "orphanage")
public class Orphanage extends BaseEntity {

    private String name;

    @Enumerated(EnumType.STRING)
    private OrphanageCategory orphanageCategory;

    private Boolean isLicensedByPublicAdministration;

    private Date constructionDate;

    private String licenseNumber;

    private Date licenseDate;

    @Enumerated(EnumType.STRING)
    private OrphanageLicenseStatus orphanageLicenseStatus;

    @Enumerated(EnumType.STRING)
    private OrphanageConstructionType orphanageConstructionType;

    @Enumerated(EnumType.STRING)
    private OrphanageDependencyType orphanageDependencyType;

    @Enumerated(EnumType.STRING)
    private OrphanageStatus orphanageStatus;

    private String address;

    private String notes;

    private String budgetSource;

    private String periodicSubsidyValue;

    private String landLineNumber;

    private String mobileNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "directorate_id")
    private Directorate directorate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "administration_id")
    private Administration administration;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "district_id", nullable = false)
    private District district;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assosiation_id", nullable = false)
    private Association association;

    @OneToOne(mappedBy = "managerOrphanage", cascade = CascadeType.ALL)
    private Employee orphanageManager;
    
    @OneToMany(mappedBy = "orphanage")
    private Set<Employee> employees;

    @OneToMany(mappedBy = "orphanage")
    private Set<Orphan> orphans;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "beneficiaries_data_id", referencedColumnName = "id")
    private OrphanageBeneficiariesData orphanageBeneficiariesData;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "building_data_id", referencedColumnName = "id")
    private OrphanageBuildingData orphanageBuildingData;

    @OneToMany(mappedBy = "orphanage")
    private Set<OrphanageDepartmentData> orphanageDepartmentData;

    @OneToMany(mappedBy = "orphanage")
    private Set<OrphanageExpenses> orphanageExpenses;

    @OneToMany(mappedBy = "orphanage")
    private Set<OrphanageIncome> orphanageIncomes;

    @OneToMany(mappedBy = "orphanage")
    private Set<OrphanageFinancialSupport> orphanageFinancialSupports;




}
