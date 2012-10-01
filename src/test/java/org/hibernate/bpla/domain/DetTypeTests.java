package org.hibernate.bpla.domain;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: oracle
 * Date: 30.09.12
 * Time: 23:19
 * To change this template use File | Settings | File Templates.
 */
public class DetTypeTests extends TestCase {

    private DetType detType;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        detType = new DetType();
    }

    @Test
    public void testDetail() {
        //id
        detType.setId(-1L);
        assertNotSame("id не может быть равен -1", -1L, detType.getId());
        detType.setId(0L);
        assertEquals("нормальное значение", 0L, (Object) detType.getId());
        //name
        detType.setName("name");
        assertEquals("name", detType.getName());
        //size
        detType.setSize("size");
        assertEquals("size", detType.getSize());
        //weight
        detType.setWeight(1);
        assertEquals(1, (Object) detType.getWeight());
        //bplas
        Set<Detail> set = new HashSet<Detail>(5);
        for (Long i : new Long[] {1L, 2L, 3L, 4L, 5L}) {
            set.add(new Detail(i));
        }
        detType.setDetails(set);
        assertEquals("условие вхождения", true, set.containsAll(detType.getDetails()));
        detType.getDetails().removeAll(set);
        assertEquals("условие неизбыточности", true, detType.getDetails().isEmpty());
    }

    @After
    public void tearDown() throws Exception {
        super.tearDown();    //To change body of overridden methods use File | Settings | File Templates.
    }
}
