package org.hibernate.bpla.persistence;

import junit.framework.TestCase;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.bpla.domain.WareHouse;
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
public class WareHouseServiceTests extends TestCase {

    private WareHouseService wareHouseService = WareHouseService.getWareHouseService();

    private WareHouse wareHouse;

    @Before
    protected void setUp() throws Exception {
        super.setUp();
        wareHouse = new WareHouse();
        wareHouse.setStorType("stor_type");
        wareHouse.setAddress("address");
        WareHouseService.getWareHouseService().startSession();
    }

    @Test
    public void testCreateService() throws Exception {
        WareHouse wareHouseOrigin = wareHouseService.createWareHouse(0L, "stor_type", "address");
        //check field's identity
//        assertEquals("id isn't identity", wareHouse.getId(), wareHouseOrigin.getId());
        assertEquals("location isn't identity", wareHouse.getStorType(), wareHouseOrigin.getStorType());
        assertEquals("state isn't identity", wareHouse.getAddress(), wareHouseOrigin.getAddress());
        //check stored object's identity
        WareHouse wareHouseLoad   = wareHouseService.findWareHouse(wareHouseOrigin.getId());
        assertEquals("location isn't identity", wareHouseOrigin.getStorType(), wareHouseLoad.getStorType());
        assertEquals("state isn't identity", wareHouseOrigin.getAddress(), wareHouseLoad.getAddress());
    }

    @Test
    public void testAddService() throws Exception {
        wareHouseService.addWareHouse(wareHouse);
        //check stored object's identity
        WareHouse wareHouseLoad   = wareHouseService.findWareHouse(wareHouse.getId());
        assertEquals("location isn't identity", wareHouse.getStorType(), wareHouseLoad.getStorType());
        assertEquals("state isn't identity", wareHouse.getAddress(), wareHouseLoad.getAddress());
    }

    @Test
    public void testDeleteService() throws Exception {
        wareHouseService.addWareHouse(wareHouse);
        wareHouseService.deleteWareHouse(wareHouse);
        //check for deletion
        WareHouse wareHouseLoad = wareHouseService.findWareHouse(wareHouse.getId());
        try {
            assertNotSame("location isn't identity", wareHouseLoad.getAddress(), wareHouse.getAddress());
            assertNotSame("state isn't identity", wareHouseLoad.getStorType(), wareHouse.getStorType());
            throw new Exception();

        } catch (ObjectNotFoundException e) {

        }
    }

    @Test
    public void testFindService() throws Exception {
        wareHouseService.addWareHouse(wareHouse);
        //check for find
        WareHouse wareHouseLoad = wareHouseService.findWareHouse(wareHouse.getId());
        assertNotNull("object isn't found", wareHouseLoad);
    }

    @After
    public void tearDown() throws Exception {
        WareHouseService.getWareHouseService().endSession();
        super.tearDown();    //To change body of overridden methods use File | Settings | File Templates.
    }
}
