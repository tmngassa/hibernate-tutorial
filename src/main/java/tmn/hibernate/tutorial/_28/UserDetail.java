package tmn.hibernate.tutorial._28;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

//Surraget key is a column that you add to a table to act only as primary key.

@Entity
@Table(name="UserDetail")
@NamedQuery(name= "UserDetail.byId",
			query = "from UserDetail where userId = ?")
@NamedNativeQuery(name="UserDetail.byName", query="select * from user_detail where userId = ?" , resultClass=UserDetail.class )
public class UserDetail {
	@Id
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
