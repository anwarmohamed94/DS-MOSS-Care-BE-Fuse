package com.moss.fuse.integrator.custom.model.common;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.moss.fuse.integrator.custom.model.base.BaseEntity;
import com.moss.fuse.integrator.custom.model.orphanage.Orphanage;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "administration")
public class Administration extends BaseEntity {

   private String name;

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "directorate_id", nullable = false)
   private Directorate directorate;

   @OneToMany(mappedBy = "administration")
   private Set<District> districts;

   @OneToMany(mappedBy = "administration")
   private Set<Association> assosiations;

   @OneToMany(mappedBy = "administration")
   private Set<Orphanage> orphanages;

}
