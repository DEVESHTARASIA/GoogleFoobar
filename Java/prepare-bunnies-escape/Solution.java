import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Solution {

	public static int shortestPath(int[][] map, int maxObstacle) {
		int ans = 0;
		int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
		Queue<int[]> queue = new LinkedList<>();
		Set<String> visited = new HashSet<>();

		maxObstacle = map[0][0] == 1 ? maxObstacle-- : maxObstacle;
		queue.add(new int[] { 0, 0, maxObstacle });
		visited.add(0 + "-" + 0 + "-" + maxObstacle);

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int[] cell = queue.remove();
				if (cell[0] == map.length - 1 && cell[1] == map[0].length - 1) {
					return ans + 1;
				}
				for (int[] dir : dirs) {
					int row = cell[0] + dir[0];
					int col = cell[1] + dir[1];
					int obstacleCount = cell[2];

					if (row >= 0 && row < map.length && col >= 0 && col < map[0].length
							&& (map[row][col] == 0 || (map[row][col] == 1 && obstacleCount > 0))) {
						if (map[row][col] == 1) {
							obstacleCount--;
						}

						if (!visited.contains(row + "-" + col + "-" + obstacleCount)) {
							queue.add(new int[] { row, col, obstacleCount });
							visited.add(row + "-" + col + "-" + obstacleCount);
						}
					}
				}
			}
			ans++;
		}
		return ans;
	}

	public static int solution(int[][] map) {
        return shortestPath(map, 1);
    }
	
	public static void main(String[] args) {
		int a[][] = { { 0, 0, 0, 0, 0, 0 }, { 1, 1, 1, 1, 1, 0 }, { 0, 0, 0, 0, 0, 0 }, { 0, 1, 1, 1, 1, 1 },
				{ 0, 1, 1, 1, 1, 1 }, { 0, 0, 0, 0, 0, 0 } };
		int b[][] = { { 0, 1, 1, 0 }, { 0, 0, 0, 1 }, { 1, 1, 0, 0 }, { 1, 1, 1, 0 } };
		System.out.println(solution(a));
	}
}