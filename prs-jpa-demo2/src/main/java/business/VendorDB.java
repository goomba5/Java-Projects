package business;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import db.DBUtil;

public class VendorDB {
	public static Vendor getVendorById(int vendorID) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		try {
			Vendor vendor = em.find(Vendor.class, vendorID);
			
			return vendor;
		}
		finally {
			em.close();
			//DBUtil.closeEMF();
		}
		
	}

	public static List<Vendor> getAll() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		List<Vendor> users = new ArrayList<>();
		try {
			Query q = em.createQuery("SELECT v FROM Vendor v");
			users = q.getResultList();
			
		}
		finally {
			em.close();
			//DBUtil.closeEMF();
		}
		return users;
	}
	
	public static boolean addVendor(Vendor vendor){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		boolean successful = false;
		trans.begin();
		try {
			em.persist(vendor);
			trans.commit();
			successful = true;
		}
		finally {
			em.close();
		}
		return successful;
	}
	
	public static boolean deleteVendor(Vendor v) {
		boolean successful = false;
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			Vendor vendor = em.find(Vendor.class, v.getId());
			em.merge(vendor);
			em.remove(vendor);
			trans.commit();
			successful = true;
		}
		catch(Exception e) {
			System.out.println(e);
			trans.rollback();
		}
		finally {
			em.close();
		}
		return successful;
	}
}
