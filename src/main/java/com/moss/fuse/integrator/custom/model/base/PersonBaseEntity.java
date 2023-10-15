package com.moss.fuse.integrator.custom.model.base;


import java.util.Date;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;

import com.moss.fuse.integrator.custom.enums.Gender;
import com.moss.fuse.integrator.custom.enums.SocialStatus;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public class PersonBaseEntity extends BaseEntity {

  private String nationality;

  private Integer insuranceNumber;

  @Enumerated(EnumType.STRING)
  private Gender gender;

  private Date birthday;

  private String religion;

  private String name;

  private String leakageReason;

  private String notJoiningReason;

  @Enumerated(EnumType.STRING)
  private SocialStatus socialStatus;

  private String occupation;

  private String occupationSalary;

  private String propertyIncomeValue;

  private String businessIncomeValue;

  private Boolean hasOtherIncomeOption;

  private String otherIncomeOptionNames;

  private String otherIncomeOptionValue;

  private String phone;

  private String email;

  private Boolean isDeathOccurred;

  private Date deathDate;

}
