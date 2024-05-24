package algorthims;
import java.util.*;

public class aStar {
    // Grid directions as (row, column): down, up, right, left
    private static final int[][] DIRECTIONS = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };

    public static List<Node> aStarSearch(int[][] grid, Node start, Node goal) {
        PriorityQueue<Node> openSet = new PriorityQueue<>(Comparator.comparingInt(n -> n.f));
        Map<Node, Node> cameFrom = new HashMap<>();
        Map<Node, Integer> gScore = new HashMap<>();
        Map<Node, Integer> fScore = new HashMap<>();

        gScore.put(start, 0);
        fScore.put(start, start.heuristic(goal));

        openSet.add(start);

        while (!openSet.isEmpty()) {
            Node current = openSet.poll();

            if (current.equals(goal)) {
                return reconstructPath(cameFrom, current);
            }

            for (int[] direction : DIRECTIONS) {
                int neighborRow = current.row + direction[0];
                int neighborCol = current.col + direction[1];
                if (isWithinBounds(neighborRow, neighborCol, grid) && grid[neighborRow][neighborCol] == 0) {  // Assuming 0 is walkable
                    Node neighbor = new Node(neighborRow, neighborCol);
                    int tentativeGScore = gScore.get(current) + 1;  // Assuming each step costs 1

                    if (tentativeGScore < gScore.getOrDefault(neighbor, Integer.MAX_VALUE)) {
                        cameFrom.put(neighbor, current);
                        gScore.put(neighbor, tentativeGScore);
                        neighbor.f = tentativeGScore + neighbor.heuristic(goal);
                        if (!openSet.contains(neighbor)) {
                            openSet.add(neighbor);
                        }
                    }
                }
            }
        }
        return Collections.emptyList();
    }

    private static boolean isWithinBounds(int row, int col, int[][] grid) {
        return row >= 0 && row < grid.length && col >= 0 && col < grid[0].length;
    }

    private static List<Node> reconstructPath(Map<Node, Node> cameFrom, Node current) {
        List<Node> totalPath = new LinkedList<>();
        while (cameFrom.containsKey(current)) {
            totalPath.add(0, current);
            current = cameFrom.get(current);
        }
        totalPath.add(0, current);  // Optional: Add the start node
        return totalPath;
    }

    static class Node {
        int row;
        int col;
        int f = Integer.MAX_VALUE;  // Total cost of getting from the start node to the goal by passing by that node.

        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public int heuristic(Node goal) {
            // Using Manhattan distance as heuristic
            return Math.abs(row - goal.row) + Math.abs(col - goal.col);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof Node)) return false;
            Node other = (Node) obj;
            return row == other.row && col == other.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }
    }
    public static void demo() {
        // Define the grid (1 represents obstacles, 0 represents walkable paths)
        int[][] grid = {
                {0, 0, 0, 0, 1},
                {0, 1, 1, 0, 0},
                {0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0},
                {0, 1, 0, 0, 0}
        };

        // Create start and goal nodes
        Node start = new Node(0, 0);
        Node goal = new Node(4, 4);

        // Perform A* Search
        List<Node> path = aStar.aStarSearch(grid, start, goal);

        // Print the path found by A* search
        if (path.isEmpty()) {
            System.out.println("No path found.");
        } else {
            System.out.println("Path found:");
            for (Node node : path) {
                System.out.print("(" + node.row + ", " + node.col + ") -> ");
            }
            System.out.println("end");
        }
    }


}
