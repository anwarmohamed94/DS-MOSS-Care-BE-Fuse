package com.moss.fuse.integrator.custom.model.aid;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.moss.fuse.integrator.custom.model.base.BaseEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "aid_type")
public class AidType extends BaseEntity {

  private String type;

}
