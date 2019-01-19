package business;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import db.DBUtil;

public class PurchaseLineItemDB {
	public static List<PurchaseRequestLineItem> getAll() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		List<PurchaseRequestLineItem> purchaseRequestLineItem = new ArrayList<>();
		try {
			Query q = em.createQuery("SELECT line FROM PurchaseRequestLineItem line");
			purchaseRequestLineItem = q.getResultList();
			
		}
		finally {
			em.close();
			//DBUtil.closeEMF();
		}
		return purchaseRequestLineItem;
	}
}
