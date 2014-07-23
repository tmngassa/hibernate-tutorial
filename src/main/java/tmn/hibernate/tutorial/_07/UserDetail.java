package tmn.hibernate.tutorial._07;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

//Surraget key is a column that you add to a table to act only as primary key.

@Entity
@Table(name = "USER_DETAIL")
public class UserDetail {
	@Id
	@Column(name = "USER_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int userId;
	//@Basic
	//@Transient   //not persisted
	private String userName;
	@Temporal(TemporalType.TIME)
	private Date joinDate;
	private String Address;
	@Lob
	private String description;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Column(name = "USER_NAME")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return  "[ "+ userId + ", " + userName + " , " + Address + " , " + joinDate + " , " + description + " ]";
	}
}
