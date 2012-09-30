package org.hibernate.bpla.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: oracle
 * Date: 30.09.12
 * Time: 21:37
 * To change this template use File | Settings | File Templates.
 */

@SequenceGenerator(name="SEQ", sequenceName = "SEQ")

@Entity
@Table(name = "detail")
public class Detail {

    private Long    id;

    private Long    detTypeId;
    private String  state;
    private Integer raids;

    private DetType detType;

    public Detail() {
    }

    public Detail(Long id, String state, Integer raids) {
        this.id = id;
        this.state = state;
        this.raids = raids;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ")
    @Column(name = "det_id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "det_type_id")
    public Long getDetTypeId() {
        return detTypeId;
    }

    public void setDetTypeId(Long detTypeId) {
        this.detTypeId = detTypeId;
    }

    @Column(name = "state")
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Column(name = "raids")
    public Integer getRaids() {
        return raids;
    }

    public void setRaids(Integer raids) {
        this.raids = raids;
    }


    @ManyToOne(targetEntity = DetType.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="det_type_id", insertable=false, updatable=false)
    public DetType getDetType() {
        return detType;
    }

    public void setDetType(DetType detType) {
        this.detType = detType;
    }
}
