package com.vc.common;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.vc.persistence.HibernateUtil;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println("Maven + Hibernate + MySQL");
        search(); 
    }
    
    @SuppressWarnings("unchecked")
	private static void search() {

    	Session session = HibernateUtil.getSessionFactory().openSession();
        
        session.beginTransaction();
 
        Query query = session.createQuery("FROM Flight");
        List<Flight> list = query.list();
        for(Flight s : list) {
        	System.out.println(s.getFlightId());
        }
        session.getTransaction().commit();
    }
    
    private static void update() {

    	Session session = HibernateUtil.getSessionFactory().openSession();
        
        session.beginTransaction();
 
        Query query = session.createQuery("UPDATE Flight set flightId = :fcode "
        		+ "WHERE stockId = :sId");
        query.setParameter("fcode", "009");
        query.setParameter("sId", 1234);
        int result = query.executeUpdate();
        System.out.println("result: " + result);
        session.getTransaction().commit();
    }

    private static void delete() {

    	Session session = HibernateUtil.getSessionFactory().openSession();
        
        session.beginTransaction();
 
        Query query = session.createQuery("DELETE FROM FlightId WHERE flightId = :sId");
        query.setParameter("sId", 1236);
        int result = query.executeUpdate();
        System.out.println("result: " + result);
        session.getTransaction().commit();
    }
     
}
