package other;

/**
 * Get the Kth number in the Fibonacci Sequence. (K is 0-indexed, the 0th 
 * Fibonacci number is 0 and the 1st Fibonacci number is 1).
 * 
 * Examples:
 * 0th fibonacci number is 0
 * 1st fibonacci number is 1
 * 2nd fibonacci number is 1
 * 3rd fibonacci number is 2
 * 6th fibonacci number is 8
 * 
 * Time: O(K), Space: O(1)
 */
public class FibonacciNumber {
	public long fibonacci(int K) {
		if (K <= 0) {
			return 0;
		}
		long f0 = 0;
		long f1 = 1;
		for (int i = 2; i <= K; i++) {
			long f2 = f0 + f1;
			f0 = f1;
			f1 = f2;
		}
		return f1;
	}
	
	public static void main(String[] args) {
		FibonacciNumber test = new FibonacciNumber();
		System.out.println(test.fibonacci(9));
	}
}