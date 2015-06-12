package space.uom.astronomy.solarsystem.planet;

import javax.measure.Quantity;
import javax.measure.quantity.Angle;
import javax.measure.quantity.Length;
import javax.measure.quantity.Speed;
import javax.measure.quantity.Time;

import space.uom.astronomy.solarsystem.properties.general.AstronomicalUtility;
import space.uom.astronomy.solarsystem.properties.orbital.CommonOrbitalProperties;
import space.uom.astronomy.solarsystem.properties.orbital.Inclination;
import space.uom.astronomy.solarsystem.properties.orbital.Satellites;
import space.uom.astronomy.solarsystem.units.AstronomicalSystemOfUnits;

public class PlanetaryOrbitalProperties extends CommonOrbitalProperties {

	private Satellites satellites;
	private Quantity<Angle> meanAnomaly;
	private Quantity<Speed> averageOrbitalSpeed;

	public PlanetaryOrbitalProperties(Quantity<Angle> anomaly,
			Quantity<Speed> orbitalSpeed, Satellites satel,
			Quantity<Length> aphlion, Quantity<Length> periphlion,
			Quantity<Length> semiMajAxis, Quantity<Time> orbitPeriod,
			Inclination inclin) {
		super(aphlion, periphlion, semiMajAxis, orbitPeriod, inclin);
		this.meanAnomaly = anomaly;
		this.averageOrbitalSpeed = orbitalSpeed;
		this.satellites = satel;
	}

	public Quantity<Angle> getMeanAnomaly() {
		return meanAnomaly;
	}

	public Quantity<Speed> getAverageOrbitalSpeed() {
		return averageOrbitalSpeed;
	}

	public Satellites getSatellites() {
		return satellites;
	}

	public double calculateEccentricity() {
		double eccentricity = 0;
		if (getPeriphelion() != null && getAphelion() != null) {
			double periphelionValue = (double) getPeriphelion().to(
					AstronomicalSystemOfUnits.ASTRONOMICAL_UNIT).getValue();
			double aphelionValue = (double) getAphelion().to(
					AstronomicalSystemOfUnits.ASTRONOMICAL_UNIT).getValue();
			if (aphelionValue != 0 && periphelionValue != 0) {
				eccentricity = (aphelionValue - periphelionValue)
						/ (aphelionValue + periphelionValue);
			}
		}
		return eccentricity;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(PlanetaryOrbitalProperties.class.getSimpleName());
		sb.append("- ");
		if (getMeanAnomaly() != null) {
			sb.append("Mean Anomaly: ");
			sb.append(AstronomicalUtility.getValueUnit(getMeanAnomaly()));
			sb.append("; ");
		}
		if (getAverageOrbitalSpeed() != null) {
			sb.append("Average Orbital Speed: ");
			sb.append(AstronomicalUtility
					.getValueUnit(getAverageOrbitalSpeed()));
			sb.append("; ");
		}
		if (getAphelion() != null) {
			sb.append("Aphelion: ");
			sb.append(AstronomicalUtility.getValueUnit(getAphelion()));
			sb.append("; ");
		}
		if (getPeriphelion() != null) {
			sb.append("Periphelion: ");
			sb.append(AstronomicalUtility.getValueUnit(getPeriphelion()));
			sb.append("; ");
		}
		if (getSemiMajorAxis() != null) {
			sb.append("Semi Major Axis: ");
			sb.append(AstronomicalUtility.getValueUnit(getSemiMajorAxis()));
			sb.append("; ");
		}
		if (getOrbitalPeriod() != null) {
			sb.append("Orbital Period: ");
			sb.append(AstronomicalUtility.getValueUnit(getOrbitalPeriod()));
			sb.append("; ");
		}
		if (getInclination().getEclipticInclination() != null) {
			sb.append("Ecliptic Inclination: ");
			sb.append(AstronomicalUtility.getValueUnit(getInclination()
					.getEclipticInclination()));
			sb.append("; ");
		}
		if (getInclination().getInvariablePlaneInclination() != null) {
			sb.append("Invariable Plane Inclination: ");
			sb.append(AstronomicalUtility.getValueUnit(getInclination()
					.getInvariablePlaneInclination()));
			sb.append("; ");
		}
		if (getInclination().getSunEquatorInclination() != null) {
			sb.append("Sun Equatorial Inclination: ");
			sb.append(AstronomicalUtility.getValueUnit(getInclination()
					.getSunEquatorInclination()));
			sb.append("; ");
		}
		sb.append("Artificial Satellites: ");
		sb.append(getSatellites().getArtificalSatellite());
		sb.append("; ");
		sb.append("Natural Satellites: ");
		sb.append(getSatellites().getNaturalSatellite());
		return sb.toString();
	}
}
