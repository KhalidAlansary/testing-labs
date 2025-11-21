package org.example;

import java.util.Collections;
import java.util.Vector;

class DataAnalyzer {
	Vector<Integer> data;
	DataAnalyzer(FileHandler fileHandler) {
		this.data = fileHandler.getData();
	}
	Integer GetMin() {
		return Collections.min(data);
	}
	Integer GetMax() {
		return Collections.max(data);
	}
	Integer GetAeverage() {
		Integer sum = 0;
		for (Integer val : data) {
			sum += val;
		}
		return sum / data.size();
	}
}
