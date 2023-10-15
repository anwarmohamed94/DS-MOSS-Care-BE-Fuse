package com.moss.fuse.integrator.custom.model.orphanage;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.moss.fuse.integrator.custom.model.base.BaseEntity;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "orphanage_expenses")
public class OrphanageExpenses extends BaseEntity {

    private Integer fiscalYear;

    private String expensesSourceType;

    private String amount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orphanage_id")
    private Orphanage orphanage;

}
