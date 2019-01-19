package business;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
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
}
