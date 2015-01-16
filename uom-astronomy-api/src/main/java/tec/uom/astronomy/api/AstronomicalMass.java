package tec.uom.astronomy.api;

import javax.measure.quantity.Mass;
import javax.measure.test.unit.BaseUnit;

/*import tec.units.ri.quantity.NumberQuantity;

public class SolarMass extends NumberQuantity<Mass> implements Mass{

}*/

public class AstronomicalMass extends BaseUnit<Mass>{

	public AstronomicalMass(String symbol, String name) {
		super("M☉", "Solar Mass");
	}
	
}