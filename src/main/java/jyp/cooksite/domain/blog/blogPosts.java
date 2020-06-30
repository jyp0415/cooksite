package jyp.cooksite.domain.blog;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class blogPosts {

	@Id
	@Column(name="blogpost_id")
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "blog_id")
	private Blogs blog;
	
	private String comment;
	
	private LocalDate createdDate;
	
	private LocalDate modDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "blogmenu_id")
	private  blogMenu blogmenu;
}
