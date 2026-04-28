package com.constitutionhub.backendic.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "fundamental_duties")
public class FundamentalDuty {

    @Id
    private String id;

    @Column(length = 2000)
    private String dutyText;

    protected FundamentalDuty() {
    }

    public FundamentalDuty(String id, String dutyText) {
        this.id = id;
        this.dutyText = dutyText;
    }

    public String getId() { return id; }
    public String getDutyText() { return dutyText; }
}
