package tec.uom.astronomy.solarsystem.properties.physical;

import javax.measure.Quantity;
import javax.measure.quantity.Length;

import tec.uom.se.quantity.QuantityFactoryProvider;
import tec.uom.se.util.SI;
import tec.uom.se.util.SIPrefix;

public class Circumference {
	private Quantity<Length> equatorialCircumference = QuantityFactoryProvider
			.getQuantityFactory(Length.class).create(
					(Number) getEquatorialCircumference(),
					SIPrefix.KILO(SI.METRE));
	private Quantity<Length> meridonialCircumference = QuantityFactoryProvider
			.getQuantityFactory(Length.class).create(
					(Number) getMeridonialCircumference(),
					SIPrefix.KILO(SI.METRE));

	public Quantity<Length> getEquatorialCircumference() {
		return equatorialCircumference;
	}

	public void setEquatorialCircumference(
			Quantity<Length> equatorialCircumference) {
		this.equatorialCircumference = equatorialCircumference;
	}

	public Quantity<Length> getMeridonialCircumference() {
		return meridonialCircumference;
	}

	public void setMeridonialCircumference(
			Quantity<Length> meridonialCircumference) {
		this.meridonialCircumference = meridonialCircumference;
	}
}
