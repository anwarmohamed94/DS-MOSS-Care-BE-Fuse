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
@Table(name = "district")
public class District extends BaseEntity {

   private String name;

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "administration_id")
   private Administration administration;

   @OneToMany(mappedBy = "district")
   private Set<Orphanage> orphanages;

}
