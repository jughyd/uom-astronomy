package tec.uom.astronomy.solarsystem.planet;

import javax.measure.Quantity;
import javax.measure.quantity.Pressure;

import tec.uom.astronomy.solarsystem.properties.atmospheric.CommonAtmosphericProperties;

public class PlanetaryAtmosphericProperties extends CommonAtmosphericProperties {
	private Quantity<Pressure> surfacePressure;

	public Quantity<Pressure> getSurfacePressure() {
		return surfacePressure;
	}

	public void setSurfacePressure(Quantity<Pressure> surfacePressure) {
		this.surfacePressure = surfacePressure;
	}
}
