package tmn.hibernate.tutorial._24;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//Surraget key is a column that you add to a table to act only as primary key.

@Entity
@org.hibernate.annotations.Entity(selectBeforeUpdate=true)
public class UserDetail {
	@Id
	@Column(name = "USER_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	private String userName;	
	
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
	
	@Override
	public String toString() {
		return "\nUserDetail: [ ID: " + userId + " , userName: " + userName + " ]";
	}
	
}
