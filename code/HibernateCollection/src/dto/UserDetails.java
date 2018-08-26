package dto;


import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;


@Entity
@Table(name="USER_DETAIL")
public class UserDetails {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int Id;
	private String userName;
	@ElementCollection(fetch=FetchType.EAGER)
	@JoinTable(name="USER_ADDRESS", 
			   joinColumns=@JoinColumn(name="USER_ID")
			)
//	@GenericGenerator(name = "increment-gen", strategy = "increment") 
//	@CollectionId(columns = { @Column(name="ADDRESS_ID") }, generator = "increment-gen", type = @Type(type="long"))
	
	private Collection<Address> listofAddress = new ArrayList<Address>();
	
	public int getUserId() {
		return Id;
	}
	public Collection<Address> getListofAddress() {
		return listofAddress;
	}
	public void setListofAddress(Collection<Address> listofAddress) {
		this.listofAddress = listofAddress;
	}
	public void setUserId(int userId) {
		this.Id = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	
	

}
