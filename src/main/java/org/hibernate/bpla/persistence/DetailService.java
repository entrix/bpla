package org.hibernate.bpla.persistence;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.bpla.domain.Bpla;
import org.hibernate.bpla.domain.Detail;
import org.hibernate.bpla.domain.DetType;
import org.hibernate.bpla.util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: entrix
 * Date: 16.03.2012
 * Time: 23:13
 * To change this template use File | Settings | File Templates.
 */
public class DetailService {

    private static DetailService detailService = null;

    private Session session;

    static {
        detailService = new DetailService();
    }

    public static DetailService getDetailService() {
        return detailService;
    }

    public Detail createDetail(Long id, Long detTypeId, String name, Integer raids, Integer weight, String state, String size) throws Exception {
        Detail detail = new Detail();
        detail.setDetTypeId(detTypeId);
        detail.setRaids(raids);

//        detail.setWeight(weight);
//        detail.setName(name);
        detail.setState(state);
//        detail.setSize(size);
        return (Detail) utilObject(0, detail);
    }

    public void addDetail(Detail detail) throws Exception {
        utilObject(0, detail);
    }

    public void deleteDetail(Detail detail) throws Exception {
        utilObject(2, detail);
    }

    public Detail findDetail(Long id) throws Exception {
        return (Detail) utilObject(1, id);
    }

    public List<Detail> listDetails() throws Exception {
        return (List<Detail>) utilObject(3, null);
    }

    public void addDetailBpla(Long bplaId, Long id) throws Exception {
        Detail detail = findDetail(id);
        Bpla bpla = BplaService.getBplaService().findBpla(bplaId);
        if (!bpla.getDetails().contains(detail)) {
            bpla.getDetails().add(detail);
        }
    }

    public void printAll() throws Exception {
        List<Detail> details = listDetails();
        for (int i = 0; i < details.size(); i++) {
            Detail detail = details.get(i);
            System.out.println("Detail: " + detail.getDetType().getName());
//            for (Object objExt : detail.getBplas()) {
//                System.out.println("    Location:" + ((Bpla) objExt).getLocation());
//                System.out.println("    State   :" + ((Bpla) objExt).getState());
//            }
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
     * 3 - from Detail ib HQL
     * @param object - Detail or Long (Detail.getId())
     * @param operation
     * @throws Exception
     */
    public Object utilObject(Integer operation, Object object) throws Exception {
        Object result = null;
        Transaction tx = null;
        Detail detail = new Detail();
        DetType detType = new DetType();
        try {
            tx = session.beginTransaction();
            switch (operation) {
                case 0:
                    Boolean isNull = false;
                    detail = (Detail) object;
                    try {
                        session.createQuery("select det_id from Detail where det_id = :detId")
                                .setLong("detId", detail.getId());
                    }
                    catch (Exception e) {
                        isNull = true;
                    }

                    if (!isNull) {
                        detail.setId(detail.getId());
                    }
                    detail.setDetTypeId(detail.getDetTypeId());
                    detail.setRaids(detail.getRaids());
                    detail.setState(detail.getState());

//                    if (!isNull) {
//                        detType.setId(detail.getDetTypeId());
//                    }
//                    detType.setName(detail.getName());
//                    detType.setWeight(detail.getWeight());
//                    detType.setSize(detail.getSize());

//                    session.saveOrUpdate(detType);
                    session.saveOrUpdate(detail);
//                    detail.setId(subDetail.getId());
//                    detail.setDetTypeId(detType.getId());
                    result = detail;
                    break;
                case 1:
                    result = (Detail) session.load(Detail.class, (Long) object);
                    break;
                case 2:
                    detail = (Detail) object;
//                    subDetail.setId(detail.getId());
//                    subDetail.setDetTypeId(detail.getDetTypeId());
//                    subDetail.setRaids(detail.getRaids());
//                    subDetail.setState(detail.getState());
//
//                    detType.setId(detail.getDetTypeId());
//                    detType.setName(detail.getName());
//                    detType.setWeight(detail.getWeight());
//                    detType.setSize(detail.getSize());

                    session.delete(session.load(Detail.class, detail.getId()));
//                    session.delete(session.load(DetType.class, detail.getDetTypeId()));
                    break;
                case 3:
                    result = session.createQuery("from Detail").list();
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
