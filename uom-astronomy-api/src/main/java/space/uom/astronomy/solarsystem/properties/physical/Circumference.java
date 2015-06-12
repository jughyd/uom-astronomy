package space.uom.astronomy.solarsystem.properties.physical;

import javax.measure.Quantity;
import javax.measure.quantity.Length;

public class Circumference {
	private Quantity<Length> equatorialCircumference;
	private Quantity<Length> meridonialCircumference;

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
