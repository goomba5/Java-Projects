package business;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

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
}
