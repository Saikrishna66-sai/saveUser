package com.database.hibernate;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import com.userpojo.Itempo;
import com.userpojo.Test;

import getConnection.DBUtill;
import saveInterface.IUserDaoInterface;

public class UserDao implements IUserDaoInterface{
	
	final static Logger logger=Logger.getLogger(UserDao.class); 
	public void saveUser(Test test) {
		logger.info("entered into connection");
		logger.info("hibernate connection");
		SessionFactory factory = DBUtill.getsf();
		Session session = factory.openSession();
		Transaction tr = session.beginTransaction();
		session.save(test);
		
		logger.info("ready to save data");
		tr.commit();
		logger.info("data is saved");
		session.close();
		
	}
	
	public List<Test> loginUser (String email,String password) {
		logger.info("entered into connection");
		logger.info("hibernate connection");
		SessionFactory factory = DBUtill.getsf();
		Session session = factory.openSession();
		Query query = session.createQuery("from Test where email=:mail and password=:pass");
		query.setParameter("mail", email);
		query.setParameter("pass", password);
		
		List<Test> list = query.list();
		session.close();
		return list;
	}

	public List<Test> userList() {
		logger.info("entered into connection");
		logger.info("hibernate connection");
		SessionFactory factory = DBUtill.getsf();
		Session session = factory.openSession();
		Query query = session.createQuery("from Test");
		List<Test> list = query.list();
		session.close();
		logger.info("user list is selected");
		return list;
	}
	
	public int deleteUser(String id) {
		logger.info("entered into connection");
		logger.info("hibernate connection");
		SessionFactory factory = DBUtill.getsf();
		Session session = factory.openSession();
		Query query = session.createQuery("delete from Test where email=:email");
		query.setParameter("email", id);
		logger.warn("user is ready to delete");
		int res = query.executeUpdate();
		session.beginTransaction().commit();
		session.close();
		return res;
	}
}