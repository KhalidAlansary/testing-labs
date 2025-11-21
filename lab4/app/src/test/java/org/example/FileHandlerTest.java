package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;

class FileHandlerTest {

	private FileHandler fileHandler;

	@BeforeEach
	void setUp() {
		fileHandler = new FileHandler();
	}

	@Test
	void testSetFilePath() {
		String testPath = "/test/path/file.txt";
		fileHandler.setFilePath(testPath);
		assertEquals(testPath, fileHandler.filePath);
	}

	@Test
	void testGetDataWithValidFile(@TempDir Path tempDir) throws IOException {
		// Create a temporary file with integer data
		File testFile = tempDir.resolve("test_data.txt").toFile();
		try (FileWriter writer = new FileWriter(testFile)) {
			writer.write("10\n");
			writer.write("20\n");
			writer.write("30\n");
		}

		fileHandler.setFilePath(testFile.getAbsolutePath());
		Vector<Integer> result = fileHandler.getData();

		assertNotNull(result);
		assertEquals(3, result.size());
		assertEquals(10, result.get(0));
		assertEquals(20, result.get(1));
		assertEquals(30, result.get(2));
	}

	@Test
	void testGetDataWithEmptyFile(@TempDir Path tempDir) throws IOException {
		File testFile = tempDir.resolve("empty_file.txt").toFile();
		testFile.createNewFile();

		fileHandler.setFilePath(testFile.getAbsolutePath());
		Vector<Integer> result = fileHandler.getData();

		assertNotNull(result);
		assertTrue(result.isEmpty());
	}

	@Test
	void testGetDataWithNonExistentFile() {
		fileHandler.setFilePath("/non/existent/file.txt");
		Vector<Integer> result = fileHandler.getData();

		assertNotNull(result);
		assertTrue(result.isEmpty());
	}

	@Test
	void testGetDataWithNullPath() {
		fileHandler.setFilePath(null);
		Vector<Integer> result = fileHandler.getData();

		assertNotNull(result);
		assertTrue(result.isEmpty());
	}

	@Test
	void testGetDataWithInvalidIntegerData(@TempDir Path tempDir) throws IOException {
		File testFile = tempDir.resolve("invalid_data.txt").toFile();
		try (FileWriter writer = new FileWriter(testFile)) {
			writer.write("10\n");
			writer.write("not_a_number\n");
			writer.write("30\n");
		}

		fileHandler.setFilePath(testFile.getAbsolutePath());
		Vector<Integer> result = fileHandler.getData();

		// Due to exception handling, the vector will be returned but incomplete
		assertNotNull(result);
		assertEquals(1, result.size());
		assertEquals(10, result.get(0));
	}

	@Test
	void testGetDataWithSingleInteger(@TempDir Path tempDir) throws IOException {
		File testFile = tempDir.resolve("single_value.txt").toFile();
		try (FileWriter writer = new FileWriter(testFile)) {
			writer.write("42\n");
		}

		fileHandler.setFilePath(testFile.getAbsolutePath());
		Vector<Integer> result = fileHandler.getData();

		assertNotNull(result);
		assertEquals(1, result.size());
		assertEquals(42, result.get(0));
	}

	@Test
	void testGetDataWithNegativeNumbers(@TempDir Path tempDir) throws IOException {
		File testFile = tempDir.resolve("negative_numbers.txt").toFile();
		try (FileWriter writer = new FileWriter(testFile)) {
			writer.write("-10\n");
			writer.write("-20\n");
			writer.write("30\n");
		}

		fileHandler.setFilePath(testFile.getAbsolutePath());
		Vector<Integer> result = fileHandler.getData();

		assertNotNull(result);
		assertEquals(3, result.size());
		assertEquals(-10, result.get(0));
		assertEquals(-20, result.get(1));
		assertEquals(30, result.get(2));
	}
}
