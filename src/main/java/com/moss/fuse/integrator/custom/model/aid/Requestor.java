package com.moss.fuse.integrator.custom.model.aid;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.moss.fuse.integrator.custom.model.base.BaseEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "requestor")
public class Requestor extends BaseEntity {

  private String name;

  private String phoneNumber;

  private String requestorType;

  @OneToMany(cascade = CascadeType.ALL,mappedBy = "requestor")
  private List<AidRequest> aidRequests;



}
