package space.uom.astronomy.solarsystem.properties.atmospheric;

import java.util.ArrayList;
import java.util.List;

import javax.measure.Quantity;
import javax.measure.quantity.Temperature;

public abstract class CommonAtmosphericProperties {
	private Quantity<Temperature> meanSurfaceTemperature;
	private List<String> atmosphericComposition = new ArrayList<String>();

	public CommonAtmosphericProperties(
			Quantity<Temperature> surfaceTemperature,
			List<String> atmospherComposition) {
		this.meanSurfaceTemperature = surfaceTemperature;
		this.atmosphericComposition = atmospherComposition;
	}

	public Quantity<Temperature> getMeanSurfaceTemperature() {
		return meanSurfaceTemperature;
	}

	public List<String> getAtmosphericComposition() {
		return atmosphericComposition;
	}
}
