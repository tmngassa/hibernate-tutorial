package tmn.hibernate.tutorial._14;


import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//Surraget key is a column that you add to a table to act only as primary key.

@Entity
@Table(name = "USER_DETAIL")
public class UserDetail {
	@Id
	@Column(name = "USER_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	private String userName;	
	@OneToMany()
	@JoinTable(name="USER_VEHICLE", joinColumns=@JoinColumn(name="USER_ID"),
		inverseJoinColumns = @JoinColumn(name="VEHICLE_ID")
	)
	private Collection<Vehicle> vehicles = new ArrayList<Vehicle>();;
	
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
	public Collection<Vehicle> getVehicles() {
		return vehicles;
	}
	public void setVehicles(Collection<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}
	
	
}
