package space.uom.astronomy.solarsystem.converter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Objects;

import javax.measure.UnitConverter;

import tec.uom.se.AbstractConverter;
import tec.uom.se.function.DoubleFactorSupplier;
import tec.uom.se.function.MultiplyConverter;
import tec.uom.se.function.ValueSupplier;

public class AstronomicalLengthConverter extends AbstractConverter implements
ValueSupplier<Double>, DoubleFactorSupplier, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6588759878444545649L;

	/**
	 * Holds the scale factor.
	 */
	private final double factor = 149597871000.0;

	@Override
	public boolean isLinear() {
		return true;
	}

	@Override
	public double getFactor() {
		return factor;
	}

	@Override
	public Double getValue() {
		return factor;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj instanceof AstronomicalLengthConverter) {
			AstronomicalLengthConverter that = (AstronomicalLengthConverter) obj;
			return Objects.equals(factor, that.factor);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(factor);
	}

	@Override
	public MultiplyConverter inverse() {
		return new MultiplyConverter(1.0 / factor);
	}

	@Override
	public double convert(double value) {
		return value * factor;
	}

	@Override
	public BigDecimal convert(BigDecimal value, MathContext ctx)
			throws ArithmeticException {
		return value.multiply(BigDecimal.valueOf(factor), ctx);
	}
	
	@Override
	public final String toString() {
		return "AstronomicalLengthConverter(" + factor + ")";
	}
	
	@Override
	public UnitConverter concatenate(UnitConverter converter) {
		if (!(converter instanceof AstronomicalLengthConverter))
			return super.concatenate(converter);
		double newfactor = factor * ((AstronomicalLengthConverter) converter).factor;
		return newfactor == 1.0 ? IDENTITY : new AstronomicalLengthConverter();
	}

}
