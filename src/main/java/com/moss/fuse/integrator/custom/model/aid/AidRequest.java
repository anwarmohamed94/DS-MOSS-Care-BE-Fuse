package com.moss.fuse.integrator.custom.model.aid;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.moss.fuse.integrator.custom.enums.RequestStatus;
import com.moss.fuse.integrator.custom.model.base.BaseEntity;
import com.moss.fuse.integrator.custom.model.orphanage.Orphanage;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "aid_request")
public class AidRequest extends BaseEntity {

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "requestor_id")
  private Requestor requestor;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "orphanage_id")
  private Orphanage orphanage;

  @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "aidRequest")
  private List<Aid> aidList;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "offer_note_id", referencedColumnName = "id")
  private OfferNote offerNote;

  @Enumerated(EnumType.STRING)
  private RequestStatus status;

  private Boolean isApproved;

  private String rejectionReason;

  private String notes;

  private String relevantEmployee;





}
