package tec.uom.astronomy.solarsystem.planet;

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
import javax.measure.quantity.VolumetricDensity;

import tec.uom.astronomy.solarsystem.properties.orbital.Inclination;
import tec.uom.astronomy.solarsystem.properties.orbital.Satellites;
import tec.uom.astronomy.solarsystem.properties.physical.Albedo;
import tec.uom.astronomy.solarsystem.properties.physical.Circumference;
import tec.uom.astronomy.solarsystem.units.AstronomicalSystemOfUnits;
import tec.uom.se.quantity.QuantityFactoryProvider;
import tec.uom.se.util.SI;
import tec.uom.se.util.SIPrefix;
import static tec.uom.se.quantity.Quantities.getQuantity;
import static tec.uom.se.util.UCUM.YEAR;

public class Earth extends Planet {
    public Earth() {
        super("Earth", getQuantity(4.54 * Math.pow(10, 9), YEAR), "Nicholas Copernicus");
        setEarthPhysicalProperties();
        setEarthOrbitalProperties();
        setEarthAtmosphericProperties();
    }


    private PlanetaryPhysicalProperties earthPhysicalProperties;
    private PlanetaryOrbitalProperties earthOrbitalProperties;
    private PlanetaryAtmosphericProperties earthAtmosphericProperties;

    public PlanetaryOrbitalProperties getEarthOrbitalProperties() {
        return earthOrbitalProperties;
    }

    public PlanetaryAtmosphericProperties getEarthAtmosphericProperties() {
        return earthAtmosphericProperties;
    }


	private void setEarthPhysicalProperties() {
		Albedo albedo = new Albedo();
		albedo.setBondAlbedo(0.306);
		albedo.setGeometricAlbedo(0.367);
		Circumference circumference = new Circumference();
		circumference.setEquatorialCircumference(QuantityFactoryProvider
				.getQuantityFactory(Length.class).create(40075.017,
						SIPrefix.KILO(SI.METRE)));

		circumference.setMeridonialCircumference(QuantityFactoryProvider
				.getQuantityFactory(Length.class).create(40007.86,
						SIPrefix.KILO(SI.METRE)));

		Quantity<Mass> absoluteMass = QuantityFactoryProvider
				.getQuantityFactory(Mass.class).create(3 * Math.pow(10, -6),
						AstronomicalSystemOfUnits.SOLAR_MASS);

		Quantity<Length> equatorialRadius = QuantityFactoryProvider
				.getQuantityFactory(Length.class).create(6378.1,
						SIPrefix.KILO(SI.METRE));

		Quantity<Speed> equatorialRotationVelocity = QuantityFactoryProvider
				.getQuantityFactory(Speed.class).create(6378.1,
						SI.METRES_PER_SECOND);

		Quantity<VolumetricDensity> meanDensity = QuantityFactoryProvider
				.getQuantityFactory(VolumetricDensity.class).create(5.514,
						AstronomicalSystemOfUnits.GRAM_PER_CUBIC_CENTIMETRE);

		Quantity<Length> meanRadius = QuantityFactoryProvider
				.getQuantityFactory(Length.class).create(6371.0,
						SIPrefix.KILO(SI.METRE));

		double momentOfInertia = 0.3307;

		Quantity<Length> polarRadius = QuantityFactoryProvider
				.getQuantityFactory(Length.class).create(6356.8,
						SIPrefix.KILO(SI.METRE));

		Quantity<Time> siderealRotationPeriod = QuantityFactoryProvider
				.getQuantityFactory(Time.class).create(0.99726968, SI.DAY);

		PlanetaryPhysicalProperties earthPhysicalProperties = new PlanetaryPhysicalProperties(
				polarRadius, equatorialRadius, equatorialRotationVelocity,
				momentOfInertia, circumference, siderealRotationPeriod,
				meanRadius, meanDensity, absoluteMass, albedo);

		this.earthPhysicalProperties = earthPhysicalProperties;
	}

	private void setEarthOrbitalProperties() {
		Satellites satellites = new Satellites();
		satellites.setArtificalSatellite(1070);
		satellites.setNaturalSatellite(1);
		Inclination inclination = new Inclination();
		inclination.setEclipticInclination(QuantityFactoryProvider
				.getQuantityFactory(Angle.class).create(0.00005,
						SI.DEGREE_ANGLE));

		inclination.setInvariablePlaneInclination(QuantityFactoryProvider
				.getQuantityFactory(Angle.class).create(1.57869,
						SI.DEGREE_ANGLE));
		inclination
				.setSunEquatorInclination(QuantityFactoryProvider
						.getQuantityFactory(Angle.class).create(7.155,
								SI.DEGREE_ANGLE));

		Quantity<Length> aphelion = QuantityFactoryProvider.getQuantityFactory(
				Length.class).create(1.01559,
				AstronomicalSystemOfUnits.ASTRONOMICAL_UNIT);

		Quantity<Speed> averageOrbitalSpeed = QuantityFactoryProvider
				.getQuantityFactory(Speed.class).create(29777.7778,
						SI.METRES_PER_SECOND);

		Quantity<Angle> meanAnomaly = QuantityFactoryProvider
				.getQuantityFactory(Angle.class)
				.create(355.53, SI.DEGREE_ANGLE);

		Quantity<Time> orbitalPeriod = QuantityFactoryProvider
				.getQuantityFactory(Time.class).create(365.256363004, SI.DAY);

		Quantity<Length> periphelion = QuantityFactoryProvider
				.getQuantityFactory(Length.class).create(0.9832687,
						AstronomicalSystemOfUnits.ASTRONOMICAL_UNIT);

		Quantity<Length> semiMajorAxis = QuantityFactoryProvider
				.getQuantityFactory(Length.class).create(1.00000011,
						AstronomicalSystemOfUnits.ASTRONOMICAL_UNIT);

		PlanetaryOrbitalProperties earthOrbitalProperties = new PlanetaryOrbitalProperties(
				meanAnomaly, averageOrbitalSpeed, satellites, aphelion,
				periphelion, semiMajorAxis, orbitalPeriod, inclination);
		this.earthOrbitalProperties = earthOrbitalProperties;
	}

	private void setEarthAtmosphericProperties() {
		List<String> atmospherComposition = new ArrayList<String>();
		atmospherComposition.add("Nitrogen");
		atmospherComposition.add("Oxygen");
		atmospherComposition.add("Argon");
		atmospherComposition.add("Carbon Dioxide");

		Quantity<Temperature> surfaceTemperature = QuantityFactoryProvider
				.getQuantityFactory(Temperature.class).create(288, SI.KELVIN);

		Quantity<Pressure> surfPressure = QuantityFactoryProvider
				.getQuantityFactory(Pressure.class).create(101.325,
						SIPrefix.KILO(SI.PASCAL));

		PlanetaryAtmosphericProperties earthAtmosphericProperties = new PlanetaryAtmosphericProperties(
				surfPressure, surfaceTemperature, atmospherComposition);
		this.earthAtmosphericProperties = earthAtmosphericProperties;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(Planet.class.getSimpleName() + ": ");
		sb.append(getName());
		sb.append("; ");
		sb.append("Age: ");
		sb.append(getAge().getValue() + " year");
		sb.append("; ");
		sb.append("Discovered By: ");
		sb.append(getDiscoveredBy());
		sb.append("; ");
		sb.append(earthPhysicalProperties.toString());
		sb.append("; ");
		sb.append(earthOrbitalProperties.toString());
		sb.append("; ");
		sb.append(earthAtmosphericProperties.toString());
		return sb.toString();
	}

    public PlanetaryPhysicalProperties getEarthPhysicalProperties() {
        return earthPhysicalProperties;
    }

}
