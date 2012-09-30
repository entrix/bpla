package org.hibernate.bpla.domain;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: entrix
 * Date: 16.03.2012
 * Time: 23:13
 * To change this template use File | Settings | File Templates.
 */
public class DetailTests extends TestCase {
    
    private CrossDetail detail;
    
    @Before
    public void setUp() throws Exception {
        super.setUp();
        detail = new CrossDetail();
    }
    
    @Test
    public void testDetail() {
        //id
        detail.setId(-1L);
        assertNotSame("id не может быть равен -1", -1L, detail.getId());
        detail.setId(0L);
        assertEquals("нормальное значение", 0L, (Object) detail.getId());
        //state
        detail.setState("state");
        assertEquals("state", detail.getState());
        //name
        detail.setName("name");
        assertEquals("name", detail.getName());
        //size
        detail.setSize("size");
        assertEquals("size", detail.getSize());
        //raids
        detail.setRaids(1);
        assertEquals(1, (Object) detail.getRaids());
        //raids
        detail.setWeight(1);
        assertEquals(1, (Object) detail.getWeight());
        //bplas
        Set<Bpla> set = new HashSet<Bpla>(5);
        for (Long i : new Long[] {1L, 2L, 3L, 4L, 5L}) {
            set.add(new Bpla(i));
        }
    }

    @After
    public void tearDown() throws Exception {
        super.tearDown();    //To change body of overridden methods use File | Settings | File Templates.
    }
}
