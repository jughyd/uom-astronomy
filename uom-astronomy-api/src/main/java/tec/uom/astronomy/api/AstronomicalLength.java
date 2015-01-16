package tec.uom.astronomy.api;

import javax.measure.quantity.Length;
import javax.measure.test.unit.BaseUnit;

import tec.uom.se.util.SI;

public class AstronomicalLength extends BaseUnit<Length> {

	public AstronomicalLength(String symbol, String name) {
		super(SI.ASTRONOMICAL_UNIT.toString(), "Astronomical Unit");
	}

}
