package org.hibernate.bpla.persistence;

import org.hibernate.bpla.domain.WareHouse;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: entrix
 * Date: 16.03.2012
 * Time: 23:13
 * To change this template use File | Settings | File Templates.
 */
public class WareHouseService {

    static WareHouseService wareHouseService = null;

    static {
        wareHouseService = new WareHouseService();
    }

    public static WareHouseService getWareHouseService() {
        return wareHouseService;
    }

    public WareHouse createWareHouse(Long id, String storType, String address) {
        return null;
    }

    public boolean addWareHouse(WareHouse wareHouse) {
        return false;
    }

    public boolean deleteWareHouse(Long id) {
        return false;
    }

    public WareHouse findWareHouse(Long id) {
        return null;
    }

    public List<WareHouse> listWareHouses() {
        return null;
    }

    public void printAll() {

    }
}
