package tmn.hibernate.tutorial._06;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author tomson@work
 *
 */
@Entity
@Table(name="USER_DETAILS")
public class UserDetails {
	@Id
	@Column(name = "USER_ID")
	private int userId;
	//@Basic
	//@Transient   //not persisted
	@Column(name = "USER_NAME")
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

}
