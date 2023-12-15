package Graph;

import java.util.*;

class DijkstraGraph {
    private final Map<Integer, List<Node>> adjacencyList;

    public DijkstraGraph() {
        adjacencyList = new HashMap<>();
    }

    // Menambahkan edge ke graf
    public void addEdge(int source, int destination, int weight) {
        adjacencyList.putIfAbsent(source, new ArrayList<>());
        adjacencyList.get(source).add(new Node(destination, weight));
    }

    // Algoritma Dijkstra untuk mencari lintasan terpendek
    public int dijkstra(int start, int end) {
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(node -> node.weight));
        Map<Integer, Integer> distances = new HashMap<>();
        Set<Integer> visited = new HashSet<>();

        // Inisialisasi jarak
        for (int node : adjacencyList.keySet()) {
            distances.put(node, Integer.MAX_VALUE);
        }
        distances.replace(start, 0);
        queue.add(new Node(start, 0));

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            int currentNodeId = currentNode.node;

            if (visited.contains(currentNodeId)) {
                continue;
            }
            visited.add(currentNodeId);

            for (Node neighbor : adjacencyList.getOrDefault(currentNodeId, Collections.emptyList())) {
                int newDist = distances.get(currentNodeId) + neighbor.weight;
                if (newDist < distances.get(neighbor.node)) {
                    distances.replace(neighbor.node, newDist);
                    queue.add(new Node(neighbor.node, newDist));
                }
            }
        }
        return distances.get(end);
    }

    static class Node {
        int node;
        int weight;

        Node(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        DijkstraGraph graph = new DijkstraGraph();
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 3, 2);
        graph.addEdge(1, 2, 5);
        graph.addEdge(2, 3, 7);
        graph.addEdge(3, 4, 2);
        graph.addEdge(4, 0, 4);
        graph.addEdge(4, 1, 4);
        graph.addEdge(4, 5, 6);

        int shortestPath = graph.dijkstra(0, 3);
        System.out.println("Shortest path from 0 to 3: " + shortestPath);
    }
}
