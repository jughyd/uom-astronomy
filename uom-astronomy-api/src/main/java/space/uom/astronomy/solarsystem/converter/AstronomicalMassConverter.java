package space.uom.astronomy.solarsystem.converter;

import java.util.List;

import javax.measure.UnitConverter;


public class AstronomicalMassConverter implements UnitConverter{

	@Override
	public boolean isIdentity() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isLinear() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public UnitConverter inverse() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Number convert(Number value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double convert(double value) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public UnitConverter concatenate(UnitConverter converter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<? extends UnitConverter> getConversionSteps() {
		// TODO Auto-generated method stub
		return null;
	}

}
