package tmn.hibernate.tutorial._17_18;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CAR")
public class FourWheeler extends Vehicle {
	private String steeringWheel;
	
	public void setSteeringWheel(String steeringWheel) {
		this.steeringWheel = steeringWheel;
	}
	
	public String getSteeringWheel() {
		return steeringWheel;
	}
	
}
