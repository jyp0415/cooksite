package jyp.cooksite.domain.commonboard;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import jyp.cooksite.domain.Address;
import jyp.cooksite.domain.user.User;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class board {

	@Id
	@GeneratedValue
	@Column(name = "board_id")
	private Long id;
	
	private String title;
	
	private String content;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;
	
	private LocalDate createdDate;
	
	private LocalDate modDate;
	
	private int viewCnt;
	
	private int star;
}
