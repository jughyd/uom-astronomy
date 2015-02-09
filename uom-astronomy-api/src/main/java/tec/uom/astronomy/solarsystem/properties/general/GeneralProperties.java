package tec.uom.astronomy.solarsystem.properties.general;

import javax.measure.Quantity;
import javax.measure.quantity.Time;

public interface GeneralProperties {

	String getName();

	Quantity<Time> getAge();

	String getDiscoveredBy();

}
