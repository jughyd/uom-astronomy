package space.uom.astronomy.solarsystem.properties.orbital;

import javax.measure.Quantity;
import javax.measure.quantity.Length;
import javax.measure.quantity.Time;

public abstract class CommonOrbitalProperties {
	private Quantity<Length> aphelion;
	private Quantity<Length> periphelion;
	private Quantity<Length> semiMajorAxis;
	private Quantity<Time> orbitalPeriod;
	private Inclination inclination;

	public CommonOrbitalProperties(Quantity<Length> aphlion,
			Quantity<Length> periphlion, 
			Quantity<Length> semiMajAxis,
			Quantity<Time> orbitPeriod,
			Inclination inclin) {
		this.aphelion = aphlion;
		this.periphelion = periphlion;
		this.semiMajorAxis = semiMajAxis;
		this.orbitalPeriod = orbitPeriod;
		this.inclination = inclin;
	}

	public Quantity<Time> getOrbitalPeriod() {
		return orbitalPeriod;
	}

	public Quantity<Length> getAphelion() {
		return aphelion;
	}

	public Quantity<Length> getPeriphelion() {
		return periphelion;
	}

	public Quantity<Length> getSemiMajorAxis() {
		return semiMajorAxis;
	}

	public Inclination getInclination() {
		return inclination;
	}

}
