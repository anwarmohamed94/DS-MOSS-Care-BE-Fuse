package com.moss.fuse.integrator.custom.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "history_of_modifications")
public class HistoryOfModifications {

    @Id
    @Column(nullable = false, updatable = false, length = 50)
    private String date;

    @Column(nullable = false, length = 50)
    private String procedureType;

}
