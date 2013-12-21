package org.uniportal.dao;

import java.util.List;

import org.uniportal.ErrorLog.ErrorReport;

public interface DaoTransation {

	// TODO apply "errorList" and "ObjectName" params to all methods.
	public boolean addObject(Object object, List<ErrorReport> errorList,
			String ObjectName);

	public <T> Object getObjectById(Class<T> classLiteral, Object id);

	public List<Object> showAllObjects(String query);

	public boolean deleteObjectById(Object object);

	public boolean updateObjectById(Object object);

}
