package dataStructures;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class graph {
    private Map<Integer, List<Integer>> adjList;
    private boolean isDirected;

    // Constructor to initialize the Graph
    public graph(boolean isDirected) {
        this.adjList = new HashMap<>();
        this.isDirected = isDirected;
    }

    // Add a new vertex to the graph
    public void addVertex(int vertex) {
        adjList.putIfAbsent(vertex, new ArrayList<>());
    }

    // Add an edge between two vertices
    public void addEdge(int v1, int v2) {
        adjList.get(v1).add(v2);
        if (!isDirected) {
            adjList.get(v2).add(v1);
        }
    }

    // Remove an edge between two vertices
    public void removeEdge(int v1, int v2) {
        List<Integer> eV1 = adjList.get(v1);
        List<Integer> eV2 = adjList.get(v2);
        if (eV1 != null) eV1.remove(Integer.valueOf(v2));
        if (!isDirected && eV2 != null) eV2.remove(Integer.valueOf(v1));
    }

    // Check if an edge exists between two vertices
    public boolean hasEdge(int v1, int v2) {
        List<Integer> edges = adjList.get(v1);
        if (edges != null) {
            return edges.contains(v2);
        }
        return false;
    }

    // Perform a Depth-First Search (DFS) starting from vertex
    public void dfs(int start) {
        Map<Integer, Boolean> visited = new HashMap<>();
        dfsHelper(start, visited);
    }

    private void dfsHelper(int vertex, Map<Integer, Boolean> visited) {
        if (visited.getOrDefault(vertex, false)) {
            return;
        }
        visited.put(vertex, true);
        System.out.print(vertex + " ");

        for (int adjVertex : adjList.getOrDefault(vertex, new ArrayList<>())) {
            if (!visited.getOrDefault(adjVertex, false)) {
                dfsHelper(adjVertex, visited);
            }
        }
    }

    // Display the graph as adjacency list
    public void display() {
        for (Map.Entry<Integer, List<Integer>> vertex : adjList.entrySet()) {
            System.out.print(vertex.getKey() + " -> ");
            for (Integer edge : vertex.getValue()) {
                System.out.print(edge + " ");
            }
            System.out.println();
        }
    }
    public static void demoGraph() {
        graph graph = new graph(false);  // Create an undirected graph

        // Adding vertices
        graph.addVertex(0);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);

        // Adding edges
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);

        System.out.println("Graph after adding edges:");
        graph.display();

        // Removing an edge
        graph.removeEdge(2, 0);
        System.out.println("Graph after removing edge between 2 and 0:");
        graph.display();

        // Check for edge existence
        boolean hasEdge = graph.hasEdge(2, 1);
        System.out.println("Does an edge exist between 2 and 1? " + hasEdge);

        // Depth-First Search from a vertex
        System.out.println("Depth-First Search starting from vertex 2:");
        graph.dfs(2);
    }

}
