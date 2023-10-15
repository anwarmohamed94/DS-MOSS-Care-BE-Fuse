package com.moss.fuse.integrator.custom.model.orphanage;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.moss.fuse.integrator.custom.enums.BuildingConstructionDependencyType;
import com.moss.fuse.integrator.custom.enums.BuildingDependencyType;
import com.moss.fuse.integrator.custom.enums.BuildingOwnershipType;
import com.moss.fuse.integrator.custom.model.base.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "orphanage_building_data")
public class OrphanageBuildingData extends BaseEntity {


    @Enumerated(EnumType.STRING)
    private BuildingDependencyType dependencyType;

    @Enumerated(EnumType.STRING)
    private BuildingOwnershipType ownershipType;

    @Enumerated(EnumType.STRING)
    private BuildingConstructionDependencyType constructionDependencyType;

    private String otherActivities;

    private String furnitureValue;

    private String machinesValue;

    private Integer buildingsCount;

    private String totalArea;

    private String usedArea;

    private Integer branchesCount;

    private Integer bedroomsCount;

    private Integer activityRoomsCount;

    private Integer administrativeRoomsCount;

    private Boolean hasEquippedForPeopleWithSpecialNeeds;

    private Boolean hasEatingArea;

    private Boolean hasStorageArea;

    private Boolean hasRoomFurnitureEquippedForChildren;

    private Boolean hasGardenArea;

    private Boolean hasSwimmingPool;

    private Boolean hasCourt;

    private String hasTheater;

    private Boolean isDeveloped;

    private Date lastDevelopmentDate;

    private String developmentAmount;

    private String developmentAspects;


    @OneToOne(mappedBy = "orphanageBuildingData")
    private Orphanage orphanage;

}
