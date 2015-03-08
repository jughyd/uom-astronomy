package tec.uom.astronomy.solarsystem.planet;

import javax.measure.Quantity;
import javax.measure.UnitConverter;
import javax.measure.quantity.Acceleration;
import javax.measure.quantity.Area;
import javax.measure.quantity.Length;
import javax.measure.quantity.Mass;
import javax.measure.quantity.Speed;
import javax.measure.quantity.Time;
import javax.measure.quantity.Volume;
import javax.measure.quantity.VolumetricDensity;

import tec.uom.astronomy.solarsystem.constants.AstronomicalConstants;
import tec.uom.astronomy.solarsystem.properties.general.AstronomicalUtility;
import tec.uom.astronomy.solarsystem.properties.physical.Albedo;
import tec.uom.astronomy.solarsystem.properties.physical.Circumference;
import tec.uom.astronomy.solarsystem.properties.physical.CommonPhysicalProperties;
import tec.uom.astronomy.solarsystem.units.AstronomicalSystemOfUnits;
import tec.uom.se.quantity.QuantityFactoryProvider;
import tec.uom.se.util.SI;
import tec.uom.se.util.SIPrefix;

public class PlanetaryPhysicalProperties extends CommonPhysicalProperties {

	private Quantity<Length> polarRadius;
	private Quantity<Length> equatorialRadius;
	private Circumference circumference;
	private Quantity<Speed> equatorialRotationVelocity;
	private double momentOfInertia;

	public PlanetaryPhysicalProperties(Quantity<Length> polRadius,
			Quantity<Length> equRadius, Quantity<Speed> equRotationVelocity,
			double momOfInertia, Circumference circum,
			Quantity<Time> sidRotationPeriod, Quantity<Length> radius,
			Quantity<VolumetricDensity> density, Quantity<Mass> mass,
			Albedo albdo) {
		super(sidRotationPeriod, radius, density, mass, albdo);
		this.polarRadius = polRadius;
		this.equatorialRadius = equRadius;
		this.equatorialRotationVelocity = equRotationVelocity;
		this.circumference = circum;
		this.momentOfInertia = momOfInertia;
	}

	public double getMomentOfInertia() {
		return momentOfInertia;
	}

	public Quantity<Length> getPolarRadius() {
		return polarRadius;
	}

	public Quantity<Length> getEquatorialRadius() {
		return equatorialRadius;
	}

	public Circumference getCircumference() {
		return circumference;
	}

	public Quantity<Speed> getEquatorialRotationVelocity() {
		return equatorialRotationVelocity;
	}

	public double flattening() {
		double polarRadiusValue = (double) getPolarRadius().to(
				SIPrefix.KILO(SI.METRE)).getValue();
		double equatorialRadiusValue = (double) getEquatorialRadius().to(
				SIPrefix.KILO(SI.METRE)).getValue();
		double flatten = (equatorialRadiusValue - polarRadiusValue)
				/ equatorialRadiusValue;
		return flatten;
	}

	public Quantity<Area> surfaceArea() {
		double polarRadiusValue = (double) getPolarRadius().to(
				SIPrefix.KILO(SI.METRE)).getValue();
		double equatorialRadiusValue = (double) getEquatorialRadius().to(
				SIPrefix.KILO(SI.METRE)).getValue();
		double ellipticalEccentricity = 0;
		double surfaceAreaValue = 0;
		if (polarRadiusValue != 0 && equatorialRadiusValue != 0) {
			if (polarRadiusValue < equatorialRadiusValue) {
				ellipticalEccentricity = Math.sqrt(1 - (Math.pow(
						polarRadiusValue, 2) / Math.pow(equatorialRadiusValue,
						2)));
				double tanHyperbolicInverse = 0;
				if (ellipticalEccentricity < 1 && ellipticalEccentricity > -1) {
					tanHyperbolicInverse = Math
							.log((ellipticalEccentricity + 1.0)
									/ (1.0 - ellipticalEccentricity));
				} else if (ellipticalEccentricity > 1) {
					tanHyperbolicInverse = Math
							.log((ellipticalEccentricity + 1.0)
									/ (ellipticalEccentricity - 1.0));
				}
				surfaceAreaValue = 2
						* AstronomicalConstants.PI
						* Math.pow(equatorialRadiusValue, 2)
						* (1 + (((1 - Math.pow(ellipticalEccentricity, 2)) / ellipticalEccentricity) * (0.5 * tanHyperbolicInverse)));
			}
			if (polarRadiusValue > equatorialRadiusValue) {
				ellipticalEccentricity = Math.sqrt(1 - (Math.pow(
						equatorialRadiusValue, 2) / Math.pow(polarRadiusValue,
						2)));
				surfaceAreaValue = 2
						* AstronomicalConstants.PI
						* Math.pow(equatorialRadiusValue, 2)
						* (1 + (polarRadiusValue / (equatorialRadiusValue * ellipticalEccentricity))
								* (Math.asin(ellipticalEccentricity)));
			}
		}
		Quantity<Area> surfaceArea = QuantityFactoryProvider
				.getQuantityFactory(Area.class).create(surfaceAreaValue,
						AstronomicalSystemOfUnits.SQUARE_KILOMETRE);
		return surfaceArea;
	}

	public Quantity<Volume> planetVolume() {
		double polarRadiusValue = (double) getPolarRadius().to(
				SIPrefix.KILO(SI.METRE)).getValue();
		double equatorialRadiusValue = (double) getEquatorialRadius().to(
				SIPrefix.KILO(SI.METRE)).getValue();
		double meanRadiusValue = (double) getMeanRadius().to(
				SIPrefix.KILO(SI.METRE)).getValue();
		double volumeValue = 0;
		if (polarRadiusValue != 0 && equatorialRadiusValue != 0
				&& meanRadiusValue != 0) {
			volumeValue = (4 / 3) * AstronomicalConstants.PI * polarRadiusValue
					* equatorialRadiusValue * meanRadiusValue;
		} else if (meanRadiusValue != 0 && polarRadiusValue == 0
				&& equatorialRadiusValue == 0) {
			volumeValue = (4 / 3) * AstronomicalConstants.PI
					* Math.pow(polarRadiusValue, 3);
		}
		Quantity<Volume> planetVolume = QuantityFactoryProvider
				.getQuantityFactory(Volume.class).create(volumeValue,
						AstronomicalSystemOfUnits.CUBIC_KILOMETRE);
		return planetVolume;
	}

	public Quantity<Acceleration> surfaceGravity() {
		double meanRadiusValue = (double) getMeanRadius().to(
				SIPrefix.KILO(SI.METRE)).getValue();
		double massValue = (double) getAbsoluteMass().to(SI.KILOGRAM)
				.getValue();
		double gravityValue = (AstronomicalConstants.EARTH_GRAVITATIONAL_CONSTANT * massValue)
				/ Math.pow(meanRadiusValue, 2);
		Quantity<Acceleration> gravity = QuantityFactoryProvider
				.getQuantityFactory(Acceleration.class).create(gravityValue,
						SI.METRES_PER_SQUARE_SECOND);
		return gravity;
	}

	@Override
	public Quantity<Speed> escapeVelocity() {
		double meanRadiusValue = (double) getMeanRadius().to(
				SIPrefix.KILO(SI.METRE)).getValue();
		double massValue = (double) getAbsoluteMass().to(SI.KILOGRAM)
				.getValue();
		double escVelResult = Math
				.sqrt((2 * AstronomicalConstants.EARTH_GRAVITATIONAL_CONSTANT * massValue)
						/ meanRadiusValue);
		Quantity<Speed> escapeVelocity = QuantityFactoryProvider
				.getQuantityFactory(Speed.class).create(escVelResult,
						SI.METRES_PER_SECOND);
		return escapeVelocity;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(PlanetaryPhysicalProperties.class.getSimpleName());
		sb.append("- ");
		sb.append("Moment Of Inertia: ");
		sb.append(getMomentOfInertia());
		sb.append("; ");
		sb.append("Polar Radius: ");
		sb.append(AstronomicalUtility.getValueUnit(getPolarRadius()));
		sb.append("; ");
		sb.append("Equatorial Radius: ");
		sb.append(AstronomicalUtility.getValueUnit(getEquatorialRadius()));
		sb.append("; ");
		sb.append("Equatorial Circumference: ");
		sb.append(AstronomicalUtility.getValueUnit(getCircumference()
				.getEquatorialCircumference()));
		sb.append("; ");
		sb.append("Meridonial Circumference: ");
		sb.append(AstronomicalUtility.getValueUnit(getCircumference()
				.getMeridonialCircumference()));
		sb.append("; ");
		sb.append("Equatorial Rotational Velocity: ");
		sb.append(AstronomicalUtility
				.getValueUnit(getEquatorialRotationVelocity()));
		sb.append("; ");
		sb.append("Sidereal Rotation Period: ");
		sb.append(AstronomicalUtility.getValueUnit(getSiderealRotationPeriod()));
		sb.append("; ");
		sb.append("Mean Radius: ");
		sb.append(AstronomicalUtility.getValueUnit(getMeanRadius()));
		sb.append("; ");
		sb.append("Mean Density: ");
		sb.append(AstronomicalUtility.getValueUnit(getMeanDensity()));
		sb.append("; ");
		sb.append("Absolute Mass: ");
		sb.append(AstronomicalUtility.getValueUnit(getAbsoluteMass()));
		sb.append("; ");
		sb.append("Bond Albedo: ");
		sb.append(getAlbedo().getBondAlbedo());
		sb.append("; ");
		sb.append("Geometric Albedo: ");
		sb.append(getAlbedo().getGeometricAlbedo());
		sb.append("; ");
		sb.append("Flattening: ");
		sb.append(flattening());
		sb.append("; ");
		sb.append("Surface Area: ");
		sb.append(AstronomicalUtility.getValueUnit(surfaceArea()));
		sb.append("; ");
		sb.append("Planet Volume: ");
		sb.append(AstronomicalUtility.getValueUnit(planetVolume()));
		sb.append("; ");
		sb.append("Surface Gravity: ");
		sb.append(AstronomicalUtility.getValueUnit(surfaceGravity()));
		sb.append("; ");
		sb.append("Escape Velocity: ");
		sb.append(AstronomicalUtility.getValueUnit(escapeVelocity()));
		return sb.toString();
	}
}
