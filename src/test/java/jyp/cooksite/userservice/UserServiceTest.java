package jyp.cooksite.userservice;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import jyp.cooksite.domain.user.User;
import jyp.cooksite.repository.UserRepository;
import jyp.cooksite.service.UserService;

import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class UserServiceTest {

	@Autowired UserService userService;
	@Autowired UserRepository userRepository;
	
	@Test
	public void join() throws Exception{
		//given
		User user = new User("jin","a@a");
		//when
		Long userid = userService.join(user); // persist 하면서 id 값 캐쉬에 저장
		
		//then
		assertEquals(user, userRepository.findOne(userid));
	}
	
	@Test(expected = IllegalStateException.class)
	public void checkDuplicateEmail() throws Exception{
		//given
		User user1 = new User("jin","a@a");
		User user2 = new User("jin2","a@a");
		//when
		userService.join(user1);
		userService.join(user2);
		
		//then
		fail("중복 예외 발생 해야한다.");
	}
	
}
