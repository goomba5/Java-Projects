package business;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import db.DBUtil;

public class UserDB {
	public static User getUserById(int userID) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		try {
			User user = em.find(User.class, userID);
			
			return user;
		}
		finally {
			em.close();
			//DBUtil.closeEMF();
		}
		
	}
	
	public static List<User> getAll() {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		List<User> users = new ArrayList<>();
		try {
			Query q = em.createQuery("SELECT u FROM User u");
			users = q.getResultList();
			
		}
		finally {
			em.close();
			//DBUtil.closeEMF();
		}
		return users;
	}
	
	public static boolean addUser(User user){
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		boolean successful = false;
		trans.begin();
		try {
			em.persist(user);
			trans.commit();
			successful = true;
		}
		finally {
			em.close();
		}
		return successful;
	}
	
	public static boolean updateUser(User user) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		boolean successful = false;
		try {
			em.merge(user);
			trans.commit();
			successful = true;
		}
		finally {
			em.close();
			//DBUtil.closeEMF();
		}
		return successful;
	}
	
	public static boolean deleteUser(User u) {
		boolean successful = false;
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			User user = em.find(User.class, u.getId());
			em.merge(user);
			em.remove(user);
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
