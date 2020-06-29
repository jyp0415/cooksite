package jyp.cooksite.domain.blog;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class blogMenu {

	@Id
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Blogs blog;
	
	private String name;
}
