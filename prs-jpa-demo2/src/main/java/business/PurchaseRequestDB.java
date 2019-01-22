package business;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import db.DBUtil;

public class PurchaseRequestDB {
	public static PurchaseRequest getPurchaseRequestById(int prID) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		try {
			PurchaseRequest pr = em.find(PurchaseRequest.class, prID);
			
			return pr;
		}
		finally {
			em.close();
			//DBUtil.closeEMF();
		}
		
	}
	
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
	
	public static boolean addPurchaseRequest(PurchaseRequest purchaseReq) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		boolean successful = false;
		trans.begin();
		try {
			em.persist(purchaseReq);
			trans.commit();
			successful = true;
		}
		finally {
			em.close();
		}
		
		return successful;
	}
	
	public static boolean deletePR(PurchaseRequest p) {
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
	
	public static boolean recalculateTotal() {
		boolean successful = false;
		List<PurchaseRequestLineItem> prli = PurchaseLineItemDB.getAll();
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			for(PurchaseRequestLineItem p: prli) {
				
			}
		}
		finally {
			
		}
		
		return successful;
	}
}
