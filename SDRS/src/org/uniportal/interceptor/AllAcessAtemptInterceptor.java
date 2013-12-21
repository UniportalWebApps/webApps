package org.uniportal.interceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.uniportal.utils.ViewNameConstants;

public class AllAcessAtemptInterceptor extends HandlerInterceptorAdapter {

	private static final String LOGINSUBMITTED = "loginSubmitted";
	private static final String LOGOUT = "logout";

	/**
	 * Check if the user is authenticated using a login page previously if so do
	 * nothing, just return true; Otherwise forward the request to login page ,
	 * set also the message to display on the login page And record the
	 * requesting url so that it may be used latter to redirect the page after
	 * login succeed
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		String requstUrl = request.getRequestURI();

		// get the view Name properly
		requstUrl = requstUrl.substring(requstUrl.lastIndexOf("/") + 1,
				requstUrl.length());

		if (requstUrl.equals(LOGINSUBMITTED) || requstUrl.equals(LOGOUT)) {
			return true;
		}

		HttpSession session = request.getSession(false);
		// check authentication and show form
		if (session == null
				|| session.getAttribute("loginUserName") == null
				|| session.getAttribute("loginUserName").toString().length() == 0
				|| session.getAttribute("userType") == null
				|| session.getAttribute("userType").toString().length() == 0) {
			request.setAttribute("loginMOTD",
					"Please login before accessing the system");

			request.setAttribute("requestingUrl",
					ViewNameConstants.MAIN_CONTENT_FOLDER + requstUrl);

			if (session != null) {
				session.invalidate();
			}

			// Forward to the login to
			RequestDispatcher rd = request
					.getRequestDispatcher(ViewNameConstants.LOGIN);
			rd.forward(request, response);

			return false;
		}
		return true;
	}
}
