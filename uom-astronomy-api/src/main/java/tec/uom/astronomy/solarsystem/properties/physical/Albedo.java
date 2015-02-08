package tec.uom.astronomy.solarsystem.properties.physical;

public class Albedo {
	private double geometricAlbedo;
	private double bondAlbedo;

	/*
	 * public Albedo(double geomAlbedo, double bndAlbedo){ this.geometricAlbedo
	 * = geomAlbedo; this.bondAlbedo = bndAlbedo; }
	 */
	public double getGeometricAlbedo() {
		return geometricAlbedo;
	}

	public void setGeometricAlbedo(double geometricAlbedo) {
		this.geometricAlbedo = geometricAlbedo;
	}

	public double getBondAlbedo() {
		return bondAlbedo;
	}

	public void setBondAlbedo(double bondAlbedo) {
		this.bondAlbedo = bondAlbedo;
	}
}
