package org.hibernate.bpla.persistence;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.bpla.domain.Bpla;
import org.hibernate.bpla.domain.Detail;
import org.hibernate.bpla.util.HibernateUtil;

import java.util.List;
//import org.hibernate.bpla.util.HibernateUtil;

public class BplaService {

    static BplaService bplaService = null;

    static {
        bplaService = new BplaService();
    }

    public static BplaService getBplaService() {
        return bplaService;
    }

    public Bpla createBpla(Long id, String location, String state) throws Exception {
        Bpla bpla = new Bpla(id);
        bpla.setLocation(location);
        bpla.setState(state);
        utilObject(0, bpla);
        return bpla;
    }

    public void addBpla(Bpla bpla) throws Exception {
        utilObject(0, bpla);
    }

    public void deleteBpla(Bpla bpla) throws Exception {
        utilObject(2, bpla);
    }

    public Bpla findBpla(Long id) throws Exception {
        return (Bpla) utilObject(1, id);
    }
    
    private List<Bpla> listBplas() throws Exception {
        return (List<Bpla>) utilObject(3, null);
    }

    public void addBplaDetail(Long id, Long detailId) throws Exception {
        Bpla bpla = findBpla(id);
        Detail detail = DetailService.getDetailService().findDetail(detailId);
        if (!bpla.getDetails().contains(detail)) {
            bpla.getDetails().add(detail);
        }
        if (!detail.getBplas().contains(bpla)) {
            detail.getBplas().add(bpla);
        }
    }

    public void printAll() throws Exception {
        List<Bpla> bplas = listBplas();
        for (int i = 0; i < bplas.size(); i++) {
            Bpla bpla = bplas.get(i);
            System.out.println("Bpla: " + bpla.getState());
            for (Object objExt : bpla.getDetails()) {
                System.out.println("    Detail:" + ((Detail) objExt).getName());
                System.out.println("    Size  :" + ((Detail) objExt).getSize());
            }
        }
    }

    /**
     * 0 - saveOrUpdate
     * 1 - load
     * 2 - delete
     * 3 - from Bpla ib HQL
     * @param object - Bpla or Long (Bpla.getId())
     * @param operation
     * @throws Exception
     */
    public Object utilObject(Integer operation, Object object) throws Exception {
        Object result = null;
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            switch (operation) {
                case 0:
                    session.saveOrUpdate((Bpla) object);
                    break;
                case 1:
                    result = session.load(Bpla.class, (Long) object);
                    break;
                case 2:
                    session.delete((Bpla) object);
                    break;
                case 3:
                    result = session.createQuery("from Bpla").list();
                    break;
                case 4:
                    session.clear();
                    break;
            }
            tx.commit();
        }
        catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            throw e;
        }
        finally {
            //session.close();
        }
        return result;
    }
}