package space.uom.astronomy.solarsystem.planet;

import java.util.ArrayList;
import java.util.List;

import javax.measure.Quantity;
import javax.measure.quantity.Angle;
import javax.measure.quantity.Length;
import javax.measure.quantity.Mass;
import javax.measure.quantity.Pressure;
import javax.measure.quantity.Speed;
import javax.measure.quantity.Temperature;
import javax.measure.quantity.Time;
import si.uom.quantity.Density;

import space.uom.astronomy.solarsystem.properties.general.AstronomicalUtility;
import space.uom.astronomy.solarsystem.properties.orbital.Inclination;
import space.uom.astronomy.solarsystem.properties.orbital.Satellites;
import space.uom.astronomy.solarsystem.properties.physical.Albedo;
import space.uom.astronomy.solarsystem.properties.physical.Circumference;
import space.uom.astronomy.solarsystem.units.AstronomicalSystemOfUnits;
import tec.uom.se.spi.QuantityFactoryProvider;
import tec.uom.se.unit.Units;
import tec.uom.se.unit.MetricPrefix;
import static tec.uom.se.quantity.Quantities.getQuantity;
import static tec.uom.se.unit.Units.YEAR;

public class Earth extends Planet {
    public Earth() {
        super("Earth", getQuantity(4.54 * Math.pow(10, 9), YEAR), "Nicholas Copernicus");
        setPlanetaryPhysicalProperties();
        setPlanetaryOrbitalProperties();
        setPlanetaryAtmosphericProperties();
    }


    private PlanetaryPhysicalProperties planetaryPhysicalProperties;
    private PlanetaryOrbitalProperties planetaryOrbitalProperties;
    private PlanetaryAtmosphericProperties planetaryAtmosphericProperties;
	
	private void setPlanetaryPhysicalProperties() {
		Albedo albedo = new Albedo();
		albedo.setBondAlbedo(0.306);
		albedo.setGeometricAlbedo(0.367);
		Circumference circumference = new Circumference();
		circumference.setEquatorialCircumference(QuantityFactoryProvider
				.getQuantityFactory(Length.class).create(40075.017,
						MetricPrefix.KILO(Units.METRE)));

		circumference.setMeridonialCircumference(QuantityFactoryProvider
				.getQuantityFactory(Length.class).create(40007.86,
						MetricPrefix.KILO(Units.METRE)));

		Quantity<Mass> absoluteMass = QuantityFactoryProvider
				.getQuantityFactory(Mass.class).create(3 * Math.pow(10, -6),
						AstronomicalSystemOfUnits.SOLAR_MASS);

		Quantity<Length> equatorialRadius = QuantityFactoryProvider
				.getQuantityFactory(Length.class).create(6378.1,
						MetricPrefix.KILO(Units.METRE));

		Quantity<Speed> equatorialRotationVelocity = QuantityFactoryProvider
				.getQuantityFactory(Speed.class).create(6378.1,
						Units.METRES_PER_SECOND);

		Quantity<Density> meanDensity = QuantityFactoryProvider
				.getQuantityFactory(Density.class).create(5.514,
						AstronomicalSystemOfUnits.GRAM_PER_CUBIC_CENTIMETRE);

		Quantity<Length> meanRadius = QuantityFactoryProvider
				.getQuantityFactory(Length.class).create(6371.0,
						MetricPrefix.KILO(Units.METRE));

		double momentOfInertia = 0.3307;

		Quantity<Length> polarRadius = QuantityFactoryProvider
				.getQuantityFactory(Length.class).create(6356.8,
						MetricPrefix.KILO(Units.METRE));

		Quantity<Time> siderealRotationPeriod = QuantityFactoryProvider
				.getQuantityFactory(Time.class).create(0.99726968, Units.DAY);

		PlanetaryPhysicalProperties earthPhysicalProperties = new PlanetaryPhysicalProperties(
				polarRadius, equatorialRadius, equatorialRotationVelocity,
				momentOfInertia, circumference, siderealRotationPeriod,
				meanRadius, meanDensity, absoluteMass, albedo);

		this.planetaryPhysicalProperties = earthPhysicalProperties;
	}

	private void setPlanetaryOrbitalProperties() {
		Satellites satellites = new Satellites();
		satellites.setArtificalSatellite(1070);
		satellites.setNaturalSatellite(1);
		Inclination inclination = new Inclination();
		inclination.setEclipticInclination(QuantityFactoryProvider
				.getQuantityFactory(Angle.class).create(0.00005,
						Units.DEGREE_ANGLE));

		inclination.setInvariablePlaneInclination(QuantityFactoryProvider
				.getQuantityFactory(Angle.class).create(1.57869,
						Units.DEGREE_ANGLE));
		inclination
				.setSunEquatorInclination(QuantityFactoryProvider
						.getQuantityFactory(Angle.class).create(7.155,
								Units.DEGREE_ANGLE));

		Quantity<Length> aphelion = QuantityFactoryProvider.getQuantityFactory(
				Length.class).create(1.01559,
				AstronomicalSystemOfUnits.ASTRONOMICAL_UNIT);

		Quantity<Speed> averageOrbitalSpeed = QuantityFactoryProvider
				.getQuantityFactory(Speed.class).create(29777.7778,
						Units.METRES_PER_SECOND);

		Quantity<Angle> meanAnomaly = QuantityFactoryProvider
				.getQuantityFactory(Angle.class)
				.create(355.53, Units.DEGREE_ANGLE);

		Quantity<Time> orbitalPeriod = QuantityFactoryProvider
				.getQuantityFactory(Time.class).create(365.256363004, Units.DAY);

		Quantity<Length> periphelion = QuantityFactoryProvider
				.getQuantityFactory(Length.class).create(0.9832687,
						AstronomicalSystemOfUnits.ASTRONOMICAL_UNIT);

		Quantity<Length> semiMajorAxis = QuantityFactoryProvider
				.getQuantityFactory(Length.class).create(1.00000011,
						AstronomicalSystemOfUnits.ASTRONOMICAL_UNIT);

		PlanetaryOrbitalProperties earthOrbitalProperties = new PlanetaryOrbitalProperties(
				meanAnomaly, averageOrbitalSpeed, satellites, aphelion,
				periphelion, semiMajorAxis, orbitalPeriod, inclination);
		this.planetaryOrbitalProperties = earthOrbitalProperties;
	}

	private void setPlanetaryAtmosphericProperties() {
		List<String> atmospherComposition = new ArrayList<String>();
		atmospherComposition.add("Nitrogen");
		atmospherComposition.add("Oxygen");
		atmospherComposition.add("Argon");
		atmospherComposition.add("Carbon Dioxide");

		Quantity<Temperature> surfaceTemperature = QuantityFactoryProvider
				.getQuantityFactory(Temperature.class).create(288, Units.KELVIN);

		Quantity<Pressure> surfPressure = QuantityFactoryProvider
				.getQuantityFactory(Pressure.class).create(101.325,
						MetricPrefix.KILO(Units.PASCAL));

		PlanetaryAtmosphericProperties earthAtmosphericProperties = new PlanetaryAtmosphericProperties(
				surfPressure, surfaceTemperature, atmospherComposition);
		this.planetaryAtmosphericProperties = earthAtmosphericProperties;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(Planet.class.getSimpleName() + ": ");
		sb.append(getName());
		sb.append("; ");
		sb.append("Age: ");
		sb.append(AstronomicalUtility.getValueUnit(getAge()));
		sb.append("; ");
		sb.append("Discovered By: ");
		sb.append(getDiscoveredBy());
		sb.append("; ");
		sb.append(planetaryPhysicalProperties.toString());
		sb.append("; ");
		sb.append(planetaryOrbitalProperties.toString());
		sb.append("; ");
		sb.append(planetaryAtmosphericProperties.toString());
		return sb.toString();
	}
}
