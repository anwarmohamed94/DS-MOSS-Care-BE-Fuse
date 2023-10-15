package com.moss.fuse.integrator.custom.model.common;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.moss.fuse.integrator.custom.model.base.BaseEntity;
import com.moss.fuse.integrator.custom.model.orphanage.Orphanage;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "directorate")
public class Directorate extends BaseEntity {

    private String name;

    @OneToMany(mappedBy = "directorate")
    private Set<Administration> administrations;

    @OneToMany(mappedBy = "directorate")
    private Set<Association> assosiations;

    @OneToMany(mappedBy = "directorate")
    private Set<Orphanage> orphanages;

}
