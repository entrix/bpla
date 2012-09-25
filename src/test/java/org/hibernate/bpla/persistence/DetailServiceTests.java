package org.hibernate.bpla.persistence;

import junit.framework.TestCase;
import org.hibernate.bpla.domain.Bpla;
import org.hibernate.bpla.domain.Detail;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
        detail = new Detail(0L);
        detail.setDetTypeId(1L);
        detail.setRaids(2);
        detail.setWeight(3);
        detail.setName("name");
        detail.setState("state");
        detail.setSize("size");
    }

    @Test
    public void testCreateService() throws Exception {
        Detail detail1Origin = detailService.createDetail(0L, 1L, "name", 2, 3, "state", "size");
        //check field's identity
        assertEquals("id isn't identity", detail.getId(), detail1Origin.getId());
        assertEquals("detTypeId isn't identity", detail.getDetTypeId(), detail1Origin.getDetTypeId());
        assertEquals("state isn't identity", detail.getName(), detail1Origin.getName());
        assertEquals("raids isn't identity", detail.getRaids(), detail1Origin.getRaids());
        assertEquals("weight isn't identity", detail.getWeight(), detail1Origin.getWeight());
        assertEquals("state isn't identity", detail.getState(), detail1Origin.getState());
        assertEquals("size isn't identity", detail.getSize(), detail1Origin.getSize());
        //check stored object's identity
        Detail detailLoad   = detailService.findDetail(detail1Origin.getId());
        assertSame("objects isn't identity", detail1Origin, detailLoad);
    }

    @Test
    public void testAddService() throws Exception {
        Boolean result = detailService.addDetail(detail);
        assertTrue("object isn't added", result);
        //check stored object's identity
        Detail detailLoad   = detailService.findDetail(detail.getId());
        assertSame("objects isn't identity", detail, detailLoad);
    }

    @Test
    public void testDeleteService() throws Exception {
        detailService.addDetail(detail);
        Boolean result = detailService.deleteDetail(detail.getId());
        assertTrue("object isn't deleted", result);
        //check for deletion
        Detail detailLoad = detailService.findDetail(detail.getId());
        assertNotNull("object isn't deleted", detailLoad);
    }

    @Test
    public void testFindService() throws Exception {
        detailService.addDetail(detail);
        //check for find
        Detail detailLoad = detailService.findDetail(detail.getId());
        assertNull("object isn't found", detailLoad);
    }

    @Test
    public void testPrintService() throws Exception {
        Bpla bpla = new Bpla(0L);
        BplaService bplaService = BplaService.getBplaService();
        bplaService.addBpla(bpla);
        Boolean result = detailService.addDetailBpla(detail.getId(), bpla.getId());
        assertTrue("objects isn't binded", result);
        //check for binding
        Detail detailLoad = detailService.findDetail(detail.getId());
        Bpla bplaLoad     = bplaService.findBpla(bpla.getId());
        //assertSame("binded objects not same", bpla, detailLoad.getBplas().toArray(new Detail[0])[0]);
        //assertSame("binded objects not same", detail, bplaLoad.getDetails().toArray(new Bpla[0])[0]);
        assertTrue("binded objects not same", detailLoad.getBplas().contains(bpla));
        assertTrue("binded objects not same", bplaLoad.getDetails().contains(detail));
    }

    @After
    public void tearDown() throws Exception {
        super.tearDown();    //To change body of overridden methods use File | Settings | File Templates.
    }
}
