package org.hibernate.bpla.persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.bpla.domain.WareHouse;
import org.hibernate.bpla.util.HibernateUtil;

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

    private Session session = null;

    private SessionFactory sessionFactory;
    static {
        wareHouseService = new WareHouseService();
    }

    public static WareHouseService getWareHouseService() {
        return wareHouseService;
    }

    public WareHouseService() {
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public WareHouse createWareHouse(Long id, String storType, String address) throws Exception {
        WareHouse wareHouse = new WareHouse();
        wareHouse.setAddress(address);
        wareHouse.setStorType(storType);
        utilObject(0, wareHouse);
        return wareHouse;
    }

    public void addWareHouse(WareHouse wareHouse) throws Exception {
        utilObject(0, wareHouse);
    }

    public void deleteWareHouse(WareHouse wareHouse) throws Exception {
        utilObject(2, wareHouse);
    }

    public WareHouse findWareHouse(Long id) throws Exception {
        return (WareHouse) utilObject(1, id);
    }

    private List<WareHouse> listWareHouses() throws Exception {
        return (List<WareHouse>) utilObject(3, null);
    }

    public void printAll() {

    }

    public void startSession() {
        session = sessionFactory.getCurrentSession();
    }

    public void endSession() {
        session.close();
    }

    public Object utilObject(Integer operation, Object object) throws Exception {
        Object result = null;
        Transaction tx = null;
//        WareHouse WareHouse = null;
        try {
//            tx = session.beginTransaction();
            switch (operation) {
                case 0:
                    session.saveOrUpdate((WareHouse) object);
                    break;
                case 1:
                    result = session.load(WareHouse.class, (Long) object);
                    break;
                case 2:
                    session.delete((WareHouse) object);
                    break;
                case 3:
                    result = session.createQuery("from WareHouse").list();
                    break;
                case 4:
                    session.clear();
                    break;
            }
//            tx.commit();
        }
        catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            throw e;
        }
        return result;
    }

}
