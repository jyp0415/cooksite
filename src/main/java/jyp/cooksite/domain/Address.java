package jyp.cooksite.domain;

import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter @Setter
public class Address {

	private String city;
	private String street;
	private String zipcode;
	
	
	
	public Address(String city, String street, String zipcode) {
		
		this.city = city;
		this.street = street;
		this.zipcode = zipcode;
	}



	protected Address() { //���÷��� ���Ͻ� ���� ��ų�� �������ؼ��� �ϴ� �⺻ ������ �ʿ� 
		 //jpa ���� ���̺귯���� ��ü�� ������ ��  ���÷��� ���� ��� ����Ϸ��� 
	}
	
	
}
