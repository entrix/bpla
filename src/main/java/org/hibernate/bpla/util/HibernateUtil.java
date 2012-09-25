package org.hibernate.bpla.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class HibernateUtil {

    private static final SessionFactory sessionFactory;

    static {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            Configuration cfg = new Configuration();
            cfg.configure();

            SchemaExport schemaExport = new SchemaExport(cfg);
            schemaExport.setOutputFile("src/main/resources/schema.sql");
            schemaExport.execute(true, true, true, true);

            sessionFactory = cfg.buildSessionFactory();
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() {
        if (sessionFactory.isClosed()) {
            return null;
        }

        return sessionFactory.openSession();
    }

    public static void close() {
        sessionFactory.close();
    }
}