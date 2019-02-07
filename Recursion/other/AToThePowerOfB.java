package other;

/**
 * Evaluate a to the power of b, assuming both a and b are integers and b is
 * non-negative.
 * 
 * Examples:
 * power(2, 0) = 1
 * power(2, 3) = 8
 * power(0, 10) = 0
 * power(-2, 5) = -32
 * 
 * Time: O(logb), Space: O(logb)
 */
public class AToThePowerOfB {
	public long power(int a, int b) {
		if (b == 0) {
			return 1;
		}
		long half = power(a, b / 2);
		return b % 2 == 0 ? half * half : half * half * a;
	}
}
