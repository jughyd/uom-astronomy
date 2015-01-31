package tec.uom.astronomy.solarsystem.units;

import javax.measure.Unit;
import javax.measure.quantity.Length;
import javax.measure.quantity.Mass;

import tec.uom.astronomy.solarsystem.converter.AstronomicalLengthConverter;
import tec.uom.astronomy.solarsystem.converter.AstronomicalMassConverter;
import tec.uom.se.AbstractQuantity;
import tec.uom.se.unit.TransformedUnit;
import tec.uom.se.util.SI;

public class AstronomicalSystemOfUnits {
	/**
     * A mass unit accepted for use with SI units (standard name <code>UA</code>).
     * The solar mass (M☉) is a standard unit of mass in astronomy that is used to 
     * indicate the masses of other stars, as well as clusters, nebulae and galaxies. 
     * It is equal to the mass of the Sun, about two nonillion kilograms:
     */

    @SuppressWarnings("unchecked")
   	public static final TransformedUnit<Mass> SOLAR_MASS
               = new TransformedUnit("M☉", SI.KILOGRAM, new AstronomicalMassConverter());
    
    
    /**
     * A length unit accepted for use with SI units (standard name <code>UA</code>).
     * The astronomical unit is a unit of length. Its value is such that,
     * when used to describe the motion of bodies in the solar system,		
     * the heliocentric gravitation constant is (0.017 202 098 95)2 ua3·d-2.
     * The value must be obtained by experiment, and is therefore not known exactly.
     * public static final Unit<Length> ASTRONOMIC_UNIT = addUnit(SI.ASTRONOMICAL_UNIT);
     */
    public static final TransformedUnit<Length> ASTRONOMICAL_UNIT
        = new TransformedUnit("AU", SI.METRE, new AstronomicalLengthConverter());
    
    /*public static final Unit<Length> LIGHT_YEAR = addUnit(C.multiply(YEAR_JULIAN).asType(Length.class));*/
    


}
