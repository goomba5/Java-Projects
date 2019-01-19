package business;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import db.DBUtil;

public class PurchaseRequestDB {
	public static List<PurchaseRequest> getAll() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		List<PurchaseRequest> purchaseRequest = new ArrayList<>();
		try {
			Query q = em.createQuery("SELECT pur FROM PurchaseRequest pur");
			purchaseRequest = q.getResultList();
			
		}
		finally {
			em.close();
			//DBUtil.closeEMF();
		}
		return purchaseRequest;
	}
}
