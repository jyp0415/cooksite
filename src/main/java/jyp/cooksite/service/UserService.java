package jyp.cooksite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jyp.cooksite.domain.user.User;
import jyp.cooksite.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;

	@Transactional
	public Long join(User user) {
		checkDuplicateUser(user);
		userRepository.save(user);
		return user.getId();
	}

	private void checkDuplicateUser(User user) {
		System.out.println("user email : ~ "+user.getEmail());
		List<User> users = userRepository.findByEmail(user.getEmail());
		
		if (!users.isEmpty()) {
			throw new IllegalStateException("�̹� ������ ȸ���Դϴ�.");
		}
	}

	public List<User> findUsers() {
		return userRepository.findAll();
	}
	
	public List<User> findUsers(String name) { // ģ�� ã�� 
		return userRepository.findByName(name);
	}
	
	
	public User findOne(Long userid) {
		return userRepository.findOne(userid);
	}

}
