package math.functions.basic.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import math.functions.basic.IntegerFunction;
import math.functions.basic.ModuloFunction;

public class ModuloTest {
	
	private IntegerFunction modulo1, modulo2, modulo3;
	private int x1, x2, x3, x4;

	
	
	@Before
	public void setUpFunctions() throws Exception {
		modulo1 = new ModuloFunction(1);
		modulo2 = new ModuloFunction(2);
		modulo3 = new ModuloFunction(10);
	}
	
	@Before
	public void setUpXValues() throws Exception {
		x1 = 0;
		x2 = 5;
		x3 = 101;
		x4 = -99;
	}

	
	
	@Test
	public void testMod1() {
		assertEquals(0, modulo1.getYValue(x1));
		assertEquals(0, modulo1.getYValue(x2));
		assertEquals(0, modulo1.getYValue(x3));
		assertEquals(0, modulo1.getYValue(x4));
	}

	@Test
	public void testMod2() {
		assertEquals(0, modulo2.getYValue(x1));
		assertEquals(1, modulo2.getYValue(x2));
		assertEquals(1, modulo2.getYValue(x3));
		assertEquals(1, modulo2.getYValue(x4));
	}

	@Test
	public void testMod3() {
		assertEquals(0, modulo3.getYValue(x1));
		assertEquals(5, modulo3.getYValue(x2));
		assertEquals(1, modulo3.getYValue(x3));
		assertEquals(1, modulo3.getYValue(x4));
	}


}
