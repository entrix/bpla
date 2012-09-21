package org.hibernate.bpla.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: entrix
 * Date: 16.03.2012
 * Time: 23:13
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table(name = "BPLA")
public class Bpla {
    private Long id;

    private String state;
    private String location;
    private Set details = new HashSet();

    public Bpla() {
    }


    public Set getDetails() {
        return details;
    }

    public void setDetails(Set details) {
        this.details = details;
    }

    public String getLocation() {

        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getState() {

        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
