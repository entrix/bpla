package org.hibernate.bpla.persistence;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.hibernate.bpla.Service;
import org.hibernate.bpla.domain.CrossDetail;
import org.hibernate.bpla.domain.DetType;
import org.hibernate.bpla.domain.Detail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: oracle
 * Date: 30.09.12
 * Time: 22:47
 * To change this template use File | Settings | File Templates.
 */

@Repository
@Transactional
public class HibernateService implements Service {

    protected final Log logger = LogFactory.getLog(getClass());

    private SessionFactory sessionFactory;

    public HibernateService() {
    }

    @Autowired
    public HibernateService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        DetailService.getDetailService().setSessionFactory(sessionFactory);
        DetTypeService.getDetTypeService().setSessionFactory(sessionFactory);
        BplaService.getBplaService().setSessionFactory(sessionFactory);
        WareHouseService.getWareHouseService().setSessionFactory(sessionFactory);
    }

    @Transactional(readOnly = true)
    public Collection<CrossDetail> getAllDetails() {
        try {
            DetailService.getDetailService().startSession();
            List<Detail> details = DetailService.getDetailService().listDetails();
            List<CrossDetail> crossDetails = new ArrayList<CrossDetail>(details.size());
            for (Detail detail : details) {
                DetType detType = detail.getDetType();
                CrossDetail crossDetail = new CrossDetail(detail, detType);
                crossDetails.add(crossDetail);

            }
//            DetailService.getDetailService().endSession();
            return crossDetails;
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return new ArrayList<CrossDetail>();
    }

    @Transactional(readOnly = true)
    public void saveOrUpdateDetail(CrossDetail crossDetail) {
        Detail detail = new Detail();
        detail.setDetTypeId(crossDetail.getDetTypeId());
//        detail.setId(crossDetail.getId());
        detail.setState(crossDetail.getState());
        detail.setRaids(crossDetail.getRaids());
        DetType detType = new DetType();
//        detType.setId(crossDetail.getDetTypeId());
        detType.setName(crossDetail.getName());
        detType.setSize(crossDetail.getSize());
        detType.setWeight(crossDetail.getWeight());

        detail.setDetType(detType);
        detType.getDetails().add(detail);

        DetailService.getDetailService().startSession();
        DetTypeService.getDetTypeService().startSession();
        try {
            DetailService.getDetailService().addDetail(detail);
            DetTypeService.getDetTypeService().addDetType(detType);
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
//        DetailService.getDetailService().endSession();
//        DetTypeService.getDetTypeService().endSession();
    }

    @Override
    public void saveOrUpdateDetail(Detail detail) {
        try {
            DetailService.getDetailService().startSession();
            DetTypeService.getDetTypeService().startSession();
            DetType detType = DetTypeService.getDetTypeService().findDetType(detail.getDetTypeId());

            detail.setDetType(detType);
            detType.getDetails().add(detail);

            DetailService.getDetailService().addDetail(detail);
            DetTypeService.getDetTypeService().addDetType(detType);
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
//        DetailService.getDetailService().endSession();
//        DetTypeService.getDetTypeService().endSession();
    }

    @Override
    public Detail getDetailById(long id) {
        try {
            DetailService.getDetailService().startSession();
            Detail detail = DetailService.getDetailService().findDetail(id);
//            DetailService.getDetailService().endSession();
            return detail;
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return new Detail();
    }

    @Override
    public DetType getDetTypelById(long id) {
        try {
            DetTypeService.getDetTypeService().startSession();
            DetType detType = DetTypeService.getDetTypeService().findDetType(id);
//            DetailService.getDetailService().endSession();
            return detType;
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return new DetType();
    }

    @Override
    public void deleteDetail(Detail detail) {
        try {
            DetailService.getDetailService().startSession();
            DetailService.getDetailService().deleteDetail(detail);
            DetailService.getDetailService().endSession();
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
