package org.hibernate.bpla.persistence;

import org.hibernate.Session;
import org.hibernate.bpla.domain.Bpla;
import org.hibernate.bpla.domain.Detail;
import org.hibernate.bpla.util.HibernateUtil;

import java.util.List;
//import org.hibernate.bpla.util.HibernateUtil;

public class BplaManager {

    public static void main(String[] args) {
        BplaManager mgr = new BplaManager();

        if (args[0].equals("fly")) {
            //mgr.createAndStoreEvent("My Detail", new Date());
        }
        else if (args[0].equals("list")) {
            List bplas = mgr.listRsmcs();
            for (int i = 0; i < bplas.size(); i++) {
                Bpla bpla = (Bpla) bplas.get(i);
                System.out.println("Bpla: " + bpla.getState());

                for (Object objExt : bpla.getDetails()) {
                    System.out.println("    Detail:" + ((Detail) objExt).getName());
                    System.out.println("    Size  :" + ((Detail) objExt).getSize());
                }

            }
        }
//        }

        HibernateUtil.close();
    }

    private List listRsmcs() {

        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        List result = session.createQuery("from Bpla").list();

        session.getTransaction().commit();

        return result;
    }

}