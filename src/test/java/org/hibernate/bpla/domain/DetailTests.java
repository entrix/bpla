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
    
    private Detail detail;
    
    @Before
    public void setUp() throws Exception {
        super.setUp();
        detail = new Detail();
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
        //raids
        detail.setRaids(1);
        assertEquals(1, (Object) detail.getRaids());
        //bplas
        Set<Bpla> set = new HashSet<Bpla>(5);
        for (Long i : new Long[] {1L, 2L, 3L, 4L, 5L}) {
            set.add(new Bpla(i));
        }
        detail.setBplas(set);
        assertEquals("условие вхождения", true, set.containsAll(detail.getBplas()));
        detail.getBplas().removeAll(set);
        assertEquals("условие неизбыточности", true, detail.getBplas().isEmpty());
    }

    @After
    public void tearDown() throws Exception {
        super.tearDown();    //To change body of overridden methods use File | Settings | File Templates.
    }
}
