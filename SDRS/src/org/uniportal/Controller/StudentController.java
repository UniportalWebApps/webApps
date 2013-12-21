package org.uniportal.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.uniportal.ErrorLog.ErrorReport;
import org.uniportal.manager.StudentTransactionManager;
import org.uniportal.model.Student;
import org.uniportal.utils.FormValidator;
import org.uniportal.utils.ViewNameConstants;

@Controller
public class StudentController {

	private List<ErrorReport> errorList = null;
	private static List<String> studentFormRequiredFileds = new ArrayList<String>();

	/**
	 * Initialise statics members.
	 */
	static {
		studentFormRequiredFileds.add("id");
		studentFormRequiredFileds.add("firstName");
		studentFormRequiredFileds.add("firstName");

	}

	@Autowired
	private StudentTransactionManager studentTransactionManager;

	@RequestMapping(value = ViewNameConstants.STUDENT)
	public ModelAndView newStudentHandler() {

		// just show student registration form
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName(ViewNameConstants.N_STUDENT);
		return modelAndView;
	}

	// TODO Delete such method it should be handled by Ajax.
	// and message should be displayed on the same page as registration form.
	/**
	 * 
	 * @param request
	 * @param modelAndView
	 * @return
	 */
	@RequestMapping(value = ViewNameConstants.STUDENT_SAVED, headers = "content-type=multipart/*", method = RequestMethod.POST)
	public ModelAndView studentRequestHandler(
			@RequestParam("stdImage") MultipartFile file,
			HttpServletRequest request, ModelAndView modelAndView) {
		if (!FormValidator.isAllFormInPlace(request, studentFormRequiredFileds)) {
			modelAndView.addObject("FormValidationMsg",
					"Please fill all required fileds.");
			return modelAndView;
		}

		errorList = new ArrayList<ErrorReport>();
		if (request != null) {

			byte[] bytes = null;

			try {
				if (!file.isEmpty()) {
					MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
					MultipartFile file2 = multipartRequest.getFile("stdImage");
					bytes = file2.getBytes();
				}
			} catch (IOException ex) {
				// TODO
				ex.printStackTrace();
			}

			Student student = new Student();
			student.setId(Integer.parseInt(request.getParameter("id")));
			student.setFirstName(request.getParameter("firstName"));
			student.setLastName(request.getParameter("lastName"));
			student.setStdImage(bytes);

			studentTransactionManager.addStudent(student, bytes, errorList,
					request, modelAndView);

		}
		return modelAndView;
	}
	@RequestMapping(value = ViewNameConstants.ALl_STUDENT)
	public ModelAndView showAllStudentsHandler(HttpServletRequest request,
			ModelAndView modelAndView) {
		studentTransactionManager.showAllStudents(modelAndView);
		return modelAndView;
	}

	@RequestMapping(value = ViewNameConstants.STUDENT_DETAIL)
	public ModelAndView getStudentHandler(@RequestParam int id,
			HttpServletRequest request, ModelAndView modelAndView) {
		studentTransactionManager.getStudentById(id, modelAndView);
		return modelAndView;
	}

	/**
	 * No need to check for authentication, because by the time this operation
	 * is performed a user is already logged in.
	 * 
	 * @param id
	 * @param response
	 * @return @ResponseBody which tells that a response is needed for the
	 *         requesting service in this case Ajax call, so the string returned
	 *         will not be considered as view name
	 */
	@RequestMapping(value = ViewNameConstants.DELETE_STUDENT, method = RequestMethod.GET)
	public @ResponseBody
	String deleteStudentHandler(@RequestParam int id) {

		// TODO delete this it is just to simulate possible delay:
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// end of TODO

		String returnText = studentTransactionManager.deleteStudentsById(id);
		return returnText;
	}

	@RequestMapping(value = ViewNameConstants.STUDENT_UPDATE, method = RequestMethod.POST)
	public ModelAndView getStudentForUpdate(HttpServletRequest request,
			ModelAndView modelAndView) {
		studentTransactionManager.getStudentsById(request, modelAndView,
				Integer.parseInt(request.getParameter("id").toString()));
		return modelAndView;
	}

	/**
	 * TODO Delete this, it should be handled by Ajax
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = ViewNameConstants.STUDENT_UPDATED, method = RequestMethod.POST)
	public ModelAndView updateStudentHandler(HttpServletRequest request,
			ModelAndView model) {
		studentTransactionManager.updateStudentsById(request, model);
		return model;
	}

	@RequestMapping(value = ViewNameConstants.EXPORT_STUDENT, method = RequestMethod.GET)
	public ModelAndView getExcel() {

		ModelAndView modelAndView = studentTransactionManager.exportStudent();
		return modelAndView;
	}

	// Bind Image file retrieved from DB to a View.
	@RequestMapping(value = "/imageController/{studentID}")
	@ResponseBody
	public byte[] bindImage(@PathVariable int studentID) {
		return studentTransactionManager.getStudentById(studentID);
	}

}
