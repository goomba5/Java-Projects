package business;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import db.DBUtil;

public class PurchaseLineItemDB {
	public static PurchaseRequestLineItem getPRLIById(int prliID) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		try {
			PurchaseRequestLineItem prli = em.find(PurchaseRequestLineItem.class, prliID);
			
			return prli;
		}
		finally {
			em.close();
			//DBUtil.closeEMF();
		}
		
	}
	
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
	
	public static boolean addPRLI(PurchaseRequestLineItem prli){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		boolean successful = false;
		trans.begin();
		try {
			em.persist(prli);
			trans.commit();
			successful = true;
		}
		finally {
			em.close();
		}
		return successful;
	}
	
	public static boolean deletePRLI(PurchaseRequestLineItem p) {
		boolean successful = false;
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.merge(p);
			em.remove(p);
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
