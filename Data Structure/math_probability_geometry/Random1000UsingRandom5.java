package math_probability_geometry;

import impl.RandomFive;

public class Random1000UsingRandom5 {
	public int random1000() {
		while (true) {
			int num = 0;
			for (int i = 0; i < 5; i++) {
				num = num * 5 + RandomFive.random5();
			}
			// choose 3000 instead of 1000 to reduce the number of expected random5() calls
			if (num < 3000) {
				return num % 1000;
			}
		}
	}
}
