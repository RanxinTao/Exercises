package array1Pointer;

import java.util.ArrayList;
import java.util.List;

/**
 * You are playing the following Flip Game with your friend: Given a string
 * that contains only these two characters: + and -, you and your friend take
 * turns to flip two consecutive "++" into "--". The game ends when a person
 * can no longer make a move and therefore the other person will be the winner.
 * Write a function to compute all possible states of the string after one
 * valid move.
 * If there is no valid move, return an empty list [].
 * 
 * Examples:
 * 1. Given s = "++++", after one move, it may become one of the
 * following states:
 * [
 *   "--++",
 *   "+--+",
 *   "++--"
 * ]
 * 
 * Time: O(n)
 * Space: O(n), because a char array is created
 */
public class FlipGame {
	public List<String> generatePossibleNextMoves(String input) {
		List<String> res = new ArrayList<>();
	    char[] chArr = input.toCharArray();
	    for (int i = 0; i < chArr.length - 1; i++) {
	    	if (chArr[i] == '+' && chArr[i + 1] == '+') {
	    		chArr[i] = '-';
	    		chArr[i + 1] = '-';
	    		res.add(new String(chArr));
	    		chArr[i] = '+';
	    		chArr[i + 1] = '+';
	    	}
	    }
	    return res;
	}
	
	public static void main(String[] args) {
		FlipGame test = new FlipGame();
		String input = "++++";
		System.out.println(test.generatePossibleNextMoves(input));
	}
}
