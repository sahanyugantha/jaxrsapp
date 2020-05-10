package jaxrsapp;


import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

import com.sahan.jaxrsapp.dao.UserDao;
import com.sahan.jaxrsapp.model.User;

public class LoginTest {
	
	private String email = "sahan@bcas.lk";
	private String password = "1234";
	
	@Test
	public void LoginChecker() {
		
		User unexpected = null;
		
		User actual = UserDao.getInstance().LoginChecker(email, password);
		
		assertNotEquals(unexpected, actual);
		
	}

}
