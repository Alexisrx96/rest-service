package com.example.restservice;

import com.example.restservice.dao.RoleDao;
import com.example.restservice.dao.UserDao;
import com.example.restservice.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)

@SpringBootTest
class RestServiceApplicationTests {

	@Autowired
	UserDao userDao;

	@Autowired
	RoleDao roleDao;
	@Autowired
	BCryptPasswordEncoder encoder;


	@Test
	void newAdminTest() {
		String pass = "123";
		User user = new User();
		//user.setId(1);
		user.setPassword(encoder.encode(pass));
		user.setEmail("test1@fakemail.com");
		user.setFirstName("Fake");
		user.setLastName("Name");
		user.setDireccion("FakeStreet123");
		user.setIdRol(roleDao.getRoles().get(0));

		userDao.createUser(user);
		var returned = userDao.getUserByEmail(user.getEmail());

		if (returned.getPassword().equals(pass)) throw new AssertionError();

	}


	@Test
	void newCustomerTest() {
		String pass = "123";
		User user = new User();
		//user.setId(2);
		user.setPassword(encoder.encode(pass));
		user.setEmail("test2@fakemail.com");
		user.setFirstName("Fake");
		user.setLastName("Name");
		user.setDireccion("FakeStreet123");
		user.setIdRol(roleDao.getRoles().get(1));

		userDao.createUser(user);
		var returned = userDao.getUserByEmail(user.getEmail());

		if (returned.getPassword().equals(pass)) throw new AssertionError();

	}

}
