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
@Table(name = "detail")
public class SubDetail {

    private Long id;

    private Long    detTypeId;
    private String  state;
    private Integer raids;

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

    @Column
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Column
    public Integer getRaids() {
        return raids;
    }

    public void setRaids(Integer raids) {
        this.raids = raids;
    }
}
