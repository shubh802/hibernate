package dto;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
// To have all the values in one single class the use discriminator column is just 
// for single table
//@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name="VEHICLE_TYPE",
//     				   discriminatorType=DiscriminatorType.STRING)

// To have inheritance in separate table
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)


public class Vehicle {
	
	@Id @GeneratedValue
	private int vehicleId;
	private String vehicleName;
	
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
	
	

}
