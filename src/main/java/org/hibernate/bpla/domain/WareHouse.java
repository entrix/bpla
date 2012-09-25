package org.hibernate.bpla.domain;

import javax.persistence.*;

/**
 * Created by IntelliJ IDEA.
 * User: entrix
 * Date: 16.03.2012
 * Time: 23:13
 * To change this template use File | Settings | File Templates.
 */

@SequenceGenerator(name="SEQ", sequenceName = "SEQ")

@Entity
@Table(name = "warehouse")
public class WareHouse {
    private Long id;
    private String storType;
    private String address;


    public WareHouse() {
    }

    public WareHouse(Long id) {
        this.id = id;
    }

    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStorType() {

        return storType;
    }

    @Column(name = "stor_type")
    public void setStorType(String storType) {
        this.storType = storType;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ")
    @Column(name = "storage_id")
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
}
