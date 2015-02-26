package tec.uom.astronomy.solarsystem.planet;

import java.util.List;

import javax.measure.Quantity;
import javax.measure.quantity.Pressure;
import javax.measure.quantity.Temperature;

import tec.uom.astronomy.solarsystem.properties.atmospheric.CommonAtmosphericProperties;
import tec.uom.astronomy.solarsystem.properties.general.AstronomicalUtility;

public class PlanetaryAtmosphericProperties extends CommonAtmosphericProperties {
	private Quantity<Pressure> surfacePressure;

	public PlanetaryAtmosphericProperties(Quantity<Pressure> surfPressure,
			Quantity<Temperature> surfaceTemperature,
			List<String> atmospherComposition) {
		super(surfaceTemperature, atmospherComposition);
		this.surfacePressure = surfPressure;
	}

	public Quantity<Pressure> getSurfacePressure() {
		return surfacePressure;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(PlanetaryAtmosphericProperties.class.getSimpleName());
		sb.append("- ");
		sb.append("Surface Pressure: ");
		sb.append(AstronomicalUtility.getValueUnit(getSurfacePressure()));
		sb.append("; ");
		sb.append("Mean Surface Temperature: ");
		sb.append(AstronomicalUtility.getValueUnit(getMeanSurfaceTemperature()));
		sb.append("; ");
		sb.append("Atmospheric Composition: ");
		sb.append(getAtmosphericComposition());
		return sb.toString();
	}
}
