package com.moss.fuse.integrator.custom.model.orphan;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.moss.fuse.integrator.custom.enums.Gender;
import com.moss.fuse.integrator.custom.enums.OrphanLineageType;
import com.moss.fuse.integrator.custom.enums.SocialStatus;
import com.moss.fuse.integrator.custom.model.aid.Aid;
import com.moss.fuse.integrator.custom.model.base.BaseEntity;
import com.moss.fuse.integrator.custom.model.common.Governorate;
import com.moss.fuse.integrator.custom.model.orphanage.Orphanage;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "orphan")
public class Orphan extends BaseEntity {

    private String firstName;

    private String secondName;

    private String thirdName;

    private String nickname;

    private String fullName;
    
    private String registrationStatus;
    
    private String nationalID;
    
    @Enumerated(EnumType.STRING)
    private OrphanLineageType orphanLineageType;

    private String familyBreakup;

    private String nationality;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private Date birthday;

    @ManyToOne
    @JoinColumn(name = "birth_governorate_id")
    private Governorate birthGovernorate;

    @Enumerated(EnumType.STRING)
    private SocialStatus socialStatus;

    @ManyToOne
    @JoinColumn(name = "found_governorate_id")
    private Governorate foundGovernorate;

    private String foundCenter;

    private String district;

    private String recordNumber;

    private Date recordDate;

    private String prosecutionDecisionNumber;

    private Date prosecutionDecisionDate;

    private String educationalLevel;

    private String educationType;

    private String chronicDiseases;

    private String address;

    private String disability;

    private String subscription;

    private Date deathDate;

    private String deathReason;

    private String notes;


    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "orphan_aid",
        joinColumns = { @JoinColumn(name = "orphan_id") },
        inverseJoinColumns = { @JoinColumn(name = "aid_id") })
    private Set<Aid> aids = new HashSet<>();

    @ManyToMany(mappedBy = "orphans")
    private Set<Parent> parents;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orphanage_id")
    private Orphanage orphanage;

}
