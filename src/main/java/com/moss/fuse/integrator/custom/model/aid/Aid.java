package com.moss.fuse.integrator.custom.model.aid;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.moss.fuse.integrator.custom.model.base.BaseEntity;
import com.moss.fuse.integrator.custom.model.orphan.Orphan;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "aid")
public class Aid extends BaseEntity {

  private String description;

  private String amount;

  private Integer bankAccountNumber;

  private String aidType;

  @ManyToMany(mappedBy = "aids")
  private Set<Orphan> orphans = new HashSet<>();

  @ManyToOne
  @JoinColumn(name = "request_id")
  private AidRequest aidRequest;

}
