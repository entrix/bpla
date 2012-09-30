package org.hibernate.bpla.persistence;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.bpla.domain.Bpla;
import org.hibernate.bpla.domain.DetType;
import org.hibernate.bpla.domain.DetType;
import org.hibernate.bpla.domain.Detail;
import org.hibernate.bpla.util.HibernateUtil;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: oracle
 * Date: 30.09.12
 * Time: 21:09
 * To change this template use File | Settings | File Templates.
 */
public class DetTypeService {
    private static DetTypeService detTypeService = null;

    private Session session;

    static {
        detTypeService = new DetTypeService();
    }

    public static DetTypeService getDetTypeService() {
        return detTypeService;
    }

    public DetType createDetType(Long id, String name, Integer weight, String size) throws Exception {
        DetType detType = new DetType();
        detType.setId(id);
        detType.setWeight(weight);
        detType.setName(name);
        detType.setSize(size);
        return (DetType) utilObject(0, detType);
    }

    public void addDetType(DetType detType) throws Exception {
        utilObject(0, detType);
    }

    public void deleteDetType(DetType detType) throws Exception {
        utilObject(2, detType);
    }

    public DetType findDetType(Long id) throws Exception {
        return (DetType) utilObject(1, id);
    }

//    public DetType findDetType(Long id) throws Exception {
//        return (DetType) utilObject(5, id);
//    }

    public List<DetType> listDetTypes() throws Exception {
        return (List<DetType>) utilObject(3, null);
    }

    public void addDetail(Long detId, Long id) throws Exception {
        DetType detType = findDetType(id);
        Detail detail = DetailService.getDetailService().findDetail(detId);
        if (!detType.getDetails().contains(detail)) {
            detType.getDetails().add(detail);
        }
    }

    public void printAll() throws Exception {
        List<DetType> detTypes = listDetTypes();
        for (int i = 0; i < detTypes.size(); i++) {
            DetType detType = detTypes.get(i);
            System.out.println("DetType: " + detType.getName());
            for (Object objExt : detType.getDetails()) {
                System.out.println("    Raids:" + ((Detail) objExt).getRaids());
                System.out.println("    State:" + ((Detail) objExt).getState());
            }
        }
    }

    public void startSession() {
        session = HibernateUtil.getSession();
    }

    public void endSession() {
        session.close();
    }

    /**
     * 0 - saveOrUpdate
     * 1 - load
     * 2 - delete
     * 3 - from DetType ib HQL
     * @param object - DetType or Long (DetType.getId())
     * @param operation
     * @throws Exception
     */
    public Object utilObject(Integer operation, Object object) throws Exception {
        Object result = null;
        Transaction tx = null;
        DetType detType = new DetType();
        try {
            tx = session.beginTransaction();
            switch (operation) {
                case 0:
                    Boolean isNull = false;
                    detType = (DetType) object;
                    try {
                        session.createQuery("select det_id from DetType where det_id = :detId")
                                .setLong("detId", detType.getId());
                    }
                    catch (Exception e) {
                        isNull = true;
                    }

                    if (!isNull) {
                        detType.setId(detType.getId());
                    }
                    detType.setName(detType.getName());
                    detType.setWeight(detType.getWeight());
                    detType.setSize(detType.getSize());

                    session.saveOrUpdate(detType);
                    result = detType;
                    break;
                case 1:
                    result = (DetType) session.load(DetType.class, (Long) object);
                    break;
                case 2:
                    detType = (DetType) object;
                    session.delete(session.load(DetType.class, detType.getId()));
                    break;
                case 3:
                    result = session.createQuery("from DetType").list();
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
        return result;
    }
}
