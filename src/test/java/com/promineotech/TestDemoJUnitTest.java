package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TestDemoJUnitTest {

	private TestDemo testDemo;
	
	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}

	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
		if(!expectException) {
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		} else {
			assertThatThrownBy(() -> 
			testDemo.addPositive(a, b)).isInstanceOf(IllegalArgumentException.class);
		}
	}

	static Stream<Arguments> argumentsForAddPositive() {
		
		// @formatter: off
		return Stream.of(
			Arguments.of(2,4,6,false),
			Arguments.of(0,1,1,true),
			Arguments.of(-100,-300,0,true)
		);
		// @formatter: on
	}
	
	
	/* STEP 2
	 * 
	 */
	
	@Test
	void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {
		assertThat(testDemo.addPositive(4,5)).isEqualTo(9);
		assertThat(testDemo.addPositive(40,50)).isEqualTo(90);
		assertThat(testDemo.addPositive(1,1)).isEqualTo(2);
	}
	
	/* STEP 3
	 * This test is meant to test two negative integer numbers being multiplied together
	 * If a 0 or positive number is input, we expect the method to throw an illegal 
	 * argument exception
	 */
	
	@Test
	void assertThatPairsOfNegativeNumbersAreMultipliedCorrectly() {
		assertThat(testDemo.multiplyNegatives(-1, -1)).isEqualTo(1);
		assertThat(testDemo.multiplyNegatives(-9, -9)).isEqualTo(81);
		assertThatThrownBy(() -> 
		testDemo.multiplyNegatives(5, 2)).isInstanceOf(IllegalArgumentException.class);
	}
	
	/* STEP 4
	 * 
	 * 
	 */
	
	@Test
	void assertThatNumberSquaredIsCorrect() {
		TestDemo mockDemo = spy(testDemo);
		doReturn(5).when(mockDemo).getRandomInt();
		int fiveSquared = mockDemo.randomNumberSquared();
		assertThat(fiveSquared).isEqualTo(25);
	}
}
