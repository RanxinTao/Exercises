package test;

import java.util.HashMap;
import java.util.Map;

public class TestHashMap {
	public static void main(String[] args) {
		Map<Integer, Integer> map = new HashMap<>();
		int value = map.get(1);
		System.out.println(value);
	}
}
