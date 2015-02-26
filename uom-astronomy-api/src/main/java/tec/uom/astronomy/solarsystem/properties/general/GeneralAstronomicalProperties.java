package tec.uom.astronomy.solarsystem.properties.general;

import javax.measure.Quantity;
import javax.measure.quantity.Time;

import tec.uom.se.function.Nameable;

public interface GeneralAstronomicalProperties extends Nameable {

	String getName();

	Quantity<Time> getAge();

	String getDiscoveredBy();

}
