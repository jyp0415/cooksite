package jyp.cooksite.domaintest;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import jyp.cooksite.domain.user.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class userTest {

	// 유저 이름 -> 닉네임으로 설정 
	// 유저 a 가 유저 b 팔로우 추가 했을때 
	// 유저 a의 <Set>following 에 유저 b 의 id 추가
	// 유저 b의 <Set>followers 에 유저 a 의 id 추가
	@Test
	public void userRelationTest() throws Exception{
		//given
		boolean tag = false;
		User userA =new User("a","abc@abc");
		User userB =new User("b","a@b");		
		
		//when
		userA.addFollowing(userB);
		Iterator<User> ownerB = userB.getFollowers().iterator(); 

		while (ownerB.hasNext()) { 
			if(userA.getId()==ownerB.next().getId() ) {
				tag=true;
			}
		}
		//then
		assertEquals("userA의 닉네임은 a", userA.getName() , userA.getNickname());
		
		assertEquals("user 각각 follwers follwing 에 id 값이 있어야 한다. ",true , tag);
		
	}
	
}
