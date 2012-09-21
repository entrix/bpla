package org.hibernate.bpla.domain;

/**
 * Created by IntelliJ IDEA.
 * User: entrix
 * Date: 16.03.2012
 * Time: 23:13
 * To change this template use File | Settings | File Templates.
 */
public class WareHouse {
    private Long id;
    private String storType;
    private String address;


    public WareHouse() {
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStorType() {

        return storType;
    }

    public void setStorType(String storType) {
        this.storType = storType;
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
