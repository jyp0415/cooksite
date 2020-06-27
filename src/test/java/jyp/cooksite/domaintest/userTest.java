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

	// ���� �̸� -> �г������� ���� 
	// ���� a �� ���� b �ȷο� �߰� ������ 
	// ���� a�� <Set>following �� ���� b �� id �߰�
	// ���� b�� <Set>followers �� ���� a �� id �߰�
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
		assertEquals("userA�� �г����� a", userA.getName() , userA.getNickname());
		
		assertEquals("user ���� follwers follwing �� id ���� �־�� �Ѵ�. ",true , tag);
		
	}
	
}
