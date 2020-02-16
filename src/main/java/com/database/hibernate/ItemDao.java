package com.database.hibernate;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.userpojo.Itempo;

import getConnection.DBUtill;

public class ItemDao {
	
	final static Logger logger=Logger.getLogger(ItemDao.class);
	public  void addItems(Itempo item) {
		logger.info("hibernate connection");
		logger.info("entered into connection");
		SessionFactory factory = DBUtill.getsf();
		Session session = factory.openSession();
		Transaction tr = session.beginTransaction();
		session.save(item);
		tr.commit();
		session.close();
	}
	public List<Itempo> menu(Itempo item) {
		logger.info("entered into connection");
		logger.info("hibernate connection");
		SessionFactory factory = DBUtill.getsf();
		Session session = factory.openSession();
		Query query = session.createQuery("from Itempo");
		List list = query.list();
		return list;
	}
	
	public Itempo edit(String id) {
		logger.info("entered into connection");
		logger.info("hibernate connection");
		SessionFactory factory = DBUtill.getsf();
		Session session = factory.openSession();
		Query query = session.createQuery("from Itempo where itemid=:itemid");
		query.setParameter("itemid",id);
		Itempo list =(Itempo) query.list().get(0);
		session.close();
		return list;
	}
	public void saveEdit(Itempo item) {
		logger.info("entered into connection");
		logger.info("hibernate connection");
		SessionFactory factory = DBUtill.getsf();
		Session session = factory.openSession();
		Transaction tr = session.beginTransaction();
		session.update(item);
		tr.commit();
		
		session.close();
		
	}
	
	public Integer deleteItem(String id) {
		logger.info("hibernate connection");
		SessionFactory factory = DBUtill.getsf();
		Session session = factory.openSession();
		Query query = session.createQuery("delete from Itempo where itemid=:itemid");
		query.setParameter("itemid", id);
		int res = query.executeUpdate();
		session.beginTransaction().commit();
		session.close();
		return res;
	}
}
