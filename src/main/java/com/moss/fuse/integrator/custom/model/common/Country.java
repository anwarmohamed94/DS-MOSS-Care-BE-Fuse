package com.moss.fuse.integrator.custom.model.common;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.moss.fuse.integrator.custom.model.base.BaseEntity;
import com.moss.fuse.integrator.custom.model.orphan.FamilyHousingDetails;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "country")
public class Country extends BaseEntity {

  private String name;

  @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "country")
  private Set<FamilyHousingDetails> familyHousingDetails;

}
