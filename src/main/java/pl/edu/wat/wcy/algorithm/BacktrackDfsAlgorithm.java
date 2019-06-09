package pl.edu.wat.wcy.algorithm;

import pl.edu.wat.wcy.graph.Graph;
import pl.edu.wat.wcy.graph.HamiltonianCycle;
import pl.edu.wat.wcy.graph.Vertex;
import pl.edu.wat.wcy.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BacktrackDfsAlgorithm {

    private static final int START_VERTEX_NUMBER = 0;

    private boolean[] visited;
    private Stack<Vertex> path;
    private HamiltonianCycle bestHamiltonianCycle;
    private int currentCost;

    public BacktrackDfsAlgorithm() {}

    public HamiltonianCycle findBestHamiltonianCycle(Graph graph) {
        setup(graph);
        moveToVertex(graph.getVertices().get(START_VERTEX_NUMBER));
        return bestHamiltonianCycle;
    }

    private void setup(Graph graph) {
        visited = new boolean[graph.size()];
        path = new Stack<>();
        bestHamiltonianCycle = null;
        currentCost = 0;
    }

    private void moveToVertex(Vertex vertex) {
        path.push(vertex);
        if (path.size() < visited.length) {
            int vertexNumber = vertex.getNumber();
            visited[vertexNumber] = true;
            for (Pair<Vertex, Integer> adj : vertex.getAdjacent()) {
                moveToAdjacent(adj);
            }
            visited[vertexNumber] = false;
        } else if (visitedAllVertices()) {
            Pair<Vertex, Integer> toStart = findStartVertex(vertex);
            if (toStart != null) {
                updateBestCycle(toStart);
            }
        } else {
            throw new IllegalStateException("Path size is greater than graph size.");
        }
        path.pop();
    }

    private void moveToAdjacent(Pair<Vertex, Integer> adj) {
        Vertex vertex = adj.getFirst();
        int weight = adj.getSecond();
        if (!visited[vertex.getNumber()]) {
            currentCost += weight;
            moveToVertex(vertex);
            currentCost -= weight;
        }
    }

    private boolean visitedAllVertices() {
        return path.size() == visited.length;
    }

    private Pair<Vertex, Integer> findStartVertex(Vertex vertex) {
        for (Pair<Vertex, Integer> adj : vertex.getAdjacent()) {
            if (adj.getFirst().getNumber() == START_VERTEX_NUMBER) {
                return adj;
            }
        }
        return null;
    }

    private void updateBestCycle(Pair<Vertex, Integer> toStart) {
        HamiltonianCycle hamiltonianCycle = createHamiltonianCycle(toStart);
        if (hamiltonianCycle.hasLowerCost(bestHamiltonianCycle)) {
            bestHamiltonianCycle = hamiltonianCycle;
        }
    }

    private HamiltonianCycle createHamiltonianCycle(Pair<Vertex, Integer> pair) {
        Vertex vertex = pair.getFirst();
        int weight = pair.getSecond();
        List<Vertex> vertices = new ArrayList<>(path);
        vertices.add(vertex);
        int totalCost = currentCost + weight;
        return new HamiltonianCycle(vertices, totalCost);
    }

}
