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
	
	//user �Ѹ��� ������ ��α� ������ �ִٰ� �Ѵٸ� User�� mapped by �������
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;
	
	
}
