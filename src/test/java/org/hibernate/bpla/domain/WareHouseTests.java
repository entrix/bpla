package org.hibernate.bpla.domain;

import junit.framework.TestCase;
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
public class WareHouseTests extends TestCase {
    private WareHouse wareHouse;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        wareHouse = new WareHouse();
    }

    @Test
    public void testDetail() {
        //id
        wareHouse.setId(-1L);
        assertNotSame("id не может быть равен -1", -1L, wareHouse.getId());
        wareHouse.setId(0L);
        assertEquals("нормальное значение", 0L, (Object) wareHouse.getId());
        //state
        wareHouse.setStorType("stor_type");
        assertEquals("stor_type", wareHouse.getStorType());
        //name
        wareHouse.setAddress("address");
        assertEquals("address", wareHouse.getAddress());
    }

    @After
    public void tearDown() throws Exception {
        super.tearDown();    //To change body of overridden methods use File | Settings | File Templates.
    }
}
