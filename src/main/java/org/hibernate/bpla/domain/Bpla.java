package org.hibernate.bpla.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: entrix
 * Date: 16.03.2012
 * Time: 23:13
 * To change this template use File | Settings | File Templates.
 */

@SequenceGenerator(name="SEQ", sequenceName = "SEQ")

@Entity
@Table(name = "bpla")
public class Bpla {
    private Long id;

    private String state;
    private String location;
    private Set<Detail> details = new HashSet();

    public Bpla() {
    }
    
    public Bpla(Long id) {
        this.setId(id);
    }

    public Bpla(Long id, String state, String location) {
        this.id = id;
        this.state = state;
        this.location = location;
    }

    @ManyToMany(targetEntity = Detail.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name="aggregate",
            joinColumns=
            @JoinColumn(name="bpla_id", referencedColumnName="bpla_id"),
            inverseJoinColumns=
            @JoinColumn(name="det_id", referencedColumnName="det_id")
    )
    public Set<Detail> getDetails() {
        return details;
    }

    public void setDetails(Set<Detail> details) {
        this.details = details;
    }

    @Column(name = "location")
    public String getLocation() {

        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Column(name = "state")
    public String getState() {

        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ")
    @Column(name = "bpla_id")
    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        if (id < 0) {
            //value is not possible
            return;
        }

        this.id = id;
    }

    @Override
    public String toString() {
        return this.getId() + "\n" +
                this.getLocation() + "\n" +
                this.getState() + "\n" +
                this.getDetails() + "\n";
    }

    public void setNullId() {
        this.id = null;
    }
}
