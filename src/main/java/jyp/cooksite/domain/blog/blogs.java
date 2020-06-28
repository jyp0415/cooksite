package jyp.cooksite.domain.blog;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import jyp.cooksite.domain.user.User;
import lombok.Getter;
import lombok.Setter;
@Entity
@Getter @Setter
public class Blogs {

	private Long id;
	
	private LocalDate createdDate;
	
	//user 한명이 여러개 블로그 가질수 있다고 한다면 User에 mapped by 사용하자
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;
	
	
}
