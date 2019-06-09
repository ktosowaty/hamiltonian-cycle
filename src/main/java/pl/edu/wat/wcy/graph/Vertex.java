package pl.edu.wat.wcy.graph;

import pl.edu.wat.wcy.util.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Vertex {

    private int number;
    private List<Pair<Vertex, Integer>> adjacent;

    public Vertex(int number) {
        this.number = number;
        this.adjacent = new ArrayList<>();
    }

    public int getNumber() {
        return number;
    }

    public List<Pair<Vertex, Integer>> getAdjacent() {
        return Collections.unmodifiableList(adjacent);
    }

    public void addAdjacent(Vertex vertex) {
        addAdjacent(vertex, 1);
    }

    public void addAdjacent(Vertex vertex, int weight) {
        Pair<Vertex, Integer> pair = new Pair<>(vertex, weight);
        adjacent.add(pair);
    }

}
