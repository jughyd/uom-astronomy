package tec.uom.astronomy.solarsystem.planet;

import javax.measure.Quantity;
import javax.measure.quantity.Pressure;

import tec.uom.astronomy.solarsystem.properties.atmospheric.CommonAtmosphericProperties;
import tec.uom.se.quantity.QuantityFactoryProvider;
import tec.uom.se.util.SI;
import tec.uom.se.util.SIPrefix;

public class PlanetaryAtmosphericProperties extends CommonAtmosphericProperties {
	private Quantity<Pressure> surfacePressure = QuantityFactoryProvider
			.getQuantityFactory(Pressure.class).create(
					(Number) getSurfacePressure(), SIPrefix.KILO(SI.PASCAL));

	public Quantity<Pressure> getSurfacePressure() {
		return surfacePressure;
	}

	public void setSurfacePressure(Quantity<Pressure> surfacePressure) {
		this.surfacePressure = surfacePressure;
	}
}
