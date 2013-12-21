package org.uniportal.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.uniportal.dao.LoginCredentialsDao;
import org.uniportal.model.Login;
import org.uniportal.utils.ViewNameConstants;

@Controller
public class LoginController {

	@Autowired
	private LoginCredentialsDao loginCredentials;

	@RequestMapping(value = ViewNameConstants.LOGIN)
	public void simplyShowLoginPage(HttpServletRequest request) {
		// Just show the login page
	}

	@RequestMapping(value = ViewNameConstants.LOGIN_SUBMITTED)
	public ModelAndView handleLoginOperation(HttpServletRequest request,
			ModelAndView modelAndView) {

		HttpSession session = null;

		// we get session if it exists otherwise, create a new one.
		// This action should only happen here, in all other places:
		// request.getSession(false) should be used
		session = request.getSession(true);

		// First check if the credentials are correct.
		// we have to check this only if the check is not done yet.
		Login loginDetail = null;
		if (session != null && session.getAttribute("loginUserName") == null) {
			loginDetail = this.getLoginCredentials().getLoginDetailById(
					request.getParameter("loginId"));
		}

		if (loginDetail != null
				&& loginDetail.getPassword() != null
				&& loginDetail.getPassword().equals(
						request.getParameter("password"))) {
			// if the credentials are OK, set necessary attributes.
			session.setAttribute("loginUserName", loginDetail.getLoginId());
			session.setAttribute("userType", loginDetail.getUserType());
			session.setAttribute("userPermissionType",
					loginDetail.getPermission());

			if (request.getParameter("requestingUrl") == null
					|| request.getParameter("requestingUrl").equals("")
					|| request.getParameter("requestingUrl").equalsIgnoreCase(
							"null")) {
				modelAndView.setViewName(ViewNameConstants.N_HOME);
			} else {
				modelAndView.setViewName(request.getParameter("requestingUrl"));
			}
		} else {
			// TODO move constants to property file
			// again check if we are checking login the first time.
			if (session.getAttribute("loginUserName") == null) {
				modelAndView
						.addObject("loginMOTD",
								"Either username or password is incorrect, please try again");
				modelAndView.setViewName(ViewNameConstants.N_LOGIN);

				// Invalidate the session created before.
				if (session != null) {
					session.invalidate();
				}
			}
		}

		return modelAndView;

	}

	@RequestMapping(value = ViewNameConstants.LOGOUT)
	public ModelAndView handleLogOutOperation(HttpServletRequest request,
			ModelAndView modelAndView) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
			// TODO move to property file
			modelAndView.addObject("loginMOTD",
					" You are logged out Successfully ");
		}

		modelAndView.setViewName(ViewNameConstants.N_LOGIN);
		return modelAndView;
	}

	// getter and setter.
	public LoginCredentialsDao getLoginCredentials() {
		return loginCredentials;
	}

	public void setLoginCredentials(LoginCredentialsDao loginCredentials) {
		this.loginCredentials = loginCredentials;
	}

}
