package com.moss.fuse.integrator.custom.model.orphan;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.moss.fuse.integrator.custom.model.base.BaseEntity;
import com.moss.fuse.integrator.custom.model.common.Country;
import com.moss.fuse.integrator.custom.model.common.Governorate;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "family_housing_details")
public class FamilyHousingDetails extends BaseEntity {


    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @ManyToOne
    @JoinColumn(name = "governorate_id")
    private Governorate governorate;

    private String address;

    private String geographicEnvironment;

    private String housingOwnership;

    private String telephone;

    private String mobileNumber;

    private String houseOwnershipContract;

    @OneToOne(mappedBy = "familyHousingDetails")
    private Family family;

}
