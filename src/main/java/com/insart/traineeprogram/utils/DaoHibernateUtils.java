package com.insart.traineeprogram.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DaoHibernateUtils {
	private static SessionFactory factory;
	static {
		Configuration configuration = new Configuration().configure();
		factory = configuration.buildSessionFactory();
	}
	public static Session getHibernateSession(){
        return factory.openSession();    
	}

}
