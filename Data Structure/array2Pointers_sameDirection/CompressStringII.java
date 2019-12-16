package array2Pointers_sameDirection;

/**
 * Given a string, replace adjacent, repeated characters with the character followed by the number of repeated occurrences. 
 *
 * Assumptions:
 * The string is not null
 * The characters used in the original string are guaranteed to be 'a' - 'z'
 * 
 * Examples:
 * "abbcccdeee" -> "a1b2c3d1e3"
 */
public class CompressStringII { // using char array here will add more complexity because the output may be longer than input	
	public String compress(String input) {
		if (input.length() == 0) {
			return input;
		}
		StringBuilder output = new StringBuilder();
		char last = input.charAt(0);
		int count = 1;
		for (int i = 1; i < input.length(); i++) {
			if (input.charAt(i) == last) {
				count++;
			} else {
				output.append(last).append(count);
				// update last and reset count
				last = input.charAt(i);
				count = 1;
			}
		}
		output.append(last).append(count);
		return output.toString();
	}
	
	public static void main(String[] args) {
		CompressStringII test = new CompressStringII();
		String input = "abbcccdeee";
		System.out.println(test.compress(input));
	}
}
