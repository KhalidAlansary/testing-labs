package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Vector;

public class FileHandler {
	String filePath;
	public Vector<Integer> getData() {
		Vector<Integer> data = new Vector<>();
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(filePath));
			String line = reader.readLine();
			while (line != null) {
				data.add(Integer.parseInt(line));
				line = reader.readLine();
			}
			reader.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
}
