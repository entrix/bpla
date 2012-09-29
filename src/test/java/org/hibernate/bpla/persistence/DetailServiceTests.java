package org.hibernate.bpla.persistence;

import junit.framework.TestCase;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.bpla.domain.Bpla;
import org.hibernate.bpla.domain.Detail;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: entrix
 * Date: 16.03.2012
 * Time: 23:13
 * To change this template use File | Settings | File Templates.
 */
public class DetailServiceTests extends TestCase {

    private DetailService detailService = DetailService.getDetailService();

    private Detail detail;

    @Before
    public void setUp() throws Exception {
        super.setUp();    //To change body of overridden methods use File | Settings | File Templates.
        detail = new Detail();
        detail.setDetTypeId(1L);
        detail.setRaids(2);
        detail.setWeight(3);
        detail.setName("name");
        detail.setState("state");
        detail.setSize("size");
        DetailService.getDetailService().startSession();
    }

    @Test
    public void testCreateService() throws Exception {
        Detail detailOrigin = detailService.createDetail(0L, 1L, "name", 2, 3, "state", "size");
        //check field's identity
//        assertEquals("id isn't identity", detail.getId(), detailOrigin.getId());
//        assertEquals("detTypeId isn't identity", detail.getDetTypeId(), detailOrigin.getDetTypeId());
        assertEquals("state isn't identity", detail.getName(), detailOrigin.getName());
        assertEquals("raids isn't identity", detail.getRaids(), detailOrigin.getRaids());
        assertEquals("weight isn't identity", detail.getWeight(), detailOrigin.getWeight());
        assertEquals("state isn't identity", detail.getState(), detailOrigin.getState());
        assertEquals("size isn't identity", detail.getSize(), detailOrigin.getSize());
        //check stored object's identity
        Detail detailLoad   = detailService.findDetail(detailOrigin.getId(), detailOrigin.getDetTypeId());
        assertEquals("id isn't identity", detailOrigin.getId(), detailLoad.getId());
        assertEquals("detTypeId isn't identity", detailOrigin.getDetTypeId(), detailLoad.getDetTypeId());
        assertEquals("state isn't identity", detailOrigin.getName(), detailLoad.getName());
        assertEquals("raids isn't identity", detailOrigin.getRaids(), detailLoad.getRaids());
        assertEquals("weight isn't identity", detailOrigin.getWeight(), detailLoad.getWeight());
        assertEquals("state isn't identity", detailOrigin.getState(), detailLoad.getState());
        assertEquals("size isn't identity", detailOrigin.getSize(), detailLoad.getSize());
    }

    @Test
    public void testAddService() throws Exception {
        detailService.addDetail(detail);
        //check stored object's identity
        Detail detailLoad   = detailService.findDetail(detail.getId(), detail.getDetTypeId());
        assertEquals("id isn't identity", detail.getId(), detailLoad.getId());
        assertEquals("detTypeId isn't identity", detail.getDetTypeId(), detailLoad.getDetTypeId());
        assertEquals("state isn't identity", detail.getName(), detailLoad.getName());
        assertEquals("raids isn't identity", detail.getRaids(), detailLoad.getRaids());
        assertEquals("weight isn't identity", detail.getWeight(), detailLoad.getWeight());
        assertEquals("state isn't identity", detail.getState(), detailLoad.getState());
        assertEquals("size isn't identity", detail.getSize(), detailLoad.getSize());
    }

    @Test
    public void testDeleteService() throws Exception {
        detailService.addDetail(detail);
        detailService.deleteDetail(detail);
        //check for deletion
        Detail detailLoad = detailService.findDetail(detail.getId(), detail.getDetTypeId());
        try {
            if (detailLoad != null) {
                assertNotSame("detTypeId isn't identity", detail.getDetTypeId(), detailLoad.getDetTypeId());
                assertNotSame("state isn't identity", detail.getName(), detailLoad.getName());
                assertNotSame("raids isn't identity", detail.getRaids(), detailLoad.getRaids());
                assertNotSame("weight isn't identity", detail.getWeight(), detailLoad.getWeight());
                assertNotSame("state isn't identity", detail.getState(), detailLoad.getState());
                assertNotSame("size isn't identity", detail.getSize(), detailLoad.getSize());
                throw new Exception();
            }

        } catch (ObjectNotFoundException e) {

        }
    }

    @Test
    public void testFindService() throws Exception {
        detailService.addDetail(detail);
        //check for find
        Detail detailLoad = detailService.findDetail(detail.getId(), detail.getDetTypeId());
        assertNotNull("object isn't found", detailLoad);
    }

//    @Test
//    public void testAddBplaDetailService() throws Exception {
//        Bpla bpla = new Bpla();
//        BplaService bplaService = BplaService.getBplaService();
//        bplaService.startSession();
//        bpla.setLocation("location");
//        bpla.setState("state");
//        bplaService.addBpla(bpla);
//        detailService.addDetail(detail);
//        detailService.addDetailBpla(bpla.getId(), detail.getId(), detail.getDetTypeId());
//        //check for binding
//        Detail detailLoad = detailService.findDetail(detail.getId(), detail.getDetTypeId());
//        Bpla bplaLoad     = bplaService.findBpla(bpla.getId());
//        //assertSame("binded objects not same", bpla, detailLoad.getBplas().toArray(new Detail[0])[0]);
//        //assertSame("binded objects not same", detail, bplaLoad.getDetails().toArray(new Bpla[0])[0]);
//        System.out.println("------> " + bplaLoad.getDetails().contains(detail));
//        System.out.println("------> " + detailLoad.getBplas().contains(bpla));
//        assertTrue("binded objects not same", detailLoad.getBplas().contains(bpla));
//        assertTrue("binded objects not same", bplaLoad.getDetails().contains(detail));
//    }

    @Test
    public void testPrintService() throws Exception {
        DetailService.getDetailService().printAll();
    }

    @After
    public void tearDown() throws Exception {
        DetailService.getDetailService().endSession();
        super.tearDown();    //To change body of overridden methods use File | Settings | File Templates.
    }
}
