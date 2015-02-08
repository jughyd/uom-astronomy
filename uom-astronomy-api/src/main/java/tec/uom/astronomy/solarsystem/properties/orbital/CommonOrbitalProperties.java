package tec.uom.astronomy.solarsystem.properties.orbital;

import javax.measure.Quantity;
import javax.measure.quantity.Length;
import javax.measure.quantity.Time;

import tec.uom.astronomy.solarsystem.units.AstronomicalSystemOfUnits;
import tec.uom.se.quantity.QuantityFactoryProvider;
import tec.uom.se.util.SI;

public abstract class CommonOrbitalProperties {
	private Quantity<Length> aphelion = QuantityFactoryProvider
			.getQuantityFactory(Length.class).create((Number) getAphelion(),
					AstronomicalSystemOfUnits.ASTRONOMICAL_UNIT);
	private Quantity<Length> periphelion = QuantityFactoryProvider
			.getQuantityFactory(Length.class).create((Number) getPeriphelion(),
					AstronomicalSystemOfUnits.ASTRONOMICAL_UNIT);
	private Quantity<Length> semiMajorAxis = QuantityFactoryProvider
			.getQuantityFactory(Length.class).create(
					(Number) getSemiMajorAxis(),
					AstronomicalSystemOfUnits.ASTRONOMICAL_UNIT);
	private Quantity<Time> orbitalPeriod = QuantityFactoryProvider
			.getQuantityFactory(Time.class).create((Number) getOrbitalPeriod(),
					SI.DAY);
	private Inclination inclination = new Inclination();

	public Quantity<Time> getOrbitalPeriod() {
		return orbitalPeriod;
	}

	public void setOrbitalPeriod(Quantity<Time> orbitalPeriod) {
		this.orbitalPeriod = orbitalPeriod;
	}

	public Quantity<Length> getAphelion() {
		return aphelion;
	}

	public void setAphelion(Quantity<Length> aphelion) {
		this.aphelion = aphelion;
	}

	public Quantity<Length> getPeriphelion() {
		return periphelion;
	}

	public void setPeriphelion(Quantity<Length> periphelion) {
		this.periphelion = periphelion;
	}

	public Quantity<Length> getSemiMajorAxis() {
		return semiMajorAxis;
	}

	public void setSemiMajorAxis(Quantity<Length> semiMajorAxis) {
		this.semiMajorAxis = semiMajorAxis;
	}

	public Inclination getInclination() {
		return inclination;
	}

	public void setInclination(Inclination inclination) {
		this.inclination = inclination;
	}
}
