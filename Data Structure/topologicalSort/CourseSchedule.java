package topologicalSort;

import java.util.LinkedList;
import java.util.Queue;

/**
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 * Some courses may have prerequisites, for example, to take course 0, you have to first take course 1, which is expressed
 * as a pair: [0, 1]
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses.
 * 
 * Assumptions:
 * 1. The input prerequites is a graph represented by a list of edges, not adjacency matrices. You may assume that there are no
 * duplicate edges in the input prerequisites.
 * 
 * Examples:
 * 1. 2, [[1, 0]] There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.
 * 2. 2, [[1, 0], [0, 1]] There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take
 * course 0 you should also have finished course 1. So it is impossible.
 * 
 * Algorithm: topological sort
 *  
 * Time: O(v + e), where v is the number of courses, and e is the number of prerequisites (topological sort is liner time)
 * Space: O(v)
 */
public class CourseSchedule {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		int[] indegrees = new int[numCourses];
		for (int[] edge : prerequisites) {
			indegrees[edge[0]]++;
		}
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < numCourses; i++) { // put all nodes with no indegrees
			if (indegrees[i] == 0) {
				queue.offer(i);
			}
		}
		int totalTaken = queue.size();
		while (!queue.isEmpty()) {
			int courseTaken = queue.poll();
			for (int[] edge : prerequisites) {
				if (courseTaken == edge[1]) {
					int courseToTake = edge[0];
					indegrees[courseToTake]--;
					if (indegrees[courseToTake] == 0) {
						queue.offer(courseToTake);
						totalTaken++;
					}
				}
			}
		}
		return totalTaken == numCourses;
	}
}
