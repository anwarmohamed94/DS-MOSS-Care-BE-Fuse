package com.moss.fuse.integrator.custom.model.orphan;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.moss.fuse.integrator.custom.model.base.PersonBaseEntity;
import com.moss.fuse.integrator.custom.model.common.Governorate;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "child")
public class Child extends PersonBaseEntity {

    private String educationalLevel;

    @ManyToOne
    @JoinColumn(name = "birth_governorate_id")
    private Governorate birthGovernorate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "family_id", nullable = false)
    private Family family;

    @ManyToMany(mappedBy = "children")
    private Set<Parent> parents;

}
