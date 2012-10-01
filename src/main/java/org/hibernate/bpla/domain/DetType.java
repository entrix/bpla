package org.hibernate.bpla.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: oracle
 * Date: 29.09.12
 * Time: 18:42
 * To change this template use File | Settings | File Templates.
 */

@SequenceGenerator(name="SEQ", sequenceName = "SEQ")

@Entity
@Table(name = "det_type")
public class DetType {

    private Long    id;

    private String  name;
    private Integer weight;
    private String  size;

    private Set<Detail> details = new HashSet();

    public DetType() {
    }

    public DetType(Long id) {
        this.id = id;
    }

    public DetType(Long id, String name, Integer weight, String size) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.size = size;
    }

    @OneToMany(mappedBy = "detType", fetch = FetchType.EAGER)
    public Set<Detail> getDetails() {
        return details;
    }

    public void setDetails(Set<Detail> details) {
        this.details = details;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ")
    @Column(name = "det_type_id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "det_name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "det_weight")
    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Column(name = "det_size")
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
