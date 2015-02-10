package tec.uom.astronomy.solarsystem.planet;

import java.util.ArrayList;
import java.util.List;

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
        setEarthPhysicalProperties(new PlanetaryPhysicalProperties());
        setEarthOrbitalProperties(new PlanetaryOrbitalProperties());
        setEarthAtmosphericProperties(new PlanetaryAtmosphericProperties());
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

    public PlanetaryPhysicalProperties getEarthPhysicalProperties() {
        return earthPhysicalProperties;
    }

    private void setEarthPhysicalProperties(
            PlanetaryPhysicalProperties earthPhysicalProperties) {
        Albedo albedo = new Albedo();
        albedo.setBondAlbedo(0.306);
        albedo.setGeometricAlbedo(0.367);
        Circumference circumference = new Circumference();
        circumference.setEquatorialCircumference(QuantityFactoryProvider
                .getQuantityFactory(Length.class).create(
                        40075.017, SIPrefix.KILO(SI.METRE)));
        circumference.setMeridonialCircumference(QuantityFactoryProvider
                .getQuantityFactory(Length.class).create(
                        40007.86, SIPrefix.KILO(SI.METRE)));
        earthPhysicalProperties.setAbsoluteMass(QuantityFactoryProvider
                .getQuantityFactory(Mass.class).create(3 * Math.pow(10, -6),
                        AstronomicalSystemOfUnits.SOLAR_MASS));
        earthPhysicalProperties.setAlbedo(albedo);
        earthPhysicalProperties.setCircumference(circumference);
        earthPhysicalProperties.setEquatorialRadius(QuantityFactoryProvider
                .getQuantityFactory(Length.class).create(
                        6378.1, SIPrefix.KILO(SI.METRE)));
        earthPhysicalProperties.setEquatorialRotationVelocity(QuantityFactoryProvider
                .getQuantityFactory(Speed.class).create(
                        6378.1, SI.METRES_PER_SECOND));
        earthPhysicalProperties.setMeanDensity(QuantityFactoryProvider
                .getQuantityFactory(VolumetricDensity.class).create(
                        5.514,
                        AstronomicalSystemOfUnits.GRAM_PER_CUBIC_CENTIMETRE));
        earthPhysicalProperties.setMeanRadius(QuantityFactoryProvider
                .getQuantityFactory(Length.class).create(
                        6371.0, SIPrefix.KILO(SI.METRE)));
        earthPhysicalProperties.setMomentOfInertia(0.3307);
        earthPhysicalProperties.setPolarRadius(QuantityFactoryProvider
                .getQuantityFactory(Length.class).create(
                        6356.8, SIPrefix.KILO(SI.METRE)));
        earthPhysicalProperties.setSiderealRotationPeriod(QuantityFactoryProvider
                .getQuantityFactory(Time.class).create(
                        0.99726968, SI.DAY));
        earthPhysicalProperties.escapeVelocity();
        earthPhysicalProperties.flattening();
        earthPhysicalProperties.planetVolume();
        earthPhysicalProperties.surfaceArea();
        earthPhysicalProperties.surfaceGravity();
        this.earthPhysicalProperties = earthPhysicalProperties;
    }

    private void setEarthOrbitalProperties(
            PlanetaryOrbitalProperties earthOrbitalProperties) {
        Satellites satellites = new Satellites();
        satellites.setArtificalSatellite(1070);
        satellites.setNaturalSatellite(1);
        Inclination inclination = new Inclination();
        inclination.setEclipticInclination(QuantityFactoryProvider
                .getQuantityFactory(Angle.class).create(
                        0.00005, SI.DEGREE_ANGLE));
        inclination.setInvariablePlaneInclination(QuantityFactoryProvider
                .getQuantityFactory(Angle.class).create(
                        1.57869, SI.DEGREE_ANGLE));
        inclination.setSunEquatorInclination(QuantityFactoryProvider
                .getQuantityFactory(Angle.class).create(
                        7.155, SI.DEGREE_ANGLE));
        earthOrbitalProperties.setAphelion(QuantityFactoryProvider
                .getQuantityFactory(Length.class).create(1.01559,
                        AstronomicalSystemOfUnits.ASTRONOMICAL_UNIT));
        earthOrbitalProperties.setAverageOrbitalSpeed(QuantityFactoryProvider
                .getQuantityFactory(Speed.class).create(
                        29777.7778, SI.METRES_PER_SECOND));
        earthOrbitalProperties.setInclination(inclination);
        earthOrbitalProperties.setMeanAnomaly(QuantityFactoryProvider
                .getQuantityFactory(Angle.class).create(355.53,
                        SI.DEGREE_ANGLE));
        earthOrbitalProperties.setOrbitalPeriod(QuantityFactoryProvider
                .getQuantityFactory(Time.class).create(365.256363004,
                        SI.DAY));
        earthOrbitalProperties.setPeriphelion(QuantityFactoryProvider
                .getQuantityFactory(Length.class).create(0.9832687,
                        AstronomicalSystemOfUnits.ASTRONOMICAL_UNIT));
        earthOrbitalProperties.setSatellites(satellites);
        earthOrbitalProperties.setSemiMajorAxis(QuantityFactoryProvider
                .getQuantityFactory(Length.class).create(
                        1.00000011,
                        AstronomicalSystemOfUnits.ASTRONOMICAL_UNIT));
        earthOrbitalProperties.calculateEccentricity();
        this.earthOrbitalProperties = earthOrbitalProperties;
    }

    private void setEarthAtmosphericProperties(
            PlanetaryAtmosphericProperties earthAtmosphericProperties) {
        List<String> composition = new ArrayList<String>();
        composition.add("Nitrogen");
        composition.add("Oxygen");
        composition.add("Argon");
        composition.add("Carbon Dioxide");
        earthAtmosphericProperties.setAtmosphericComposition(composition);
        earthAtmosphericProperties.setMeanSurfaceTemperature(QuantityFactoryProvider
                .getQuantityFactory(Temperature.class).create(
                        288, SI.KELVIN));
        earthAtmosphericProperties.setSurfacePressure(QuantityFactoryProvider
                .getQuantityFactory(Pressure.class).create(
                        101.325, SIPrefix.KILO(SI.PASCAL)));
        this.earthAtmosphericProperties = earthAtmosphericProperties;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("; ");
        sb.append(PlanetaryPhysicalProperties.class.getSimpleName());
        sb.append(": ");
        sb.append(getEarthPhysicalProperties());
        sb.append("; ");
        sb.append(PlanetaryOrbitalProperties.class.getSimpleName());
        sb.append(getEarthOrbitalProperties());
        sb.append("; ");
        sb.append(PlanetaryAtmosphericProperties.class.getSimpleName());
        sb.append(getEarthAtmosphericProperties());
        return sb.toString();
    }
}
