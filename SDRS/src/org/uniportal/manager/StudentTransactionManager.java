package org.uniportal.manager;

import java.util.List;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import org.uniportal.ErrorLog.ErrorReport;
import org.uniportal.dao.StudentTransactionDao;
import org.uniportal.model.Student;
import org.uniportal.utils.ErrorLogger;

@Service
public class StudentTransactionManager {

	private static final String SAVE_MESSAGE = "saveMessage";
	private static final String SAVE_MESSAGE_WARNING = "updateMessageWarning";
	private static final String STUDENTS = "students";
	private static final String SINGLE_STUDENT_DETAl = "singleStudentsDetail";
	private static final String UPDATE_MESSAGE = "updateMessage";

	@Autowired
	private StudentTransactionDao studentTransactionDao;

	@Autowired
	private EmailSendingManager sendEmailManager;

	public boolean addStudent() {
		return true;
	}

	public void addStudent(Student student, byte[] bytes,
			List<ErrorReport> errorList, HttpServletRequest request,
			ModelAndView modelAndView) {

		if (studentTransactionDao.addStudent(student, errorList)) {
			// TODO Consider to move the message to be prepared in separate
			// property file prepared for this. apply to evey method below.
			modelAndView.addObject(
					SAVE_MESSAGE,
					"Your student Student : "
							+ request.getParameter("firstName") + " "
							+ request.getParameter("lastName")
							+ " Succesfully saved!");

			// Waning! for unsaved student image.
			if (bytes == null) {
				modelAndView
						.addObject(
								SAVE_MESSAGE_WARNING,
								"Student Picture is not saved, please check if the file existsm andupdate by retriving the saved student Again!");
			}
		} else {
			modelAndView.addObject(SAVE_MESSAGE,
					"Another Student is already saved with Id number "
							+ student.getId());
		}

		// If there is any error reported send to Util.
		if (errorList != null && !errorList.isEmpty()) {
			// TODO file path should be passed from user
			ErrorLogger.LogIt(errorList, "D:");

			// log it via log4j

		}

		// Now Send Email.
		try {
			// TODO
			sendEmailManager
					.sendMail(
							"Leta",
							"Here is the Subject ",
							" you are registered as new student in our school, \n congrats :)",
							null, null,
							new String[]{"l.jifar.sssup.it@gmail.com"},
							"leta2000@gmail.com");
		} catch (MessagingException e) {
			// TODO log that email sending is failed
			e.printStackTrace();
		}

	}
	public void showAllStudents(ModelAndView modelAndView) {
		List<Student> students = studentTransactionDao.getAllStudents();
		modelAndView.addObject(STUDENTS, students);
	}

	public void getStudentById(int id, ModelAndView modelAndView) {
		Student student = studentTransactionDao.getStudentsById(id);
		modelAndView.addObject(SINGLE_STUDENT_DETAl, student);
	}

	public String deleteStudentsById(int id) {
		String returnText = "Sorry, an error has occur.";
		if (id != 0 && studentTransactionDao.deleteStudentsById(id)) {
			returnText = "Student with ID " + id + " deleted successfully!!";
		}
		return returnText;
	}

	public void getStudentsById(HttpServletRequest request,
			ModelAndView modelAndView, int parseInt) {
		Student student = studentTransactionDao.getStudentsById(Integer
				.parseInt(request.getParameter("id").toString()));
		modelAndView.addObject(SINGLE_STUDENT_DETAl, student);
	}

	public void updateStudentsById(HttpServletRequest request,
			ModelAndView model) {
		if (studentTransactionDao.updateStudentsById(request)) {
			model.addObject(UPDATE_MESSAGE, " update Succesful!");
		} else {
			model.addObject(UPDATE_MESSAGE,
					"Can not update this student, please try again ");
		}
	}

	public ModelAndView exportStudent() {
		List<Student> studentList = this.studentTransactionDao.getAllStudents();
		return new ModelAndView("StudentExcelDocExporter", "studentList",
				studentList);

	}

	public byte[] getStudentById(int studentID) {
		Student student = studentTransactionDao.getStudentsById(studentID);
		return student.getStdImage();
	}

	public void setSendEmailManager(EmailSendingManager sendEmailManager) {
		this.sendEmailManager = sendEmailManager;
	}

}
