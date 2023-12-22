package Graph;

import java.util.*;

class Sisi {
    String destination;
    int weight;

    public Sisi(String destination, int weight) {
        this.destination = destination;
        this.weight = weight;
    }
}

public class DijkstraGraphTraversal {
    private Map<String, List<Sisi>> adjacencyList = new HashMap<>();

    public void addNode(String node) {
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    public void addEdge(String source, String destination, int weight) {
        // Pastikan kedua node (sumber dan tujuan) sudah ada dalam adjacencyList.
        addNode(source);
        addNode(destination);

        adjacencyList.get(source).add(new Sisi(destination, weight));
        // Untuk graf tidak terarah, tambahkan baris berikut:
        adjacencyList.get(destination).add(new Sisi(source, weight));
    }

    public int dijkstra(String start, String end) {
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(Map.Entry.comparingByValue());
        Map<String, Integer> distances = new HashMap<>();
        Set<String> settled = new HashSet<>();

        for (String node : adjacencyList.keySet()) {
            distances.put(node, Integer.MAX_VALUE);
        }
        distances.put(start, 0);
        pq.add(new AbstractMap.SimpleEntry<>(start, 0));

        while (!pq.isEmpty()) {
            String current = pq.poll().getKey();
            if (current.equals(end)) {
                return distances.get(end);
            }

            if (settled.contains(current)) {
                continue;
            }
            settled.add(current);

            for (Sisi edge : adjacencyList.getOrDefault(current, Collections.emptyList())) {
                if (!settled.contains(edge.destination)) {
                    int newDistance = distances.get(current) + edge.weight;
                    if (newDistance < distances.get(edge.destination)) {
                        distances.put(edge.destination, newDistance);
                        pq.add(new AbstractMap.SimpleEntry<>(edge.destination, newDistance));
                    }
                }
            }
        }

        return distances.get(end);
    }

    public static void main(String[] args) {
        DijkstraGraphTraversal graph = new DijkstraGraphTraversal();
        
        // Tambahkan node dan edge sesuai dengan graf Anda
        // Contoh: graph.addEdge("A", "B", 6);

        graph.addEdge("A", "B", 6);
        graph.addEdge("A", "D", 4);
        graph.addEdge("B", "C", 7);
        graph.addEdge("C", "E", 5);
        graph.addEdge("D", "E", 3);
        graph.addEdge("D", "B", 12);
        graph.addEdge("A", "E", 8);
        graph.addEdge("B", "E", 10);
        
        int distance = graph.dijkstra("A", "E");
        System.out.println("Jarak dari NodeAwal ke NodeAkhir adalah " + distance);
    }
}
