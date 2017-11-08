package com.yccz.UserDAOImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;

import com.yccz.bean.Users;
import com.yccz.dao.UserDAO;

public class UserDAOImpl implements UserDAO {

	
	
	
	     SessionFactory sessionFactory;
		 public void setSessionFactory(SessionFactory sessionFactory) {
			this.sessionFactory = sessionFactory;
		}
	@Override
	public List<Users> search(){

		List<Users> list=null;
		Session session=sessionFactory.getCurrentSession();
		Transaction tx=session.beginTransaction();
		try {
			Query query=session.createQuery("from Users");
			list=query.list();
			tx.commit();
		} 
	
		catch (Exception e) {
			tx.rollback();
		}
	
		return list;
	}

}
