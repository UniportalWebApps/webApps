package org.uniportal.dao;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.uniportal.ErrorLog.ErrorReport;
import org.uniportal.model.Student;
import org.uniportal.utils.CollectionConvertor;

@Service
public class StudentTransactionDao extends DaoTransactionImpl {

	private static String STUDENT = "STUDENT";

	public boolean addStudent(Student student, List<ErrorReport> errorList) {
		return super.addObject(student, errorList, STUDENT);
	}
	public List<Student> getAllStudents() {
		List<Student> returnList = new ArrayList<Student>();
		returnList = CollectionConvertor.convertToMyTypeList(returnList,
				super.showAllObjects("from Student"));
		return returnList;
	}

	public Student getStudentsById(int id) {
		return (Student) super.getObjectById(Student.class, id);
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public boolean deleteStudentsById(int id) {
		Student student = new Student();
		student.setId(id);
		return super.deleteObjectById(student);
	}

	public boolean updateStudentsById(HttpServletRequest request) {
		if (request != null) {
			// build student to update
			Student student = new Student();
			student.setId(Integer.parseInt(request.getParameter("id")));
			student.setFirstName(request.getParameter("firstName"));
			student.setLastName(request.getParameter("lastName"));

			// do the transaction.
			return super.updateObjectById(student);
		}
		return false;
	}
}
