package org.example;

public class App {
	public int intMax(int a, int b, int c) {
		return Math.max(a, Math.max(b, c));
	}

	public static void main(String[] args) {
		System.out.println(new App().intMax(1, 2, 3));
	}
}
