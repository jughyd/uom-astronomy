package tec.uom.astronomy.solarsystem.properties.orbital;

import javax.measure.Quantity;
import javax.measure.quantity.Length;
import javax.measure.quantity.Time;

public abstract class CommonOrbitalProperties {
	private Quantity<Length> aphelion;
	private Quantity<Length> periphelion;
	private Quantity<Length> semiMajorAxis;
	private Quantity<Time> orbitalPeriod;
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
