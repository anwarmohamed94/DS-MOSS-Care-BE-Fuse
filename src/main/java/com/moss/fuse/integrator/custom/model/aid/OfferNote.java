package com.moss.fuse.integrator.custom.model.aid;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.moss.fuse.integrator.custom.model.base.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "offer_note")
public class OfferNote extends BaseEntity {

  @Column(name = "source")
  private String from;

  @Column(name = "target")
  private String to;

  private String offer;

  private String subject;

  private String requirement;

  @OneToOne(fetch = FetchType.LAZY,mappedBy = "offerNote")
  private AidRequest aidRequest;

}
