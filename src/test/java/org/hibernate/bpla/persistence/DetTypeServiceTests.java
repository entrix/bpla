package org.hibernate.bpla.persistence;

import junit.framework.TestCase;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.bpla.domain.DetType;
import org.hibernate.bpla.domain.Detail;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: oracle
 * Date: 30.09.12
 * Time: 21:16
 * To change this template use File | Settings | File Templates.
 */
public class DetTypeServiceTests extends TestCase {

    private DetTypeService detTypeService = DetTypeService.getDetTypeService();

    private DetType detType;

    @Before
    public void setUp() throws Exception {
        super.setUp();    //To change body of overridden methods use File | Settings | File Templates.
        detType = new DetType();
//        detType.setDetTypeId(1L);
//        detType.setRaids(2);
        detType.setWeight(2);
        detType.setName("name");
//        detType.setState("state");
        detType.setSize("size");
        DetTypeService.getDetTypeService().startSession();
    }

    @Test
    public void testCreateService() throws Exception {
        DetType detTypeOrigin = detTypeService.createDetType(1L, "name", 2, "size");
        //check field's identity
//        assertEquals("id isn't identity", detail.getId(), detailOrigin.getId());
//        assertEquals("detTypeId isn't identity", detail.getDetTypeId(), detailOrigin.getDetTypeId());
        assertEquals("state isn't identity", detType.getName(), detTypeOrigin.getName());
//        assertEquals("raids isn't identity", detail.getRaids(), detailOrigin.getRaids());
        assertEquals("weight isn't identity", detType.getWeight(), detTypeOrigin.getWeight());
//        assertEquals("state isn't identity", detail.getState(), detailOrigin.getState());
        assertEquals("size isn't identity", detType.getSize(), detTypeOrigin.getSize());
        //check stored object's identity
        DetType detTypeLoad   = detTypeService.findDetType(detTypeOrigin.getId());
        assertEquals("id isn't identity", detTypeOrigin.getId(), detTypeLoad.getId());
//        assertEquals("detTypeId isn't identity", detailOrigin.getDetTypeId(), detailLoad.getDetTypeId());
        assertEquals("state isn't identity", detTypeOrigin.getName(), detTypeLoad.getName());
//        assertEquals("raids isn't identity", detailOrigin.getRaids(), detailLoad.getRaids());
        assertEquals("weight isn't identity", detTypeOrigin.getWeight(), detTypeLoad.getWeight());
//        assertEquals("state isn't identity", detailOrigin.getState(), detailLoad.getState());
        assertEquals("size isn't identity", detTypeOrigin.getSize(), detTypeLoad.getSize());
    }

    @Test
    public void testAddService() throws Exception {
        detTypeService.addDetType(detType);
        //check stored object's identity
        DetType detTypeLoad   = detTypeService.findDetType(detType.getId());
        assertEquals("id isn't identity", detType.getId(), detTypeLoad.getId());
//        assertEquals("detTypeId isn't identity", detail.getDetTypeId(), detailLoad.getDetTypeId());
        assertEquals("state isn't identity", detType.getName(), detTypeLoad.getName());
//        assertEquals("raids isn't identity", detail.getRaids(), detailLoad.getRaids());
        assertEquals("weight isn't identity", detType.getWeight(), detTypeLoad.getWeight());
//        assertEquals("state isn't identity", detail.getState(), detailLoad.getState());
        assertEquals("size isn't identity", detType.getSize(), detTypeLoad.getSize());
    }

    @Test
    public void testDeleteService() throws Exception {
        detTypeService.addDetType(detType);
        detTypeService.deleteDetType(detType);
        //check for deletion
        DetType detTypeLoad = detTypeService.findDetType(detType.getId());
        try {
            if (detTypeLoad != null) {
//                assertNotSame("detTypeId isn't identity", detail.getDetTypeId(), detailLoad.getDetTypeId());
                assertNotSame("state isn't identity", detType.getName(), detTypeLoad.getName());
//                assertNotSame("raids isn't identity", detail.getRaids(), detailLoad.getRaids());
                assertNotSame("weight isn't identity", detType.getWeight(), detTypeLoad.getWeight());
//                assertNotSame("state isn't identity", detail.getState(), detailLoad.getState());
                assertNotSame("size isn't identity", detType.getSize(), detTypeLoad.getSize());
                throw new Exception();
            }

        } catch (ObjectNotFoundException e) {

        }
    }

    @Test
    public void testFindService() throws Exception {
        detTypeService.addDetType(detType);
        //check for find
        DetType detTypeLoad = detTypeService.findDetType(detType.getId());
        assertNotNull("object isn't found", detTypeLoad);
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
        DetTypeService.getDetTypeService().printAll();
    }

    @After
    public void tearDown() throws Exception {
        DetTypeService.getDetTypeService().endSession();
        super.tearDown();    //To change body of overridden methods use File | Settings | File Templates.
    }
}
