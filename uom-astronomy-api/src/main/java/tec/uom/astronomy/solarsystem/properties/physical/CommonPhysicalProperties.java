package tec.uom.astronomy.solarsystem.properties.physical;

import javax.measure.Quantity;
import javax.measure.quantity.Length;
import javax.measure.quantity.Mass;
import javax.measure.quantity.Speed;
import javax.measure.quantity.Time;
import javax.measure.quantity.VolumetricDensity;

public abstract class CommonPhysicalProperties {

	private Albedo albedo = new Albedo();
	private Quantity<Time> siderealRotationPeriod;
	private Quantity<Length> meanRadius;
	private Quantity<VolumetricDensity> meanDensity;
	private Quantity<Mass> absoluteMass;

	public abstract Quantity<Speed> escapeVelocity();

	public Quantity<Mass> getAbsoluteMass() {
		return absoluteMass;
	}

	public void setAbsoluteMass(Quantity<Mass> absoluteMass) {
		this.absoluteMass = absoluteMass;
	}

	public Quantity<VolumetricDensity> getMeanDensity() {
		return meanDensity;
	}

	public void setMeanDensity(Quantity<VolumetricDensity> meanDensity) {
		this.meanDensity = meanDensity;
	}

	public Quantity<Time> getSiderealRotationPeriod() {
		return siderealRotationPeriod;
	}

	public void setSiderealRotationPeriod(Quantity<Time> siderealRotationPeriod) {
		this.siderealRotationPeriod = siderealRotationPeriod;
	}

	public Quantity<Length> getMeanRadius() {
		return meanRadius;
	}

	public void setMeanRadius(Quantity<Length> meanRadius) {
		this.meanRadius = meanRadius;
	}

	public Albedo getAlbedo() {
		return albedo;
	}

	public void setAlbedo(Albedo albedo) {
		this.albedo = albedo;
	}
}
