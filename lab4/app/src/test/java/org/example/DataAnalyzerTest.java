package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Vector;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DataAnalyzerTest {

	@Mock
	private FileHandler fileHandler;

	private DataAnalyzer dataAnalyzer;

	@Test
	void testGetMinWithPositiveNumbers() {
		Vector<Integer> testData = new Vector<>();
		testData.add(10);
		testData.add(5);
		testData.add(20);
		testData.add(3);

		when(fileHandler.getData()).thenReturn(testData);
		dataAnalyzer = new DataAnalyzer(fileHandler);

		assertEquals(3, dataAnalyzer.GetMin());
		verify(fileHandler, times(1)).getData();
	}

	@Test
	void testGetMaxWithPositiveNumbers() {
		Vector<Integer> testData = new Vector<>();
		testData.add(10);
		testData.add(5);
		testData.add(20);
		testData.add(3);

		when(fileHandler.getData()).thenReturn(testData);
		dataAnalyzer = new DataAnalyzer(fileHandler);

		assertEquals(20, dataAnalyzer.GetMax());
		verify(fileHandler, times(1)).getData();
	}

	@Test
	void testGetAeverageWithPositiveNumbers() {
		Vector<Integer> testData = new Vector<>();
		testData.add(10);
		testData.add(20);
		testData.add(30);

		when(fileHandler.getData()).thenReturn(testData);
		dataAnalyzer = new DataAnalyzer(fileHandler);

		assertEquals(20, dataAnalyzer.GetAeverage());
		verify(fileHandler, times(1)).getData();
	}

	@Test
	void testGetMinWithNegativeNumbers() {
		Vector<Integer> testData = new Vector<>();
		testData.add(-10);
		testData.add(-5);
		testData.add(-20);

		when(fileHandler.getData()).thenReturn(testData);
		dataAnalyzer = new DataAnalyzer(fileHandler);

		assertEquals(-20, dataAnalyzer.GetMin());
	}

	@Test
	void testGetMaxWithNegativeNumbers() {
		Vector<Integer> testData = new Vector<>();
		testData.add(-10);
		testData.add(-5);
		testData.add(-20);

		when(fileHandler.getData()).thenReturn(testData);
		dataAnalyzer = new DataAnalyzer(fileHandler);

		assertEquals(-5, dataAnalyzer.GetMax());
	}

	@Test
	void testGetAeverageWithMixedNumbers() {
		Vector<Integer> testData = new Vector<>();
		testData.add(-10);
		testData.add(10);
		testData.add(20);
		testData.add(-20);

		when(fileHandler.getData()).thenReturn(testData);
		dataAnalyzer = new DataAnalyzer(fileHandler);

		assertEquals(0, dataAnalyzer.GetAeverage());
	}

	@Test
	void testWithSingleElement() {
		Vector<Integer> testData = new Vector<>();
		testData.add(42);

		when(fileHandler.getData()).thenReturn(testData);
		dataAnalyzer = new DataAnalyzer(fileHandler);

		assertEquals(42, dataAnalyzer.GetMin());
		assertEquals(42, dataAnalyzer.GetMax());
		assertEquals(42, dataAnalyzer.GetAeverage());
	}

	@Test
	void testGetAeverageWithIntegerDivision() {
		Vector<Integer> testData = new Vector<>();
		testData.add(10);
		testData.add(15);
		testData.add(20);

		when(fileHandler.getData()).thenReturn(testData);
		dataAnalyzer = new DataAnalyzer(fileHandler);

		// 45 / 3 = 15
		assertEquals(15, dataAnalyzer.GetAeverage());
	}

	@Test
	void testGetAeverageWithTruncation() {
		Vector<Integer> testData = new Vector<>();
		testData.add(10);
		testData.add(11);

		when(fileHandler.getData()).thenReturn(testData);
		dataAnalyzer = new DataAnalyzer(fileHandler);

		// 21 / 2 = 10 (integer division truncates)
		assertEquals(10, dataAnalyzer.GetAeverage());
	}
}
