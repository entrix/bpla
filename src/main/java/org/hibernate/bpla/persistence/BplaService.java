package org.hibernate.bpla.persistence;

import org.hibernate.Session;
import org.hibernate.bpla.domain.Bpla;
import org.hibernate.bpla.domain.Detail;
import org.hibernate.bpla.util.HibernateUtil;

import java.util.List;
//import org.hibernate.bpla.util.HibernateUtil;

public class BplaService {

    public BplaService() {
    }

    public Bpla createBpla(Long id, String location, String state) {
        return null;
    }

    public boolean addBpla(Bpla bpla) {
        return false;
    }

    public boolean deleteBpla(Long id) {
        return false;
    }

    public Bpla findBpla(Long id) {
        return null;
    }
    
    private List<Bpla> listBplas() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        List result = session.createQuery("from Bpla").list();
        session.getTransaction().commit();
        return result;
    }

    public boolean addBplaDetail(Long id, Long detailId) {
        return false;
    }

    public boolean clear() {
        return false;
    }

    public void printAll() {
        List<Bpla> bplas = listBplas();
        for (int i = 0; i < bplas.size(); i++) {
            Bpla bpla = (Bpla) bplas.get(i);
            System.out.println("Bpla: " + bpla.getState());
            for (Object objExt : bpla.getDetails()) {
                System.out.println("    Detail:" + ((Detail) objExt).getName());
                System.out.println("    Size  :" + ((Detail) objExt).getSize());
            }
        }
    }
}