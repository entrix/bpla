package org.hibernate.bpla.util;

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
public class HibernateUtilTests extends TestCase {

    private HibernateUtil hibernateUtil;

    @Before
    public void setUp() throws Exception {
        super.setUp();    //To change body of overridden methods use File | Settings | File Templates.
        hibernateUtil = new HibernateUtil();
    }

    @Test
    public void testSessions() throws Exception {
        //check session for validity
        assertNotNull("must be not null", hibernateUtil.getSession());
        //check session for uniqueness
        assertNotSame("must be unique", hibernateUtil.getSession(), hibernateUtil.getSession());
        //check session for consistency
        hibernateUtil.close();
        assertNull("must be null", hibernateUtil.getSession());
    }

    @After
    public void tearDown() throws Exception {
        super.tearDown();    //To change body of overridden methods use File | Settings | File Templates.
    }
}
