package tec.uom.astronomy.solarsystem.planet;

import javax.measure.Quantity;
import javax.measure.UnitConverter;
import javax.measure.quantity.Acceleration;
import javax.measure.quantity.Area;
import javax.measure.quantity.Length;
import javax.measure.quantity.Speed;
import javax.measure.quantity.Volume;

import tec.uom.astronomy.solarsystem.constants.AstronomicalConstants;
import tec.uom.astronomy.solarsystem.properties.physical.Circumference;
import tec.uom.astronomy.solarsystem.properties.physical.CommonPhysicalProperties;
import tec.uom.astronomy.solarsystem.units.AstronomicalSystemOfUnits;
import tec.uom.se.quantity.QuantityFactoryProvider;
import tec.uom.se.util.SI;
import tec.uom.se.util.SIPrefix;

public class PlanetaryPhysicalProperties extends CommonPhysicalProperties {

	private Quantity<Length> polarRadius;
	private Quantity<Length> equatorialRadius;
	private Circumference circumference = new Circumference();
	private Quantity<Speed> equatorialRotationVelocity;
	private UnitConverter polarRadiusConverter = getPolarRadius().getUnit()
			.getConverterTo(SIPrefix.KILO(SI.METRE));
	private double polarRadiusValue = polarRadiusConverter.convert((double) getPolarRadius()
			.getValue());
	private UnitConverter equatorialRadiusConverter = getEquatorialRadius().getUnit()
			.getConverterTo(SIPrefix.KILO(SI.METRE));
	private double equatorialRadiusValue = equatorialRadiusConverter.convert((double) getEquatorialRadius()
			.getValue());
	private UnitConverter meanRadiusConverter = getMeanRadius().getUnit()
			.getConverterTo(SIPrefix.KILO(SI.METRE));
	private double meanRadiusValue = meanRadiusConverter.convert((double) getMeanRadius()
			.getValue());
	private UnitConverter massConverter = getAbsoluteMass().getUnit()
			.getConverterTo(SI.KILOGRAM);
	private double massValue = massConverter.convert((double) getAbsoluteMass()
			.getValue());
	private double momentOfInertia;

	public double getMomentOfInertia() {
		return momentOfInertia;
	}

	public void setMomentOfInertia(double momentOfInertia) {
		this.momentOfInertia = momentOfInertia;
	}

	public Quantity<Length> getPolarRadius() {
		return polarRadius;
	}

	public void setPolarRadius(Quantity<Length> polarRadius) {
		this.polarRadius = polarRadius;
	}

	public Quantity<Length> getEquatorialRadius() {
		return equatorialRadius;
	}

	public void setEquatorialRadius(Quantity<Length> equatorialRadius) {
		this.equatorialRadius = equatorialRadius;
	}

	public Circumference getCircumference() {
		return circumference;
	}

	public void setCircumference(Circumference circumference) {
		this.circumference = circumference;
	}

	public Quantity<Speed> getEquatorialRotationVelocity() {
		return equatorialRotationVelocity;
	}

	public void setEquatorialRotationVelocity(
			Quantity<Speed> equatorialRotationVelocity) {
		this.equatorialRotationVelocity = equatorialRotationVelocity;
	}

	public double flattening() {
		double flatten = (equatorialRadiusValue - polarRadiusValue) / equatorialRadiusValue;
		return flatten;
	}

	public Quantity<Area> surfaceArea() {
		double ellipticalEccentricity = 0;
		double surfaceAreaValue = 0;
		if (polarRadiusValue != 0 && equatorialRadiusValue != 0) {
			if (polarRadiusValue < equatorialRadiusValue) {
				ellipticalEccentricity = Math.sqrt(1 - (Math.pow(
						polarRadiusValue, 2) / Math.pow(equatorialRadiusValue,
						2)));
				double tanHyperbolicInverse = 0;
				if (ellipticalEccentricity < 1 && ellipticalEccentricity > -1) {
					tanHyperbolicInverse = Math
							.log((ellipticalEccentricity + 1.0)
									/ (1.0 - ellipticalEccentricity));
				} else if (ellipticalEccentricity > 1) {
					tanHyperbolicInverse = Math
							.log((ellipticalEccentricity + 1.0)
									/ (ellipticalEccentricity - 1.0));
				}
				surfaceAreaValue = 2
						* AstronomicalConstants.PI
						* Math.pow(equatorialRadiusValue, 2)
						* (1 + (((1 - Math.pow(ellipticalEccentricity, 2)) / ellipticalEccentricity) * (0.5 * tanHyperbolicInverse)));
			}
			if (polarRadiusValue > equatorialRadiusValue) {
				ellipticalEccentricity = Math.sqrt(1 - (Math.pow(
						equatorialRadiusValue, 2) / Math.pow(polarRadiusValue,
						2)));
				surfaceAreaValue = 2
						* AstronomicalConstants.PI
						* Math.pow(equatorialRadiusValue, 2)
						* (1 + (polarRadiusValue / (equatorialRadiusValue * ellipticalEccentricity))
								* (Math.asin(ellipticalEccentricity)));
			}
		}
		Quantity<Area> surfaceArea = QuantityFactoryProvider
				.getQuantityFactory(Area.class).create(surfaceAreaValue,
						AstronomicalSystemOfUnits.SQUARE_KILOMETRE);
		return surfaceArea;
	}
	
	public Quantity<Volume> planetVolume(){
		double volumeValue = 0;
		if(polarRadiusValue != 0 && equatorialRadiusValue != 0 && meanRadiusValue != 0){
			volumeValue = (4/3) * AstronomicalConstants.PI * polarRadiusValue * equatorialRadiusValue * meanRadiusValue;
		}
		else if(meanRadiusValue != 0 && polarRadiusValue == 0 && equatorialRadiusValue == 0){
			volumeValue = (4/3) * AstronomicalConstants.PI * Math.pow(polarRadiusValue, 3);
		}
		Quantity<Volume> planetVolume = QuantityFactoryProvider
				.getQuantityFactory(Volume.class).create(volumeValue,
						AstronomicalSystemOfUnits.CUBIC_KILOMETRE);
		return planetVolume;
	}
	
	public Quantity<Acceleration> surfaceGravity(){
		double gravityValue = (AstronomicalConstants.EARTH_GRAVITATIONAL_CONSTANT * massValue) / Math.pow(meanRadiusValue, 2);
		Quantity<Acceleration> gravity = QuantityFactoryProvider
				.getQuantityFactory(Acceleration.class).create(gravityValue,
						SI.METRES_PER_SQUARE_SECOND);
		return gravity;
	}

	@Override
	public Quantity<Speed> escapeVelocity() {
		double escVelResult = Math
				.sqrt((2 * AstronomicalConstants.EARTH_GRAVITATIONAL_CONSTANT * massValue)
						/ meanRadiusValue);
		Quantity<Speed> escapeVelocity = QuantityFactoryProvider
				.getQuantityFactory(Speed.class).create(escVelResult,
						SI.METRES_PER_SECOND);
		return escapeVelocity;
	}

}
