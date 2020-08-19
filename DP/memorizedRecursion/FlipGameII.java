package memorizedRecursion;

import java.util.HashMap;
import java.util.Map;

/**
 * You are playing the following Flip Game with your friend: Given a string that contains only these two 
 * characters: + and -, you and your friend take turns to flip two consecutive "++" into "--". The game 
 * ends when a person can no longer make a move and therefore the other person will be the winner.
 * Write a function to determine if the starting player can guarantee a win.
 * 
 * Note: this problem is NOT asking if the starting player (1p) will win no matter how he flips the string, 
 * instead, it is asking if 1p will win after he chooses to flip two certain "+". The function canWin()
 * means that in the current state, there is at least one way of flipping to make 1p win, so !canWin() 
 * means that in the current state, no matter how to flip, the player can not win the game.
 * 
 * Examples:
 * 1. Given s = "++++", return true. The starting player can guarantee a win by
 * flipping the middle "++" to become "+--+".
 * 
 * Thoughts: in the first thought we may think that the helper function should include a parameter to represent
 * the player (1p or 2p), but actually it is not necessary, because both players are using the same strategy,
 * and will make the same decision, so there is no need to mark them as different.
 * 
 * Time: O(2^n), where n is the length of the input string. Without memorization the time complexity is O(n^n),
 * because there is at most n "+" to flip so the height of the recursion tree is n. By using cache, it can be
 * reduced to O(2^n) because there can be at most 2^n possibilities to check for a length n string.
 * Space: O(n), because a char array is created.
 */
public class FlipGameII {
	public boolean canWin(String input) {
		return canWin(input.toCharArray(), new HashMap<>());
	}
	
	private boolean canWin(char[] chArr, Map<String, Boolean> mem) {
		String key = new String(chArr);
		Boolean res = mem.get(key);
		if (res != null) {
			return res;
		}
	    for (int i = 0; i < chArr.length - 1; i++) {
	    	if (chArr[i] == '+' && chArr[i + 1] == '+') {
	    		chArr[i] = '-';
	    		chArr[i + 1] = '-';
	    		boolean opCanWin = canWin(chArr, mem); // note: can not directly return here, need restore the status first
	    		chArr[i] = '+';
	    		chArr[i + 1] = '+';
	    		if (!opCanWin) { // if there is a flip which makes the other player lose, the first player wins
	    			mem.put(key, true);
	    			return true;
	    		}
	    	}
	    }
	    mem.put(key, false);
	    return false;
	}
	
	public static void main(String[] args) {
		FlipGameII test = new FlipGameII();
		String input = "+++----+++--++";
		System.out.println(test.canWin(input));
	}
}
