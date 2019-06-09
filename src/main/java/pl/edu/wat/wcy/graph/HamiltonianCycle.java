package pl.edu.wat.wcy.graph;

import java.util.Collections;
import java.util.List;

public class HamiltonianCycle {

    private List<Vertex> vertices;
    private int cost;

    public HamiltonianCycle(List<Vertex> vertices, int cost) {
        this.vertices = vertices;
        this.cost = cost;
    }

    public void print() {
        System.out.println("Total cost: " + cost);
        for (int i = 0; i < vertices.size() - 1; i++) {
            System.out.print(vertices.get(i).getNumber() + " -> ");
        }
        System.out.println(vertices.get(vertices.size() - 1).getNumber());
    }

    public List<Vertex> getVertices() {
        return Collections.unmodifiableList(vertices);
    }

    public int getCost() {
        return cost;
    }

    public boolean hasLowerCost(HamiltonianCycle other) {
        return other == null || cost < other.cost;
    }

}
