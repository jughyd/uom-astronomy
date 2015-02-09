package tec.uom.astronomy.solarsystem.properties.atmospheric;

import java.util.ArrayList;
import java.util.List;

import javax.measure.Quantity;
import javax.measure.quantity.Temperature;

public abstract class CommonAtmosphericProperties {
	private Quantity<Temperature> meanSurfaceTemperature;
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
