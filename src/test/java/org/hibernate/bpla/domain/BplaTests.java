package org.hibernate.bpla.domain;

import junit.framework.TestCase;

import java.util.HashSet;
import java.util.Set;

public class BplaTests extends TestCase {

    private Bpla bpla;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        bpla = new Bpla();
    }

    public void testMethods() throws Exception {
        //id
        bpla.setId(-1L);
        assertNotSame("id не может быть равен -1", -1L, bpla.getId());
        bpla.setId(0L);
        assertEquals("нормальное значение", 0L, (Object) bpla.getId());
        //state
        bpla.setState("state");
        assertEquals("state", bpla.getState());
        //location
        bpla.setLocation("location");
        assertEquals("location", bpla.getLocation());
        //points
        Set<Detail> set = new HashSet<Detail>(5);
        for (Long i : new Long[] {1L, 2L, 3L, 4L, 5L}) {
            set.add(new Detail(i));
        }
        bpla.setDetails(set);
        assertEquals("условие вхождения", true, set.containsAll(bpla.getDetails()));
        bpla.getDetails().removeAll(set);
        assertEquals("условие неизбыточности", true, bpla.getDetails().isEmpty());
    }

    @Override
    public void tearDown() throws Exception {
        super.tearDown();    //To change body of overridden methods use File | Settings | File Templates.
    }
}