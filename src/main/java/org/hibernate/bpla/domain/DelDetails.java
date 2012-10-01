package org.hibernate.bpla.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: oracle
 * Date: 01.10.12
 * Time: 13:18
 * To change this template use File | Settings | File Templates.
 */
public class DelDetails {
    private List<Long> deletes = new ArrayList<Long>();
    private List<Long> ids = new ArrayList<Long>();
    private List<Long> detTypeIds = new ArrayList<Long>();
    private List<String> states = new ArrayList<String>();
    private List<Double> raids = new ArrayList<Double>();

    public List<Long> getDeletes() {
        return deletes;
    }

    public void setDeletes(List<Long> deletes) {
        this.deletes = deletes;
    }

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }

    public List<Long> getDetTypeIds() {
        return detTypeIds;
    }

    public void setDetTypeIds(List<Long> detTypeIds) {
        this.detTypeIds = detTypeIds;
    }

    public List<String> getStates() {
        return states;
    }

    public void setStates(List<String> states) {
        this.states = states;
    }

    public List<Double> getRaids() {
        return raids;
    }

    public void setRaids(List<Double> raids) {
        this.raids = raids;
    }
}
