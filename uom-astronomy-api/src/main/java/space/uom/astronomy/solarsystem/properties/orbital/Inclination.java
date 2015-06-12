package space.uom.astronomy.solarsystem.properties.orbital;

import javax.measure.Quantity;
import javax.measure.quantity.Angle;

public class Inclination {
	private Quantity<Angle> eclipticInclination;
	private Quantity<Angle> invariablePlaneInclination;
	private Quantity<Angle> sunEquatorInclination;

	public Quantity<Angle> getEclipticInclination() {
		return eclipticInclination;
	}

	public void setEclipticInclination(Quantity<Angle> eclipticInclination) {
		this.eclipticInclination = eclipticInclination;
	}

	public Quantity<Angle> getInvariablePlaneInclination() {
		return invariablePlaneInclination;
	}

	public void setInvariablePlaneInclination(
			Quantity<Angle> invariablePlaneInclination) {
		this.invariablePlaneInclination = invariablePlaneInclination;
	}

	public Quantity<Angle> getSunEquatorInclination() {
		return sunEquatorInclination;
	}

	public void setSunEquatorInclination(Quantity<Angle> sunEquatorInclination) {
		this.sunEquatorInclination = sunEquatorInclination;
	}
}
