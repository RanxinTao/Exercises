package check1_other;

/**
 * There is a fence with n posts, each post can be painted with one of the k colors.
 * You have to paint all the posts such that no more than two adjacent fences posts have the same color.
 * Return the total number of ways you can paint the fence.
 * 
 * Assumptions: 
 * 1. n and k are non-negative integers.
 * 
 * Thoughts1: This problem is similar to the Fibnonacci Number. There are 2 situations: 
 * 1. two previous posts are already in the same color, we know there are n1 ways (equals to the total 
 * number of ways if the fence has n - 2 posts) that meet this condition, because the previous post has to 
 * be the same color as the one before the previous post. This situation will contributes n1 * (k - 1) ways,
 * k - 1 because we can't use the same color one more time.
 * 2. two previous posts are in the different colors, then there are n1 * (k - 1) ways that meet this 
 * condition, because the previous post has to be the different color than the one before the previous post.
 * In this case, we can use any color from the k colors this time, so it will contribute n1 * (k - 1) * k ways.
 * So we have in total n1 * (k - 1) + n1 * (k - 1) * k = n1 * (k^2 - 1) ways.
 * 
 * Thoughts2: the above thoughts is actually wrong, this is because in the situation 1 where two previous posts
 * are already in the same color, the number of ways are not always n1, e.g., 
 * if we have ... | ... | red | red (n1 ways) |, this still meets the requirement, and the next color cannot be 
 * red, so we will have ... | ... | red | red (n1 ways) | not red |, and now when we are trying to calcuate the
 * number of ways when two previous posts are in the same color, can we say it is n1? No, because the previous 
 * one cannot be red at all.
 * The correct way is, calculating the number of ways when two previous posts are in the different colors 
 * (situation 2), which is n1 * (k - 1), and then use n2 - n1 * (k - 1) for the situation 1 (because the previous
 * color is either same or not same as the one before the previous color).
 * 
 * Time: O(n)
 * Space: O(1)
 */
public class PaintFence {
	public int numWays(int n, int k) {
		if (k == 0 || n == 0) {
			return 0;
		}
		if (n == 1) {
			return k;
		}
	    int n1 = k; // if the fence has 1 post, the total number of ways is k
	    int n2 = k * k; // if the fence has 2 posts, the total number of ways is k * k
	    for (int i = 3; i <= n; i++) { // what we want is the total number of ways when the fence has n post
	    	int n3 = n1 * (k - 1) * k + (n2 - n1 * (k - 1)) * (k - 1);
	    	n1 = n2;
	    	n2 = n3;
	    }
	    return n2;
	}
	
	public static void main(String[] args) {
		PaintFence test = new PaintFence();
		int n = 3;
		int k = 2;
		System.out.println(test.numWays(n, k));
	}
}
