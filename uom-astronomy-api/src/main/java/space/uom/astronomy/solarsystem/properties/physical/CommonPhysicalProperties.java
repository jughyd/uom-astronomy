package space.uom.astronomy.solarsystem.properties.physical;

import javax.measure.Quantity;
import javax.measure.quantity.Length;
import javax.measure.quantity.Mass;
import javax.measure.quantity.Speed;
import javax.measure.quantity.Time;
import javax.measure.quantity.VolumetricDensity;

public abstract class CommonPhysicalProperties {

	private Quantity<Time> siderealRotationPeriod;
	private Quantity<Length> meanRadius;
	private Quantity<VolumetricDensity> meanDensity;
	private Quantity<Mass> absoluteMass;
	private Albedo albedo;
	
	public CommonPhysicalProperties(Quantity<Time> sidRotationPeriod,
			Quantity<Length> radius,
			Quantity<VolumetricDensity> density,
			Quantity<Mass> mass,
			Albedo albdo) {
		this.siderealRotationPeriod = sidRotationPeriod;
		this.meanRadius = radius;
		this.meanDensity = density;
		this.absoluteMass = mass;
		this.albedo = albdo;
	}
	
	public Quantity<Mass> getAbsoluteMass() {
		return absoluteMass;
	}

	public Quantity<VolumetricDensity> getMeanDensity() {
		return meanDensity;
	}

	public Quantity<Time> getSiderealRotationPeriod() {
		return siderealRotationPeriod;
	}

	public Quantity<Length> getMeanRadius() {
		return meanRadius;
	}

	public Albedo getAlbedo() {
		return albedo;
	}

	public abstract Quantity<Speed> escapeVelocity();
}
