package org.hibernate.bpla.persistence;

import org.hibernate.Session;
import org.hibernate.bpla.domain.Detail;
import org.hibernate.bpla.util.HibernateUtil;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: entrix
 * Date: 16.03.2012
 * Time: 23:13
 * To change this template use File | Settings | File Templates.
 */
public class DetailService {

    public DetailService() {
    }

    public Detail createDetail(Long id, Long detTypeId, String name, Integer raids, Integer weight, String state, String size) {
        return null;
    }

    public boolean addDetail(Detail detail) {
        return false;
    }

    public boolean deleteDetail(Long id) {
        return false;
    }
    
    public Detail findDetail(Long id) {
        return null;
    }

    public List<Detail> listDetails() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        List result = session.createQuery("from Detail").list();
        session.getTransaction().commit();
        return result;
    }

    public boolean addDetailBpla(Long detailId, Long id) {
        return false;
    }

    public boolean clear() {
        return false;
    }

    public void printAll() {
        
    }
}
