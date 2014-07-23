package tmn.hibernate.tutorial._15;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Vehicle {
	@Id
	@GeneratedValue
	private int vehicleId;
	private String vehicleName;
	//@ManyToOne
	//@JoinColumn(name="USER_ID")
	@ManyToMany(mappedBy="vehicles")
	private Collection<UserDetail> userList  = new ArrayList<UserDetail>() ;
	
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	
	public Collection<UserDetail> getUserList() {
		return userList;
	}
	
	public void setUserList(Collection<UserDetail> userList) {
		this.userList = userList;
	}
	
}
