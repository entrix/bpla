package org.hibernate.bpla.domain;

import javax.persistence.*;

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
public class SubDetType {

    private Long    detTypeId;

    private String  name;
    private Integer weight;
    private String  size;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ")
    @Column(name = "det_type_id")
    public Long getDetTypeId() {
        return detTypeId;
    }

    public void setDetTypeId(Long detTypeId) {
        this.detTypeId = detTypeId;
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
