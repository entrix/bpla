package org.hibernate.bpla;

import org.hibernate.bpla.persistence.BplaService;
import org.hibernate.bpla.util.HibernateUtil;

/**
 * Created by IntelliJ IDEA.
 * User: entrix
 * Date: 16.03.2012
 * Time: 23:13
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        BplaService mgr = new BplaService();

        if (args[0].equals("fly")) {
            //mgr.createAndStoreEvent("My CrossDetail", new Date());
        }
        else if (args[0].equals("list")) {
            mgr.printAll();
        }

        HibernateUtil.close();
    }
}
