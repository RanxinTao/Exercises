package array2Pointers_sameDirection;

/**
 * Given a string, replace adjacent, repeated characters with the character followed by the number of repeated occurrences. 
 * If the character does not has any adjacent, repeated occurrences, it is not changed.
 *
 * Assumptions:
 * The string is not null
 * The characters used in the original string are guaranteed to be 'a' - 'z'
 * 
 * Examples:
 * "abbcccdeee" -> "ab2c3de3"
 */
public class CompressStringI { // StringBuilder is much easier and concise for this problem
	/*public String compress(String input) {
		if (input.length() == 0) {
			return input;
		}
		char[] charArray = input.toCharArray();
		int end = 0;
		int count = 1;
		for (int i = 1; i < input.length(); i++) {
			if (charArray[end] == charArray[i]) {
				count++;
			} else {
				end++; // add the character
				if (count > 1) {
					String cntStr = count + "";
					for (int j = 0; j < cntStr.length(); j++) {
						charArray[end] = cntStr.charAt(j);
						end++;
					}
				}
				charArray[end] = charArray[i];
				count = 1;
			}
		}
		end++; // add last character
		if (count > 1) {	
			String cntStr = count + "";
			for (int i = 0; i < cntStr.length(); i++) {
				charArray[end] = cntStr.charAt(i);
				end++;
			}
		}
		return new String(charArray, 0, end);
	}*/
	
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
				output.append(last);
				if (count > 1) {
					output.append(count);
				}
				// update last and reset count
				last = input.charAt(i);
				count = 1;
			}
		}
		output.append(last);
		if (count > 1) {
			output.append(count);
		}
		return output.toString();
	}
	
	public static void main(String[] args) {
		CompressStringI test = new CompressStringI();
		String input = "ffffffffffffffnnnnnnnnnnnnnnnnnnnnnmmmmmmmmmmmmmmmmmmmmmmmmccccccccccccccccccccccrrrrrrrrrrrrrrr"
				+ "ddddddddddhhhhhhhhhhhhhhhhhhhhhhhhbbbbbbbbbbbbbbbbbbnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnddddddddddddddddddd"
				+ "sssssssssssssssssssssuuuuuuummmmmmmmmmmmmmmmmggggggggggggggggggggggggggggooooooooooooooaaaaaaaaaaaa"
				+ "ppppppppppppppppppppppppeeeeeeeeeeeeeessxxxxxxxxxxxxxxxxxxxxxxxxxxxxxrrrrrrrrrrrrrrrrrrrrrrrrrrr"
				+ "ooooooooooooooooooooooooooiiiiiiiiiiiinnnnnnnnnnnnnffffffffffffzzzzzzzzjjyyyyyyyyyyyyyyyyhhhhh"
				+ "wwwwwwwwwzzzzzzzzzzzzzzzzzzzzzzzqqqqqqqqqqqqqqqqqqqqqqqqffffffffffoooooooooooooooooooooooooooo"
				+ "ttttttttttttttttttuuuuuuuuuuuuuccccccccccccpppppppppppp";
		System.out.println(test.compress(input)); // f14n21m24c22r15d10h24b18n30d19s21u7m17g28o14a12p24e14s2x29r27o26i12n13f12z8j2y16h5w9z23q24f10o28t18u13c12p12
	}
}
