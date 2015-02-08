package tec.uom.astronomy.solarsystem.properties.orbital;

import javax.measure.Quantity;
import javax.measure.quantity.Angle;

import tec.uom.se.quantity.QuantityFactoryProvider;
import tec.uom.se.util.SI;

public class Inclination {
	private Quantity<Angle> eclipticInclination = QuantityFactoryProvider.getQuantityFactory(Angle.class).create((Number) getEclipticInclination(), SI.DEGREE_ANGLE );;
	private Quantity<Angle> invariablePlaneInclination = QuantityFactoryProvider.getQuantityFactory(Angle.class).create((Number) getInvariablePlaneInclination(), SI.DEGREE_ANGLE );;
	private Quantity<Angle> sunEquatorInclination = QuantityFactoryProvider.getQuantityFactory(Angle.class).create((Number) getSunEquatorInclination(), SI.DEGREE_ANGLE );;
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
