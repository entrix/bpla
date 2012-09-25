package org.hibernate.bpla.persistence;

import junit.framework.TestCase;
import org.hibernate.bpla.domain.Bpla;
import org.hibernate.bpla.domain.Detail;
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
        Bpla bpla = new Bpla(0L);
        bpla.setLocation("location");
        bpla.setState("state");
    }

    @Test @Ignore
    public void testCreateService() throws Exception {
        Bpla bplaOrigin = bplaService.createBpla(0L, "location", "state");
        //check field's identity
        assertEquals("id isn't identity", bpla.getId(), bplaOrigin.getId());
        assertEquals("location isn't identity", bpla.getLocation(), bplaOrigin.getLocation());
        assertEquals("state isn't identity", bpla.getState(), bplaOrigin.getState());
        //check stored object's identity
        Bpla bplaLoad   = bplaService.findBpla(bplaOrigin.getId());
        assertSame("objects isn't identity", bplaOrigin, bplaLoad);
    }

    @Test @Ignore
    public void testAddService() throws Exception {
        bplaService.addBpla(bpla);
        //check stored object's identity
        Bpla bplaLoad   = bplaService.findBpla(bpla.getId());
        assertSame("objects isn't identity", bpla, bplaLoad);
    }

    @Test @Ignore
    public void testDeleteService() throws Exception {
        bplaService.addBpla(bpla);
        bplaService.deleteBpla(bpla);
        //check for deletion
        Bpla bplaLoad = bplaService.findBpla(bpla.getId());
        assertNotNull("object isn't deleted", bplaLoad);
    }

    @Test @Ignore
    public void testFindService() throws Exception {
        bplaService.addBpla(bpla);
        //check for find
        Bpla bplaLoad = bplaService.findBpla(bpla.getId());
        assertNull("object isn't found", bplaLoad);
    }

    @Test @Ignore
    public void testAddBplaDetailService() throws Exception {
        Detail detail = new Detail(0L);
        DetailService detailService = DetailService.getDetailService();
        detailService.addDetail(detail);
        if (bplaService == null) {
            System.out.println("0");
        }
        if (bpla == null) {
            System.out.println("1");
        }
        if (detail == null) {
            System.out.println("2");
        }
        System.out.println("10");
        bplaService.addBplaDetail(bpla.getId(), detail.getId());
        //check for binding
        Bpla bplaLoad     = bplaService.findBpla(bpla.getId());
        Detail detailLoad = detailService.findDetail(detail.getId());
        //assertSame("binded objects not same", detail, bplaLoad.getDetails().toArray(new Bpla[0])[0]);
        //assertSame("binded objects not same", bpla, detailLoad.getBplas().toArray(new Detail[0])[0]);
        assertTrue("binded objects not same", bplaLoad.getDetails().contains(detail));
        assertTrue("binded objects not same", detailLoad.getBplas().contains(bpla));
    }

    @Test
    public void testPrintService() throws Exception {
        bplaService.printAll();
    }

    @After
    public void tearDown() throws Exception {
        super.tearDown();    //To change body of overridden methods use File | Settings | File Templates.
    }
}
