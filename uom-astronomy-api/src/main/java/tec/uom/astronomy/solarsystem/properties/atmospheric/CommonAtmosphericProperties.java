package tec.uom.astronomy.solarsystem.properties.atmospheric;

import java.util.ArrayList;
import java.util.List;

import javax.measure.Quantity;
import javax.measure.quantity.Temperature;

import tec.uom.se.quantity.QuantityFactoryProvider;
import tec.uom.se.util.SI;

public abstract class CommonAtmosphericProperties {
	private Quantity<Temperature> meanSurfaceTemperature = QuantityFactoryProvider
			.getQuantityFactory(Temperature.class).create(
					(Number) getMeanSurfaceTemperature(), SI.KELVIN);
	private List<String> atmosphericComposition = new ArrayList<String>();

	public Quantity<Temperature> getMeanSurfaceTemperature() {
		return meanSurfaceTemperature;
	}

	public void setMeanSurfaceTemperature(
			Quantity<Temperature> meanSurfaceTemperature) {
		this.meanSurfaceTemperature = meanSurfaceTemperature;
	}

	public List<String> getAtmosphericComposition() {
		return atmosphericComposition;
	}

	public void setAtmosphericComposition(List<String> atmosphericComposition) {
		this.atmosphericComposition = atmosphericComposition;
	}
}
