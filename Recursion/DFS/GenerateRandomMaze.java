package DFS;

/**
 * Randomly generate a maze of size N * N (where N = 2K + 1) whose corridor and wall's width are both 1 cell. 
 * For each pair of cells on the corridor, there must exist one and only one path between them. (Randomly means that 
 * the solution is generated randomly, and whenever the program is executed, the solution can be different).
 * The wall is denoted by 1 in the matrix and corridor is denoted by 0.
 * 
 * Assumptions:
 * 1. N = 2K + 1 and K >= 0
 * 2. the top left corner must be corridor
 * 3. there should be as many corridor cells as possible
 * 4. for each pair of cells on the corridor, there must exist one and only one path between them
 * 
 * Examples:
 * N = 5, one possible maze generated is
 * 0  0  0  1  0
 * 1  1  0  1  0
 * 0  1  0  0  0
 * 0  1  1  1  0
 * 0  0  0  0  0
 * 
 * Time: O(4^(n^2))
 * Space: O(n^2)
 */
public class GenerateRandomMaze {
	public int[][] maze(int n) {
		int[][] maze = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				maze[i][j] = 1;
			}
		}
		maze[0][0] = 0;
		generateCorridors(maze, 0, 0);
		return maze;
	}

	private void generateCorridors(int[][] maze, int x, int y) {
		Direction[] directions = Direction.values();
		shuffle(directions);
		for (Direction direction : directions) {
			// advance by two steps.
			int nextX = direction.moveX(x, 2);
			int nextY = direction.moveY(y, 2);
			if (isValidWall(maze, nextX, nextY)) {
				// only if the cell is a wall (meaning we have not visited before), we break the two walls to make it corridors.
				maze[direction.moveX(x, 1)][direction.moveY(y, 1)] = 0;
				maze[nextX][nextY] = 0;
				generateCorridors(maze, nextX, nextY);
			}
		}
	}

	private void shuffle(Direction[] directions) {
		for (int i = 0; i < directions.length; i++) {
			int index = (int) (Math.random() * (directions.length - i));
			// swap directions[i] and directions[i + index]
			Direction tmp = directions[i];
			directions[i] = directions[i + index];
			directions[i + index] = tmp;
		}
	}

	private boolean isValidWall(int[][] maze, int x, int y) {
		return x >= 0 && x < maze.length && y >= 0 && y < maze.length && maze[x][y] == 1;
	}

	enum Direction {
		NORTH(-1, 0), SOUTH(1, 0), EAST(0, -1), WEST(0, 1);

		int deltaX;
		int deltaY;

		Direction(int deltaX, int deltaY) {
			this.deltaX = deltaX;
			this.deltaY = deltaY;
		}

		public int moveX(int x, int times) {
			return x + times * deltaX;
		}

		public int moveY(int y, int times) {
			return y + times * deltaY;
		}
	}
}
