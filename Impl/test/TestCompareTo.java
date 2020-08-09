package test;

import java.util.Arrays;

import impl.Utils;

public class TestCompareTo {
	public static void main(String[] args) {
		String str1 = "2003";
		String str2 = "89";
		String[] arr = {"2003", "89"};
		Arrays.sort(arr);
		Utils.printArray(arr);
		System.out.println(str1.compareTo(str2));
	}
}
