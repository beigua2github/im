package com.starsea.im.biz.entity;

/**
 * Created by danny on 16/8/23.
 */

public class LabelToEnergyEntity {
    private Integer id;
    private String labelId;
    private String energyId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLabelId() {
        return labelId;
    }

    public void setLabelId(String labelId) {
        this.labelId = labelId;
    }

    public String getEnergyId() {
        return energyId;
    }

    public void setEnergyId(String energyId) {
        this.energyId = energyId;
    }
}
