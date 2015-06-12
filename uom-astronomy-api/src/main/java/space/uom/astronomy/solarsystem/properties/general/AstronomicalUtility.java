package space.uom.astronomy.solarsystem.properties.general;

import javax.measure.Quantity;

import tec.uom.se.unit.TransformedUnit;

public class AstronomicalUtility {
	
	public static String getValueUnit(Quantity<?> quantity){
		String resultValueUnit = null;
		if(quantity != null){
			if(quantity.getUnit() instanceof TransformedUnit){
				resultValueUnit = quantity.getValue() + " " + quantity.getUnit().getSymbol();
			}
			else
				resultValueUnit = quantity.toString();
		}
		return resultValueUnit;
	}
}
