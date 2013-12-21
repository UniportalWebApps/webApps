package org.uniportal.utils;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class FormValidator {

	public static boolean isAllFormInPlace(HttpServletRequest request,
			List<String> params) {
		if (request != null && params != null) {
			for (String param : params) {
				if (request.getParameter(param) != null) {
					if (request.getParameter(param).toString().equals("")) {
						return false;
					}
				} else {
					return false;
				}
			}
		} else {
			return false;
		}
		return true;
	}
	// TODO .. other complex. form validation
	public static boolean isAllRulesRespected() {
		return false;
	}
}
