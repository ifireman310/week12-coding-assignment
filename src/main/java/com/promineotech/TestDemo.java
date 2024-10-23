package com.promineotech;

import java.util.Random;

public class TestDemo {

	
	/* STEP 1 & 2
	 * Adds two positive integers together, throws illegal argument exception otherwise
	 */
	
	public int addPositive(int a, int b) throws IllegalArgumentException {
		if (a > 0 && b > 0) {
			return a+b;
		} else {
			throw new IllegalArgumentException("Both parameters must be positive!");
		}	
	};
	
	
	/* STEP 3
	 * This method is meant to multiply two negative integers
	 * If a 0 or positive number is input, we expect the method to throw an illegal 
	 * argument exception
	 */
	
	public double multiplyNegatives(int a, int b) throws IllegalArgumentException {
		
		if (a < 0 && b < 0) {
			return a*b;
		} else {
			throw new IllegalArgumentException("Both parameters must be negative!");
		}
		
	}
	
	
	/* STEP 4-1
	 * Gets a random integer from 1-10 and returns that integer squared
	 * 
	 */
	
	public int randomNumberSquared() {
		int random_integer = getRandomInt();
		return random_integer*random_integer;
	}
	
	public int getRandomInt() {
		Random random = new Random();
		return random.nextInt(10) + 1;
	}
	
}