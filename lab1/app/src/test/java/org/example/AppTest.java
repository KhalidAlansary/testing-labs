package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AppTest {
	@Test
	void testIntMax() {
		App classUnderTest = new App();
		assertEquals(3, classUnderTest.intMax(1, 2, 3));
		assertEquals(3, classUnderTest.intMax(3, 2, 1));
		assertEquals(3, classUnderTest.intMax(2, 3, 1));
		assertEquals(-1, classUnderTest.intMax(-1, -2, -3));
		assertEquals(3, classUnderTest.intMax(3, 3, 1));
		assertEquals(3, classUnderTest.intMax(3, 3, 3));
		assertEquals(3, classUnderTest.intMax(1, 3, 3));
	}
}
