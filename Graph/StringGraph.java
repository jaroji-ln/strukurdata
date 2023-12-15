package Graph;

import java.util.*;

class StringGraph {
    private Map<String, List<String>> adjacencyList;

    public StringGraph() {
        adjacencyList = new HashMap<>();
    }

    // Menambahkan node baru ke graf
    public void addNode(String node) {
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    // Menambahkan edge ke graf
    public void addEdge(String source, String destination) {
        adjacencyList.get(source).add(destination);
        // Jika graf tidak terarah, tambahkan baris berikut:
        // adjacencyList.get(destination).add(source);
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
        StringGraph graph = new StringGraph();
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
