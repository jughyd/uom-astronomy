package space.uom.astronomy.solarsystem.planet;

import java.util.ArrayList;
import java.util.List;

import javax.measure.Quantity;
import javax.measure.quantity.Angle;
import javax.measure.quantity.Length;
import javax.measure.quantity.Mass;
import javax.measure.quantity.Speed;
import javax.measure.quantity.Temperature;
import javax.measure.quantity.Time;
import javax.measure.spi.Bootstrap;
import javax.measure.spi.QuantityFactoryService;

import si.uom.quantity.Density;
import space.uom.astronomy.solarsystem.properties.general.AstronomicalUtility;
import space.uom.astronomy.solarsystem.properties.orbital.Inclination;
import space.uom.astronomy.solarsystem.properties.orbital.Satellites;
import space.uom.astronomy.solarsystem.properties.physical.Albedo;
import space.uom.astronomy.solarsystem.properties.physical.Circumference;
import space.uom.astronomy.solarsystem.units.AstronomicalSystemOfUnits;
import tec.uom.se.unit.Units;
import tec.uom.se.unit.MetricPrefix;
import static tec.uom.se.quantity.Quantities.getQuantity;
import static tec.uom.se.unit.Units.YEAR;

public class Mercury extends Planet {
    public Mercury() {
        super("Mercury", getQuantity(4.54 * Math.pow(10, 9), YEAR), "Nicholas Copernicus");
        factoryService = Bootstrap.getService(QuantityFactoryService.class);
        setMercuryPhysicalProperties();
        setMercuryOrbitalProperties();
        setMercuryAtmosphericProperties();
    }
    
    private QuantityFactoryService factoryService;
    private PlanetaryPhysicalProperties mercuryPhysicalProperties;
    private PlanetaryOrbitalProperties mercuryOrbitalProperties;
    private PlanetaryAtmosphericProperties mercuryAtmosphericProperties;

    public PlanetaryOrbitalProperties getMercuryOrbitalProperties() {
        return mercuryOrbitalProperties;
    }

    public PlanetaryAtmosphericProperties getMercuryAtmosphericProperties() {
        return mercuryAtmosphericProperties;
    }

	private void setMercuryPhysicalProperties() {
		Albedo albedo = new Albedo();
		albedo.setBondAlbedo(0.068);
		albedo.setGeometricAlbedo(0.142);
		Circumference circumference = new Circumference();
		circumference.setEquatorialCircumference(factoryService
				.getQuantityFactory(Length.class).create(15329,
						MetricPrefix.KILO(Units.METRE)));

		Quantity<Mass> absoluteMass = factoryService
				.getQuantityFactory(Mass.class).create(3.3022 * Math.pow(10, 23),
						Units.KILOGRAM);

		Quantity<Speed> equatorialRotationVelocity = factoryService
				.getQuantityFactory(Speed.class).create(3.026,
						Units.METRES_PER_SECOND);

		Quantity<Density> meanDensity = factoryService
				.getQuantityFactory(Density.class).create(5.427,
						AstronomicalSystemOfUnits.GRAM_PER_CUBIC_CENTIMETRE);

		Quantity<Length> meanRadius = factoryService
				.getQuantityFactory(Length.class).create(2439.7,
						MetricPrefix.KILO(Units.METRE));

		double momentOfInertia = 0.346;

		Quantity<Time> siderealRotationPeriod = factoryService
				.getQuantityFactory(Time.class).create(58.646, Units.DAY);

		PlanetaryPhysicalProperties mercuryPhysicalProperties = new PlanetaryPhysicalProperties(
				null, null, equatorialRotationVelocity,
				momentOfInertia, circumference, siderealRotationPeriod,
				meanRadius, meanDensity, absoluteMass, albedo);

		this.mercuryPhysicalProperties = mercuryPhysicalProperties;
	}

	private void setMercuryOrbitalProperties() {
		Satellites satellites = new Satellites();
		satellites.setArtificalSatellite(0);
		satellites.setNaturalSatellite(0);
		Inclination inclination = new Inclination();
		inclination.setEclipticInclination(factoryService
				.getQuantityFactory(Angle.class).create(7.005,
						Units.DEGREE_ANGLE));

		inclination.setInvariablePlaneInclination(factoryService
				.getQuantityFactory(Angle.class).create(6.34,
						Units.DEGREE_ANGLE));
		inclination
				.setSunEquatorInclination(factoryService
						.getQuantityFactory(Angle.class).create(3.38,
								Units.DEGREE_ANGLE));

		Quantity<Length> aphelion = factoryService.getQuantityFactory(
				Length.class).create(0.466697,
				AstronomicalSystemOfUnits.ASTRONOMICAL_UNIT);

		Quantity<Speed> averageOrbitalSpeed = factoryService
				.getQuantityFactory(Speed.class).create(47.362,
						MetricPrefix.KILO(Units.METRES_PER_SECOND));

		Quantity<Angle> meanAnomaly = factoryService
				.getQuantityFactory(Angle.class)
				.create(174.796, Units.DEGREE_ANGLE);

		Quantity<Time> orbitalPeriod = factoryService
				.getQuantityFactory(Time.class).create(87.9691, Units.DAY);

		Quantity<Length> periphelion = factoryService
				.getQuantityFactory(Length.class).create(0.307499,
						AstronomicalSystemOfUnits.ASTRONOMICAL_UNIT);

		Quantity<Length> semiMajorAxis = factoryService
				.getQuantityFactory(Length.class).create(0.387098,
						AstronomicalSystemOfUnits.ASTRONOMICAL_UNIT);

		PlanetaryOrbitalProperties mercuryOrbitalProperties = new PlanetaryOrbitalProperties(
				meanAnomaly, averageOrbitalSpeed, satellites, aphelion,
				periphelion, semiMajorAxis, orbitalPeriod, inclination);
		this.mercuryOrbitalProperties = mercuryOrbitalProperties;
	}

	private void setMercuryAtmosphericProperties() {
		List<String> atmospherComposition = new ArrayList<String>();
		atmospherComposition.add("Sodium");
		atmospherComposition.add("Oxygen");
		atmospherComposition.add("Hydrogenn");
		atmospherComposition.add("Helium");
		atmospherComposition.add("Potassium");

		Quantity<Temperature> surfaceTemperature = factoryService
				.getQuantityFactory(Temperature.class).create(340, Units.KELVIN);

		PlanetaryAtmosphericProperties mercuryAtmosphericProperties = new PlanetaryAtmosphericProperties(
				null, surfaceTemperature, atmospherComposition);
		this.mercuryAtmosphericProperties = mercuryAtmosphericProperties;
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
		sb.append(mercuryPhysicalProperties.toString());
		sb.append("; ");
		sb.append(mercuryOrbitalProperties.toString());
		sb.append("; ");
		sb.append(mercuryAtmosphericProperties.toString());
		return sb.toString();
	}

    public PlanetaryPhysicalProperties getMercuryPhysicalProperties() {
        return mercuryPhysicalProperties;
    }
}
