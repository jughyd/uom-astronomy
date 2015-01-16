package tec.uom.astronomy.api;

import javax.measure.quantity.Time;
import javax.measure.test.unit.BaseUnit;

public class AstronomicalTime extends BaseUnit<Time> {

	public AstronomicalTime(String symbol, String name) {
		super("D", "Day");
	}

}
