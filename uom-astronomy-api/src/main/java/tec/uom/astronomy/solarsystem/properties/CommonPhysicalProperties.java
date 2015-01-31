package tec.uom.astronomy.solarsystem.properties;

import javax.measure.Quantity;
import javax.measure.quantity.Length;

import tec.uom.astronomy.solarsystem.units.AstronomicalSystemOfUnits;
import tec.uom.se.quantity.QuantityFactoryProvider;


public class CommonPhysicalProperties {
	Quantity<Length> albedo =  QuantityFactoryProvider.getQuantityFactory(Length.class).create((Number) getAlbedo(), AstronomicalSystemOfUnits.ASTRONOMICAL_UNIT);
	Quantity<Length> siderealRotationPeriod =  QuantityFactoryProvider.getQuantityFactory(Length.class).create((Number) getSiderealRotationPeriod(), AstronomicalSystemOfUnits.ASTRONOMICAL_UNIT);
	Quantity<Length> meanRadius =  QuantityFactoryProvider.getQuantityFactory(Length.class).create((Number) getMeanRadius(), AstronomicalSystemOfUnits.ASTRONOMICAL_UNIT);
	Quantity<Length> meanDensity =  QuantityFactoryProvider.getQuantityFactory(Length.class).create((Number) getMeanDensity(), AstronomicalSystemOfUnits.ASTRONOMICAL_UNIT);
	Quantity<Mass>
	public Quantity<Length> getMeanDensity() {
		return meanDensity;
	}
	public void setMeanDensity(Quantity<Length> meanDensity) {
		this.meanDensity = meanDensity;
	}
	public Quantity<Length> getAlbedo() {
		return albedo;
	}
	public void setAlbedo(Quantity<Length> albedo) {
		this.albedo = albedo;
	}
	public Quantity<Length> getSiderealRotationPeriod() {
		return siderealRotationPeriod;
	}
	public void setSiderealRotationPeriod(Quantity<Length> siderealRotationPeriod) {
		this.siderealRotationPeriod = siderealRotationPeriod;
	}
	public Quantity<Length> getMeanRadius() {
		return meanRadius;
	}
	public void setMeanRadius(Quantity<Length> meanRadius) {
		this.meanRadius = meanRadius;
	}
}
