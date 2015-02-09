package tec.uom.astronomy.solarsystem.properties.physical;

import javax.measure.Quantity;
import javax.measure.quantity.Length;
import javax.measure.quantity.Mass;
import javax.measure.quantity.Speed;
import javax.measure.quantity.Time;
import javax.measure.quantity.VolumetricDensity;

import tec.uom.astronomy.solarsystem.units.AstronomicalSystemOfUnits;
import tec.uom.se.quantity.QuantityFactoryProvider;
import tec.uom.se.util.SI;
import tec.uom.se.util.SIPrefix;

public abstract class CommonPhysicalProperties {
	/*
	 * public CommonPhysicalProperties(Albedo albdo, Quantity<Time>
	 * srlRotationPeriod, Quantity<Length> radius,Quantity<VolumetricDensity>
	 * density,Quantity<Mass> mass){ this.albedo = albdo;
	 * this.siderealRotationPeriod = srlRotationPeriod; this.meanRadius =
	 * radius; this.meanDensity = density; this.absoluteMass = mass; }
	 */
	private Albedo albedo = new Albedo();
	private Quantity<Time> siderealRotationPeriod = QuantityFactoryProvider
			.getQuantityFactory(Time.class).create(
					(Number) getSiderealRotationPeriod(), SI.DAY);
	private Quantity<Length> meanRadius = QuantityFactoryProvider
			.getQuantityFactory(Length.class).create((Number) getMeanRadius(),
					SIPrefix.KILO(SI.METRE));
	private Quantity<VolumetricDensity> meanDensity = QuantityFactoryProvider
			.getQuantityFactory(VolumetricDensity.class).create(
					(Number) getMeanDensity(),
					AstronomicalSystemOfUnits.GRAM_PER_CUBIC_CENTIMETRE);
	private Quantity<Mass> absoluteMass = QuantityFactoryProvider
			.getQuantityFactory(Mass.class).create((Number) getAbsoluteMass(),
					AstronomicalSystemOfUnits.SOLAR_MASS);

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
