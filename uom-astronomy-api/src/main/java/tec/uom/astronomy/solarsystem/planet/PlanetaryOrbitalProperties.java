package tec.uom.astronomy.solarsystem.planet;

import javax.measure.Quantity;
import javax.measure.UnitConverter;
import javax.measure.quantity.Angle;
import javax.measure.quantity.Speed;

import tec.uom.astronomy.solarsystem.properties.orbital.CommonOrbitalProperties;
import tec.uom.astronomy.solarsystem.properties.orbital.Satellites;
import tec.uom.astronomy.solarsystem.units.AstronomicalSystemOfUnits;

public class PlanetaryOrbitalProperties extends CommonOrbitalProperties {

	private Satellites satellites = new Satellites();
	private Quantity<Angle> meanAnomaly;
	private Quantity<Speed> averageOrbitalSpeed;

	public Quantity<Angle> getMeanAnomaly() {
		return meanAnomaly;
	}

	public Quantity<Speed> getAverageOrbitalSpeed() {
		return averageOrbitalSpeed;
	}

	public void setAverageOrbitalSpeed(Quantity<Speed> averageOrbitalSpeed) {
		this.averageOrbitalSpeed = averageOrbitalSpeed;
	}

	public void setMeanAnomaly(Quantity<Angle> meanAnomaly) {
		this.meanAnomaly = meanAnomaly;
	}

	public Satellites getSatellites() {
		return satellites;
	}

	public void setSatellites(Satellites satellites) {
		this.satellites = satellites;
	}

	public double calculateEccentricity() {
		UnitConverter periphelionConverter = getPeriphelion().getUnit()
				.getConverterTo(AstronomicalSystemOfUnits.ASTRONOMICAL_UNIT);
		double periphelionValue = periphelionConverter.convert((double) getPeriphelion()
				.getValue());
		UnitConverter aphelionConverter = getAphelion().getUnit()
				.getConverterTo(AstronomicalSystemOfUnits.ASTRONOMICAL_UNIT);
		double aphelionValue = aphelionConverter.convert((double) getAphelion()
				.getValue());
		
		double eccentricity = 0;
		if (aphelionValue != 0 && periphelionValue != 0) {
			eccentricity = (aphelionValue - periphelionValue)
					/ (aphelionValue + periphelionValue);
		}
		return eccentricity;
	}

}
