package jyp.cooksite.domain.user;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import jyp.cooksite.domain.Address;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class User {

	@Id @GeneratedValue
	@Column(name="user_id")
	private Long id;
	
	
	private String nickname;
	
	@NotEmpty
	private String name;
	
	@Embedded
	private Address address;
	
	
	
	
}
