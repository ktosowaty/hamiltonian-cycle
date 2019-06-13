package pl.edu.wat.wcy.input;

import pl.edu.wat.wcy.graph.Graph;

import java.util.concurrent.ThreadLocalRandom;

public class GraphGenerator {

    private GraphGenerator() {}

    public static Graph generateGraph(int vertices) {
        int edges = vertices * (vertices - 1) / 2;
        Graph graph = new Graph(vertices, edges);
        for (int i = 0; i < vertices; i++) {
            for (int j = i + 1; j < vertices; j++) {
                graph.addEdge(i, j);
                graph.addEdge(j, i);
            }
        }
        return graph;
    }

    public static Graph generateWeightedGraph(int vertices) {
        int edges = vertices * (vertices - 1) / 2;
        Graph graph = new Graph(vertices, edges);
        for (int i = 0; i < vertices; i++) {
            for (int j = i + 1; j < vertices; j++) {
                int weight = ThreadLocalRandom.current().nextInt(1, 101);
                graph.addEdge(i, j, weight);
                graph.addEdge(j, i, weight);
            }
        }
        return graph;
    }

}
