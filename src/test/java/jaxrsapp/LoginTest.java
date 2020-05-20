package jaxrsapp;


import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import com.sahan.jaxrsapp.dao.UserDao;
import com.sahan.jaxrsapp.model.User;

public class LoginTest {
	
	private String email = "sahan@bcas.lk";
	private String password = "123";
	
	private static Logger logger = LogManager.getLogger(LoginTest.class);
	
//	@Test
//	public void LoginChecker() {
//		
//		User unexpected = null;
//		
//		User actual = UserDao.getInstance().LoginChecker(email, password);
//		
//		assertNotEquals(unexpected, actual);
//		
//		logger.trace("T--Login test was done");
//		logger.debug("D--Login test was done");
//		logger.info("I--Login test was done");
//		logger.warn("W--Login test was done");
//		logger.error("E--Login test was done");
//		logger.fatal("F--Login test was done");
//		
//	}

}
