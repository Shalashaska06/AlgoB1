package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PriceCalculatorTest {

	@Test
	void testCalculatorCasNormal1() {
		char category = 'A';
		int age = 10;
		int day = 3;
		
		
		int Price = new PriceCalculator().compute(category, day, age);
		int FinalPrice = 10;
		assertEquals(Price,FinalPrice);
		
	}
	@Test
	void testCalculatorCasNormal2() {
		char category = 'B';
		int age = 43;
		int day = 1;
		
		
		int Price = new PriceCalculator().compute(category, day, age);
		int FinalPrice = 16;
		assertEquals(Price,FinalPrice);
	
	}
	
	
	@Test
	void testCalculatorEmbranchement() {
		char category = 'B';
		int age = 77;
		int day = 6;
		
		
		int Price = new PriceCalculator().compute(category, day, age);
		int FinalPrice = 25;
		assertEquals(Price,FinalPrice);
	
	}
	
	@Test
	void testCalculatorError() {
		char category = 'A';
		int age = -12;
		int day = 6;
		
		
		int Price = new PriceCalculator().compute(category, day, age);
		int FinalPrice = -1;
		assertEquals(Price,FinalPrice);
	
	}
	
	
	@Test
	void testCalculatorLimit() {
		char category = 'B';
		int age = 255;
		int day = 7;
		
		
		int Price = new PriceCalculator().compute(category, day, age);
		int FinalPrice = 25;
		assertEquals(Price,FinalPrice);
	
	}
	
	@Test
	void testCalculatorEmbranchement() {
		char category = 'A';
		int age = 10000000000;
		int day = 1;
		
		
		int Price = new PriceCalculator().compute(category, day, age);
		int FinalPrice = -1;
		assertEquals(Price,FinalPrice);
	
	}
}
