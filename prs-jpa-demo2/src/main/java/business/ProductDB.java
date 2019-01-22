package business;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import db.DBUtil;

public class ProductDB {
	public static Product getProductById(int productID) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		try {
			Product product = em.find(Product.class, productID);
			
			return product;
		}
		finally {
			em.close();
			//DBUtil.closeEMF();
		}
		
	}

	public static List<Product> getAll() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		List<Product> products = new ArrayList<>();
		try {
			Query q = em.createQuery("SELECT p FROM Product p");
			products = q.getResultList();
			
		}
		finally {
			em.close();
			//DBUtil.closeEMF();
		}
		return products;
	}
	
	public static boolean addProduct(Product product){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		boolean successful = false;
		trans.begin();
		try {
			em.persist(product);
			trans.commit();
			successful = true;
		}
		finally {
			em.close();
		}
		return successful;
	}
	
	public static boolean deleteProduct(Product p) {
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
	
	public static List<Product> getAllProductsByVendorID(int vid) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		List<Product> products = new ArrayList<>();
		try {
			String qString = "SELECT p FROM Product p" +
							 " WHERE p.vendor.id = :inVid";
			TypedQuery<Product> tq = em.createQuery(qString, Product.class);
			tq.setParameter("inVid", vid);
			
			products = tq.getResultList();
			
			return products;
		}
		finally {
			em.close();
			//DBUtil.closeEMF();
		}
		
	}
}
