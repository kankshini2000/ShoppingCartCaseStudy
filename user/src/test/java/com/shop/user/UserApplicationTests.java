package com.shop.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;

import com.shop.user.Model.User;
import com.shop.user.repo.UserRepo;
import com.shop.user.service.UserService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private UserService userService;

	@MockBean
	private UserRepo userRepo;

	@Test
	public void addUserTest(){
		User user=new User("suntaz","Sunita","sunita@gmail.com" ,"female","21-03-2000","user", " 2345617891","sunta", null);
		when(userRepo.save(user)).thenReturn(user);
		assertEquals(user, userService.createUser(user));
	}
	
	@Test
	public void deleteByIdTest() {
		Integer id = 1;
		userService.deleteByEmail(email);
		verify(userRepo,times(1)).deleteByEmail(email);
	}

	@Test
	public void getProfiles() {
		when(userRepo.findAll()).thenReturn(Stream.of(new UserProfile(111, "Novel", "nm@gmail.com", "1234567898", "Developer", "7/9/1999", "Male", "ADMIN", "XYZ")).collect(Collectors.toList()));
		assertEquals(1, userRepo.getUsers().size());
	}

	

}
