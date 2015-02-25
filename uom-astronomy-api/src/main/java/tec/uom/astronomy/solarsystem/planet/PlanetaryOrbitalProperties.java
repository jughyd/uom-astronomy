package tec.uom.astronomy.solarsystem.planet;

import javax.measure.Quantity;
import javax.measure.UnitConverter;
import javax.measure.quantity.Angle;
import javax.measure.quantity.Length;
import javax.measure.quantity.Speed;
import javax.measure.quantity.Time;

import tec.uom.astronomy.solarsystem.properties.orbital.CommonOrbitalProperties;
import tec.uom.astronomy.solarsystem.properties.orbital.Inclination;
import tec.uom.astronomy.solarsystem.properties.orbital.Satellites;
import tec.uom.astronomy.solarsystem.units.AstronomicalSystemOfUnits;

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
		UnitConverter periphelionConverter = getPeriphelion().getUnit()
				.getConverterTo(AstronomicalSystemOfUnits.ASTRONOMICAL_UNIT);
		double periphelionValue = periphelionConverter
				.convert((double) getPeriphelion().getValue());
		UnitConverter aphelionConverter = getAphelion().getUnit()
				.getConverterTo(AstronomicalSystemOfUnits.ASTRONOMICAL_UNIT);
		double aphelionValue = aphelionConverter
				.convert((double) getAphelion().getValue());
		double eccentricity = 0;
		if (aphelionValue != 0 && periphelionValue != 0) {
			eccentricity = (aphelionValue - periphelionValue)
					/ (aphelionValue + periphelionValue);
		}
		return eccentricity;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(PlanetaryOrbitalProperties.class.getSimpleName());
		sb.append("- ");
		sb.append("Mean Anomaly: ");
		sb.append(getMeanAnomaly());
		sb.append("; ");
		sb.append("Average Orbital Speed: ");
		sb.append(getAverageOrbitalSpeed());
		sb.append("; ");
		sb.append("Aphelion: ");
		sb.append(getAphelion().getValue() + " " + getAphelion().getUnit().getSymbol());
		sb.append("; ");
		sb.append("Periphelion: ");
		sb.append(getPeriphelion().getValue() + " " + getPeriphelion().getUnit().getSymbol());
		sb.append("; ");
		sb.append("Semi Major Axis: ");
		sb.append(getSemiMajorAxis().getValue() + " " + getSemiMajorAxis().getUnit().getSymbol());
		sb.append("; ");
		sb.append("Orbital Period: ");
		sb.append(getOrbitalPeriod());
		sb.append("; ");
		sb.append("Ecliptic Inclination: ");
		sb.append(getInclination().getEclipticInclination());
		sb.append("; ");
		sb.append("Invariable Plane Inclination: ");
		sb.append(getInclination().getInvariablePlaneInclination());
		sb.append("; ");
		sb.append("Sun Equatorial Inclination: ");
		sb.append(getInclination().getSunEquatorInclination());
		sb.append("; ");
		sb.append("Artificial Satellites: ");
		sb.append(getSatellites().getArtificalSatellite());
		sb.append("; ");
		sb.append("Natural Satellites: ");
		sb.append(getSatellites().getNaturalSatellite());
		return sb.toString();
	}
}
