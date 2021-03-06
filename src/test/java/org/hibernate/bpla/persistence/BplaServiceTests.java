package org.hibernate.bpla.persistence;

import junit.framework.TestCase;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.bpla.domain.Bpla;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * User: entrix
 * Date: 16.03.2012
 * Time: 23:13
 * To change this template use File | Settings | File Templates.
 */
public class BplaServiceTests extends TestCase {

    private BplaService bplaService = BplaService.getBplaService();

    private Bpla bpla;

    @Before
    public void setUp() throws Exception {
        super.setUp();    //To change body of overridden methods use File | Settings | File Templates.
        bpla = new Bpla();
        bpla.setLocation("location");
        bpla.setState("state");
        BplaService.getBplaService().startSession();
    }

    @Test @Ignore
    public void testCreateService() throws Exception {
        Bpla bplaOrigin = bplaService.createBpla(0L, "location", "state");
        //check field's identity
        assertEquals("location isn't identity", bpla.getLocation(), bplaOrigin.getLocation());
        assertEquals("state isn't identity", bpla.getState(), bplaOrigin.getState());
        //check stored object's identity
        Bpla bplaLoad  = bplaService.findBpla(bplaOrigin.getId());
        assertEquals("id isn't identity", bplaOrigin.getId(), bplaLoad.getId());
        assertEquals("location isn't identity", bplaOrigin.getLocation(), bplaLoad.getLocation());
        assertEquals("state isn't identity", bplaOrigin.getState(), bplaLoad.getState());
    }

    @Test @Ignore
    public void testAddService() throws Exception {
        bplaService.addBpla(bpla);
        //check stored object's identity
        Bpla bplaLoad   = bplaService.findBpla(bpla.getId());
        assertEquals("id isn't identity", bplaLoad.getId(), bpla.getId());
        assertEquals("location isn't identity", bplaLoad.getLocation(), bpla.getLocation());
        assertEquals("state isn't identity", bplaLoad.getState(), bpla.getState());
    }

    @Test @Ignore
    public void testDeleteService() throws Exception {
        bplaService.addBpla(bpla);
        bplaService.deleteBpla(bpla);
        //check for deletion
        Bpla bplaLoad = bplaService.findBpla(bpla.getId());
        try {
            assertNotSame("location isn't identity", bplaLoad.getLocation(), bpla.getLocation());
            assertNotSame("state isn't identity", bplaLoad.getState(), bpla.getState());
            throw new Exception();

        } catch (ObjectNotFoundException e) {

        }
    }

    @Test @Ignore
    public void testFindService() throws Exception {
        bplaService.addBpla(bpla);
        //check for find
        Bpla bplaLoad = bplaService.findBpla(bpla.getId());
        assertNotNull("object isn't found", bplaLoad);
    }

//    @Test @Ignore
//    public void testAddBplaDetailService() throws Exception {
//        CrossDetail detail = new CrossDetail(0L);
//        detail.setDetTypeId(1L);
//        detail.setRaids(2);
//        detail.setWeight(3);
//        detail.setName("name");
//        detail.setState("state");
//        detail.setSize("size");
//        DetailService detailService = DetailService.getDetailService();
//        detailService.startSession();
//        detailService.addDetail(detail);
//        if (bplaService == null) {
//            System.out.println("0");
//        }
//        if (bpla == null) {
//            System.out.println("1");
//        }
//        if (detail == null) {
//            System.out.println("2");
//        }
//        bplaService.addBpla(bpla);
//        System.out.println("------->> " + bpla.getId());
//        bplaService.addBplaDetail(bpla.getId(), detail.getId(), detail.getDetTypeId());
//        //check for binding
//        Bpla bplaLoad     = bplaService.findBpla(bpla.getId());
//        CrossDetail detailLoad = detailService.findDetail(detail.getId(), detail.getDetTypeId());
//        //assertSame("binded objects not same", detail, bplaLoad.getDetails().toArray(new Bpla[0])[0]);
//        //assertSame("binded objects not same", bpla, detailLoad.getBplas().toArray(new CrossDetail[0])[0]);
//
//        System.out.println("------> " + bplaLoad.getDetails().contains(detail));
//        assertTrue("binded objects not same", bplaLoad.getDetails().contains(detail));
//
//    }

    @Test
    public void testPrintService() throws Exception {
        bplaService.printAll();
    }

    @After
    public void tearDown() throws Exception {
        BplaService.getBplaService().endSession();
        super.tearDown();    //To change body of overridden methods use File | Settings | File Templates.
    }
}
