package mathsol.number.complex.test;

import static org.junit.Assert.*;

import mathsol.number.complex.ComplexNumber;
import org.junit.Before;
import org.junit.Test;

public class ComplexNumberTest {
	
	private ComplexNumber z1, z2, z3;
	

	@Before
	public void setUpRandomVariables() throws Exception {
		z1 = new ComplexNumber(1, 0);
		z2 = new ComplexNumber(0, 1);
		z3 = new ComplexNumber(3, 4);
	}
	

	@Test
	public void testConjugation() {
		assertEquals(1, z1.conjugate().getReal(), 1e-3);
		assertEquals(0, z1.conjugate().getImaginary(), 1e-3);
		assertEquals(0, z2.conjugate().getReal(), 1e-3);
		assertEquals(-1, z2.conjugate().getImaginary(), 1e-3);
		assertEquals(3, z3.conjugate().getReal(), 1e-3);
		assertEquals(-4, z3.conjugate().getImaginary(), 1e-3);
	}

	@Test
	public void testNegation() {
		assertEquals(-1, z1.negate().getReal(), 1e-3);
		assertEquals(0, z1.negate().getImaginary(), 1e-3);
		assertEquals(0, z2.negate().getReal(), 1e-3);
		assertEquals(-1, z2.negate().getImaginary(), 1e-3);
		assertEquals(-3, z3.negate().getReal(), 1e-3);
		assertEquals(-4, z3.negate().getImaginary(), 1e-3);
	}

	@Test
	public void testAbs() {
		assertEquals(1, z1.abs(), 1e-3);
		assertEquals(1, z2.abs(), 1e-3);
		assertEquals(5, z3.abs(), 1e-3);
	}


	@Test
	public void testMultiply() {
		assertEquals(1, z1.multiply(z1).getReal(), 1e-3);
		assertEquals(0, z1.multiply(z1).getImaginary(), 1e-3);
		assertEquals(-1, z2.multiply(z2).getReal(), 1e-3);
		assertEquals(0, z2.multiply(z2).getImaginary(), 1e-3);
		assertEquals(0, z1.multiply(z2).getReal(), 1e-3);
		assertEquals(1, z1.multiply(z2).getImaginary(), 1e-3);
		assertEquals(-4, z3.multiply(z2).getReal(), 1e-3);
		assertEquals(3, z3.multiply(z2).getImaginary(), 1e-3);
		assertEquals(-7, z3.multiply(z3).getReal(), 1e-3);
		assertEquals(24, z3.multiply(z3).getImaginary(), 1e-3);
	}
	

	@Test
	public void testDivide() {
		assertEquals(1, z1.divide(z1).getReal(), 1e-3);
		assertEquals(0, z1.divide(z1).getImaginary(), 1e-3);
		assertEquals(1, z2.divide(z2).getReal(), 1e-3);
		assertEquals(0, z2.divide(z2).getImaginary(), 1e-3);
		assertEquals(0, z1.divide(z2).getReal(), 1e-3);
		assertEquals(-1, z1.divide(z2).getImaginary(), 1e-3);
		assertEquals(4, z3.divide(z2).getReal(), 1e-3);
		assertEquals(-3, z3.divide(z2).getImaginary(), 1e-3);
		assertEquals(1, z3.divide(z3).getReal(), 1e-3);
		assertEquals(0, z3.divide(z3).getImaginary(), 1e-3);
	}
	
	
	@Test
	public void testInvert() {
		assertEquals(1, z1.invert().getReal(), 1e-3);
		assertEquals(0, z1.invert().getImaginary(), 1e-3);
		assertEquals(0, z2.invert().getReal(), 1e-3);
		assertEquals(-1, z2.invert().getImaginary(), 1e-3);
		assertEquals(0.12, z3.invert().getReal(), 1e-3);
		assertEquals(-0.16, z3.invert().getImaginary(), 1e-3);
	}
}
