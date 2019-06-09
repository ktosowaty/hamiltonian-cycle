package pl.edu.wat.wcy.algorithm;

import pl.edu.wat.wcy.graph.Graph;
import pl.edu.wat.wcy.graph.HamiltonianCycle;
import pl.edu.wat.wcy.graph.Vertex;
import pl.edu.wat.wcy.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class NearestNeighborAlgorithm {

    private static final int INF = Integer.MAX_VALUE;
    private static final int START_VERTEX_NUMBER = 0;

    private boolean[] visited;
    private List<Vertex> path = new ArrayList<>();
    private int visitedVertices = 0;
    private int totalCost = 0;
    private Vertex nextVertex;

    public NearestNeighborAlgorithm() {}

    public HamiltonianCycle findBestHamiltonianCycle(Graph graph) {
        visited = new boolean[graph.size()];
        nextVertex = graph.getVertices().get(START_VERTEX_NUMBER);
        while (visitedVertices < graph.size()) {
            visitVertex(nextVertex);
            visitedVertices++;
        }
        return new HamiltonianCycle(path, totalCost);
    }

    private void visitVertex(Vertex vertex) {
        path.add(vertex);
        visited[vertex.getNumber()] = true;
        int bestWeight = INF;
        for (Pair<Vertex, Integer> adj : vertex.getAdjacent()) {
            Vertex adjVertex = adj.getFirst();
            int weight = adj.getSecond();
            if (!visited[adjVertex.getNumber()] && weight < bestWeight) {
                nextVertex = adjVertex;
                bestWeight = weight;
            }
        }
        if (bestWeight != INF) {
            totalCost += bestWeight;
        } else {
            Pair<Vertex, Integer> toStart = findStartVertex();
            if (toStart != null) {
                closeCycle(toStart);
            }
        }
    }

    private Pair<Vertex, Integer> findStartVertex() {
        for (Pair<Vertex, Integer> adj : nextVertex.getAdjacent()) {
            if (adj.getFirst().getNumber() == START_VERTEX_NUMBER) {
                return adj;
            }
        }
        return null;
    }

    private void closeCycle(Pair<Vertex, Integer> adj) {
        Vertex adjVertex = adj.getFirst();
        int weight = adj.getSecond();
        path.add(adjVertex);
        totalCost += weight;
    }

}
