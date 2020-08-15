package topologicalSort;

import java.util.ArrayList;
import java.util.List;

import impl.Utils;

/**
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 * Some courses may have prerequisites, for example, to take course 0, you have to first take course 1, which is expressed
 * as a pair: [0, 1]
 * Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish
 * all courses.
 * There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return
 * an empty array.
 * 
 * Assumptions:
 * 1. The input prerequites is a graph represented by a list of edges, not adjacency matrices. You may assume that there are no
 * duplicate edges in the input prerequisites.
 * 
 * Examples:
 * 1. 2, [[1, 0]] There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course
 * order is [0, 1]
 * 2. 4, [[1, 0], [2, 0], [3, 1], [3, 2]] There are a total of 4 courses to take. To take course 3 you should have finished course 1
 * and 2. Both courses 1 and 2 should be taken after you finish course 0. So one correct course order is [0, 1, 2, 3]. Another correct
 * ordering is [0, 2, 1, 3].
 *  
 * Algorithm: topological sort
 *  
 * Time: O(v + e), where v is the number of courses, and e is the number of prerequisites (topological sort is liner time)
 * Space: O(v)
 */
public class CourseScheduleII {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		int[] indegrees = new int[numCourses];
		for (int[] edge : prerequisites) {
			indegrees[edge[0]]++;
		}
		List<Integer> coursesTaken = new ArrayList<>();
		int index = 0;
		for (int i = 0; i < numCourses; i++) {
			if (indegrees[i] == 0) {
				coursesTaken.add(i);
			}
		}
		while (index < coursesTaken.size()) {
			int courseTaken = coursesTaken.get(index++);
			for (int[] edge : prerequisites) {
				if (courseTaken == edge[1]) {
					int courseToTake = edge[0];
					indegrees[courseToTake]--;
					if (indegrees[courseToTake] == 0) {
						coursesTaken.add(courseToTake);
					}
				}
			}
		}
		if (coursesTaken.size() != numCourses) {
			return new int[0];
		} else {
			int[] res = new int[coursesTaken.size()];
			for (int i = 0; i < coursesTaken.size(); i++) {
				res[i] = coursesTaken.get(i);
			}
			return res;
		}
	}
	
	public static void main(String[] args) {
		CourseScheduleII test = new CourseScheduleII();
		int numCourses = 4;
		int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
		Utils.printArray(test.findOrder(numCourses, prerequisites));
	}
}
