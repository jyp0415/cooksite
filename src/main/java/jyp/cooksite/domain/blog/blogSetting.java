package jyp.cooksite.domain.blog;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class blogSetting {

	@Id
	private Long id;
	
	
	@MapsId
	@OneToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name = "blog_id")
	private Blogs blog;
	
	//����ڰ� �޴� ���� ���� �� �ֵ��� �ϱ�.
}
