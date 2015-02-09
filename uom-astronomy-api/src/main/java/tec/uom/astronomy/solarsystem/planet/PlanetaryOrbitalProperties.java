package tec.uom.astronomy.solarsystem.planet;

import javax.measure.Quantity;
import javax.measure.quantity.Angle;
import javax.measure.quantity.Speed;

import tec.uom.astronomy.solarsystem.properties.orbital.CommonOrbitalProperties;
import tec.uom.astronomy.solarsystem.properties.orbital.Satellites;
import tec.uom.se.quantity.QuantityFactoryProvider;
import tec.uom.se.util.SI;

public class PlanetaryOrbitalProperties extends CommonOrbitalProperties {

	private Satellites satellites = new Satellites();
	private Quantity<Angle> meanAnomaly = QuantityFactoryProvider
			.getQuantityFactory(Angle.class).create((Number) getMeanAnomaly(),
					SI.DEGREE_ANGLE);
	private Quantity<Speed> averageOrbitalSpeed = QuantityFactoryProvider
			.getQuantityFactory(Speed.class).create(
					(Number) getAverageOrbitalSpeed(), SI.METRES_PER_SECOND);

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
		double aphelionValue = (double) getAphelion().getValue();
		double periphelionValue = (double) getPeriphelion().getValue();
		double eccentricity = 0;
		if (aphelionValue != 0 && periphelionValue != 0) {
			eccentricity = (aphelionValue - periphelionValue)
					/ (aphelionValue + periphelionValue);
		}
		return eccentricity;
	}

}
