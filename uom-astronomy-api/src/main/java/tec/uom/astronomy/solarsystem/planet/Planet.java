package tec.uom.astronomy.solarsystem.planet;

import javax.measure.Quantity;
import javax.measure.quantity.Time;

import tec.uom.astronomy.solarsystem.properties.general.GeneralProperties;
import tec.uom.se.quantity.QuantityFactoryProvider;
import tec.uom.se.util.UCUM;

public class Planet implements GeneralProperties {

	private String name;
	private Quantity<Time> age = QuantityFactoryProvider
			.getQuantityFactory(Time.class).create(
					(Number) getAge(), UCUM.YEAR);;
	private String discoveredBy;
	private PlanetaryPhysicalProperties planetaryPhysicalProperties;
	private PlanetaryOrbitalProperties planetaryOrbitalProperties;
	private PlanetaryAtmosphericProperties planetaryAtmosphericProperties;

	public Planet(String planetName, Quantity<Time> planetAge, String planetDiscoveredBy
			) {
		this.name = planetName;
		this.age = planetAge;
		this.discoveredBy = planetDiscoveredBy;
	}

	public PlanetaryPhysicalProperties getPlanetaryPhysicalProperties() {
		return planetaryPhysicalProperties;
	}

	public void setPlanetaryPhysicalProperties(
			PlanetaryPhysicalProperties planetaryPhysicalProperties) {
		this.planetaryPhysicalProperties = planetaryPhysicalProperties;
	}

	public PlanetaryOrbitalProperties getPlanetaryOrbitalProperties() {
		return planetaryOrbitalProperties;
	}

	public void setPlanetaryOrbitalProperties(
			PlanetaryOrbitalProperties planetaryOrbitalProperties) {
		this.planetaryOrbitalProperties = planetaryOrbitalProperties;
	}

	public PlanetaryAtmosphericProperties getPlanetaryAtmosphericProperties() {
		return planetaryAtmosphericProperties;
	}

	public void setPlanetaryAtmosphericProperties(
			PlanetaryAtmosphericProperties planetaryAtmosphericProperties) {
		this.planetaryAtmosphericProperties = planetaryAtmosphericProperties;
	}

	public void setDiscoveredBy(String discoveredBy) {
		this.discoveredBy = discoveredBy;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setAge(Quantity<Time> age) {
		this.age = age;
	}
	
	@Override
	public Quantity<Time> getAge() {
		return age;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getDiscoveredBy() {
		return discoveredBy;
	}

}
