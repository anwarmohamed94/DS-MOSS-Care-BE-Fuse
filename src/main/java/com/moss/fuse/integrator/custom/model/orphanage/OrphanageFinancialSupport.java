package com.moss.fuse.integrator.custom.model.orphanage;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.moss.fuse.integrator.custom.enums.FinancialSupportType;
import com.moss.fuse.integrator.custom.model.base.BaseEntity;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "orphanage_financial_support")
public class OrphanageFinancialSupport extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private FinancialSupportType financialSupportType;

    private String amount;

    private String collectorName;

    private Date collectionDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orphanage_id")
    private Orphanage orphanage;

}
