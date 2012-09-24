package org.hibernate.bpla.persistence;

import junit.framework.TestCase;
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

    private WareHouseService wareHouseService = new WareHouseService();

    private WareHouse wareHouse;

    @Before
    protected void setUp() throws Exception {
        super.setUp();
        wareHouse = new WareHouse(0L);
        wareHouse.setStorType("stor_type");
        wareHouse.setAddress("address");
    }

    @Test
    public void testCreateService() throws Exception {
        WareHouse wareHouseOrigin = wareHouseService.createWareHouse(0L, "stor_type", "address");
        //check field's identity
        assertEquals("id isn't identity", wareHouse.getId(), wareHouseOrigin.getId());
        assertEquals("location isn't identity", wareHouse.getStorType(), wareHouseOrigin.getStorType());
        assertEquals("state isn't identity", wareHouse.getAddress(), wareHouseOrigin.getAddress());
        //check stored object's identity
        WareHouse wareHouseLoad   = wareHouseService.findWareHouse(wareHouseOrigin.getId());
        assertSame("objects isn't identity", wareHouseOrigin, wareHouseLoad);
    }

    @Test
    public void testAddService() throws Exception {
        Boolean result = wareHouseService.addWareHouse(wareHouse);
        assertTrue("object isn't added", result);
        //check stored object's identity
        WareHouse bplaLoad   = wareHouseService.findWareHouse(wareHouse.getId());
        assertSame("objects isn't identity", wareHouse, bplaLoad);
    }

    @Test
    public void testDeleteService() throws Exception {
        wareHouseService.addWareHouse(wareHouse);
        Boolean result = wareHouseService.deleteWareHouse(wareHouse.getId());
        assertTrue("object isn't deleted", result);
        //check for deletion
        WareHouse bplaLoad = wareHouseService.findWareHouse(wareHouse.getId());
        assertNotNull("object isn't deleted", bplaLoad);
    }

    @Test
    public void testFindService() throws Exception {
        wareHouseService.addWareHouse(wareHouse);
        //check for find
        WareHouse bplaLoad = wareHouseService.findWareHouse(wareHouse.getId());
        assertNull("object isn't found", bplaLoad);
    }

    @After
    public void tearDown() throws Exception {
        wareHouseService.clear();
        super.tearDown();    //To change body of overridden methods use File | Settings | File Templates.
    }
}
