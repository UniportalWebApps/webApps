package org.uniportal.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.uniportal.ErrorLog.ErroMessageConstants;
import org.uniportal.ErrorLog.ErrorCodes;
import org.uniportal.ErrorLog.ErrorReport;

/**
 * This class is designed to be generic for all Dao, it is implements common
 * functionalities supported by all Daos
 * 
 * @author jLeta
 * 
 */
@Service
public class DaoTransactionImpl implements DaoTransation {

	private static Logger logger = Logger
			.getLogger(DaoTransactionImpl.class.getName());
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional(rollbackFor = { RuntimeException.class, Exception.class })
	public boolean addObject(Object object, List<ErrorReport> errorList,
			String ObjectName) {
		Session transactionSession = getSessionFactory().openSession();
		try {
			transactionSession.beginTransaction();
			transactionSession.save(object);
			transactionSession.getTransaction().commit();
			return true;
		} catch (Exception ex) {

			transactionSession.getTransaction().rollback();

			// TODO Apply this Error Logging Mechanism to all methods.
			// rollBack
			// Log error and create new error and add to error List.
			logger.error(ErroMessageConstants.SAVE_TO_DB_ERROR);

			ErrorReport error = new ErrorReport();
			error.setErrorCode(ErrorCodes.SAVE_TO_DB);
			error.setErrorMessage(ErroMessageConstants.SAVE_TO_DB_ERROR);
			error.setGeneratingMethod("addObject: " + ObjectName);
			error.setGeneratingClass(DaoTransactionImpl.class.getName());
			error.setName("ADD_" + ObjectName);
			errorList.add(error);
			return false;
		} finally {
			transactionSession.close();
		}
	}

	@Override
	@Transactional(rollbackFor = { RuntimeException.class, Exception.class })
	public <T extends Object> Object getObjectById(Class<T> classLiteral,
			Object id) {
		Session transactionSession = getSessionFactory().openSession();
		try {
			transactionSession.beginTransaction();
			Object object = transactionSession.get(classLiteral,
					(Serializable) id);
			transactionSession.getTransaction().commit();
			return object;
		} catch (Exception ex) {
			ex.printStackTrace();
			transactionSession.getTransaction().rollback();
			return null;
		} finally {
			transactionSession.close();
		}
	}

	@Override
	@Transactional(rollbackFor = { RuntimeException.class, Exception.class })
	public List<Object> showAllObjects(String queryStr) {
		Session transactionSession = getSessionFactory().openSession();
		try {
			transactionSession.beginTransaction();
			Query query = transactionSession.createQuery(queryStr);
			@SuppressWarnings("unchecked")
			List<Object> objects = (List<Object>) query.list();
			transactionSession.getTransaction().commit();
			return objects;
		} catch (Exception ex) {
			ex.printStackTrace();
			transactionSession.getTransaction().rollback();
			return null;
		} finally {
			transactionSession.close();
		}
	}

	@Override
	@Transactional(rollbackFor = { RuntimeException.class, Exception.class })
	public boolean deleteObjectById(Object object) {
		Session transactionSession = getSessionFactory().openSession();
		try {
			transactionSession.beginTransaction();
			transactionSession.delete(object);
			transactionSession.getTransaction().commit();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			transactionSession.getTransaction().rollback();
			return false;
		} finally {
			transactionSession.close();
		}
	}

	@Override
	@Transactional(rollbackFor = { RuntimeException.class, Exception.class })
	public boolean updateObjectById(Object object) {
		Session transactionSession = getSessionFactory().openSession();
		try {
			transactionSession.beginTransaction();
			transactionSession.update(object);
			transactionSession.getTransaction().commit();
			return true;

		} catch (Exception ex) {
			ex.printStackTrace();
			transactionSession.getTransaction().rollback();
			return false;
		} finally {
			transactionSession.close();
		}
	}

	// getter and setter
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
