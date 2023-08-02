package implementations;

import java.util.*;

class Vertex {
    int name;
    double distance;

    public Vertex(int name, double distance) {
        this.name = name;
        this.distance = distance;
    }
}

public class Dijkstra {
    public static Map<Integer, Double> dijkstra(Map<Integer, Map<Integer, Double>> graph, int startVertex) {
        Map<Integer, Double> distances = new HashMap<>();
        PriorityQueue<Vertex> priorityQueue = new PriorityQueue<>(Comparator.comparingDouble(v -> v.distance));

        // Khởi tạo khoảng cách tạm thời và đặt khoảng cách ban đầu từ đỉnh xuất phát là 0
        for (int vertex : graph.keySet()) {
            distances.put(vertex, Double.POSITIVE_INFINITY);
        }
        distances.put(startVertex, 0.0);
        priorityQueue.add(new Vertex(startVertex, 0.0));

        while (!priorityQueue.isEmpty()) {
            Vertex currentVertex = priorityQueue.poll();
            int currentName = currentVertex.name;
            double currentDistance = currentVertex.distance;

            // Kiểm tra các đỉnh kề của đỉnh hiện tại
            for (Map.Entry<Integer, Double> neighbor : graph.get(currentName).entrySet()) {
                int neighborName = neighbor.getKey();
                double weight = neighbor.getValue();
                double distance = currentDistance + weight;

                // Nếu khoảng cách tạm thời từ đỉnh xuất phát tới neighbor nhỏ hơn
                // khoảng cách tạm thời hiện tại, cập nhật lại khoảng cách và đỉnh trước đó
                if (distance < distances.get(neighborName)) {
                    distances.put(neighborName, distance);
                    priorityQueue.add(new Vertex(neighborName, distance));
                }
            }
        }

        return distances;
    }

    public static void main(String[] args) {
        // Ví dụ về đồ thị có trọng số không âm
        Map<Integer, Map<Integer, Double>> graph = new HashMap<>();
        graph.put(0, Map.of(1, 2.5, 2, 2.0, 3, 2.1));
        graph.put(1, Map.of(4, 1.0));
        graph.put(2, Map.of(5, 1.5, 4, 0.6));
        graph.put(3, Map.of(5, 2.5));
        graph.put(4, Map.of(6, 2.3));
        graph.put(5, Map.of(6, 1.9, 7, 2.0));
        graph.put(6, Map.of(5, 1.9, 7, 1.8, 8, 1.7));
        graph.put(7, Map.of(8, 2.0));

        // Đỉnh xuất phát là 0
        int startVertex = 0;
        Map<Integer, Double> shortestDistances = dijkstra(graph, startVertex);

        System.out.println("Đỉnh xuất phát: " + startVertex);
        for (Map.Entry<Integer, Double> entry : shortestDistances.entrySet()) {
            System.out.println("Khoảng cách từ " + startVertex + " đến " + entry.getKey() + " là " + entry.getValue());
        }
    }
}

