package com.moss.fuse.integrator.custom.model.orphan;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.moss.fuse.integrator.custom.model.base.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "family")
public class Family extends BaseEntity {


    @OneToMany(mappedBy = "family")
    private Set<Parent> parents;

    @OneToMany(mappedBy = "family")
    private Set<Child> children;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "housing_details_id", referencedColumnName = "id")
    private FamilyHousingDetails familyHousingDetails;
}
