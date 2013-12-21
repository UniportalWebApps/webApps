package org.uniportal.dao;

import org.springframework.stereotype.Service;
import org.uniportal.model.Login;

@Service
public class LoginCredentialsDao extends DaoTransactionImpl {

	public Login getLoginDetailById(String loginId) {
		return (Login) super.getObjectById(Login.class, loginId);
	}
}
