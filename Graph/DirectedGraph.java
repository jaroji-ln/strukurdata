package Graph;

import java.util.*;

class DirectedGraph {
    private Map<String, List<String>> adjacencyList;

    public DirectedGraph() {
        adjacencyList = new HashMap<>();
    }

    // Menambahkan node baru ke graf
    public void addNode(String node) {
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    // Menambahkan edge ke graf (hanya satu arah untuk graf berarah)
    public void addEdge(String source, String destination) {
        // Pastikan node sumber ada dalam adjacency list
        adjacencyList.putIfAbsent(source, new ArrayList<>());

        // Tambahkan edge dari sumber ke tujuan
        adjacencyList.get(source).add(destination);
    }

    // Mendapatkan daftar tetangga dari node
    public List<String> getNeighbors(String node) {
        return adjacencyList.getOrDefault(node, Collections.emptyList());
    }

    // Mencetak graf
    public void printGraph() {
        for (String node : adjacencyList.keySet()) {
            System.out.print("Node " + node + " terhubung dengan: ");
            for (String neighbor : adjacencyList.get(node)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        DirectedGraph graph = new DirectedGraph();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");

        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("B", "C");
        graph.addEdge("C", "A");
        graph.addEdge("C", "D");

        graph.printGraph();
    }
}
