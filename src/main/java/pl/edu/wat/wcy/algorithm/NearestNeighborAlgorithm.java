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
    private Vertex currentVertex;

    public NearestNeighborAlgorithm() {}

    public HamiltonianCycle findBestHamiltonianCycle(Graph graph) {
        setup(graph);
        while (visitedVertices < graph.size()) {
            visitCurrentVertex();
            visitedVertices++;
        }
        return new HamiltonianCycle(path, totalCost);
    }

    private void setup(Graph graph) {
        visitedVertices = 0;
        totalCost = 0;
        visited = new boolean[graph.size()];
        path = new ArrayList<>(graph.size());
        currentVertex = graph.getVertices().get(START_VERTEX_NUMBER);
    }

    private void visitCurrentVertex() {
        path.add(currentVertex);
        visited[currentVertex.getNumber()] = true;
        int bestWeight = INF;
        Vertex nexVertex = null;
        for (Pair<Vertex, Integer> adj : currentVertex.getAdjacent()) {
            Vertex adjVertex = adj.getFirst();
            int weight = adj.getSecond();
            if (!visited[adjVertex.getNumber()] && weight < bestWeight) {
                nexVertex = adjVertex;
                bestWeight = weight;
            }
        }
        if (bestWeight != INF) {
            totalCost += bestWeight;
            currentVertex = nexVertex;
        } else {
            Pair<Vertex, Integer> toStart = findStartVertex();
            if (toStart != null) {
                closeCycle(toStart);
            }
        }
    }

    private Pair<Vertex, Integer> findStartVertex() {
        for (Pair<Vertex, Integer> adj : currentVertex.getAdjacent()) {
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
