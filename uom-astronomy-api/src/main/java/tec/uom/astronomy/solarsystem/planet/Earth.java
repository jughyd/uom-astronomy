package tec.uom.astronomy.solarsystem.planet;

import static  tec.uom.se.quantity.Quantities.getQuantity;
import static  tec.uom.se.util.UCUM.YEAR;

public class Earth extends Planet{

	public Earth() {
		super("Earth", getQuantity(4.54 * Math.pow(10,9), YEAR) , "Nicholas Copernicus");
	}
	PlanetaryPhysicalProperties physicalProperties;
	

}
