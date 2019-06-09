package pl.edu.wat.wcy.graph;

import pl.edu.wat.wcy.util.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Graph {

    private List<Vertex> vertices;
    private int edgesNumber;

    public Graph(int verticesNumber, int edgesNumber) {
        initVertices(verticesNumber);
        this.edgesNumber = edgesNumber;
    }

    public void addEdge(int from, int to) {
        addEdge(from, to, 1);
    }

    public void addEdge(int from, int to, int weight) {
        vertices.get(from).addAdjacent(vertices.get(to), weight);
    }

    public List<Vertex> getVertices() {
        return Collections.unmodifiableList(vertices);
    }

    public int size() {
        return vertices.size();
    }

    public void print() {
        System.out.println("Vertices: " + vertices.size());
        System.out.println("Edges: " + edgesNumber);
        for (Vertex vertex : vertices) {
            System.out.print("Vertex " + vertex.getNumber() + " is connected to: " );
            for (Pair<Vertex, Integer> adj : vertex.getAdjacent()) {
                int adjNumber = adj.getFirst().getNumber();
                int weight = adj.getSecond();
                System.out.print(adjNumber + " (" + weight + "), ");
            }
            System.out.println();
        }
    }

    private void initVertices(int verticesNumber) {
        vertices = new ArrayList<>();
        for (int i = 0; i < verticesNumber; i++) {
            Vertex vertex = new Vertex(i);
            vertices.add(vertex);
        }
    }

}
