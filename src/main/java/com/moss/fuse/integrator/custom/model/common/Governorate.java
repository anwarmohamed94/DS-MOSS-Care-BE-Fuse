package com.moss.fuse.integrator.custom.model.common;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.moss.fuse.integrator.custom.model.base.BaseEntity;
import com.moss.fuse.integrator.custom.model.orphan.Child;
import com.moss.fuse.integrator.custom.model.orphan.FamilyHousingDetails;
import com.moss.fuse.integrator.custom.model.orphan.Orphan;
import com.moss.fuse.integrator.custom.model.orphan.Parent;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "governorate")
public class Governorate extends BaseEntity {

  private String name;

  @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "governorate")
  private Set<FamilyHousingDetails> familyHousingDetails;


  @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "birthGovernorate")
  private Set<Orphan> orphansBirthGovernorate;

  @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "foundGovernorate")
  private Set<Orphan> orphansFoundGovernorate;

  @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "birthGovernorate")
  private Set<Child> children;

  @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "birthGovernorate")
  private Set<Parent> parents;
}
