package tmn.hibernate.tutorial._17_18;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("BIKE")
public class TwoWheeler extends Vehicle {
	private String steeringHandle;
	
	
	public String getSteeringHandle() {
		return steeringHandle;
	}
	
	public void setSteeringHandle(String steeringHandle) {
		this.steeringHandle = steeringHandle;
	}
}
