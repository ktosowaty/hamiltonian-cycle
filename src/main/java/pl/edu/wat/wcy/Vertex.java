package pl.edu.wat.wcy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Vertex {

    private int number;
    private List<Vertex> adjacent;

    public Vertex(int number) {
        this.number = number;
        this.adjacent = new ArrayList<>();
    }

    public int getNumber() {
        return number;
    }

    public List<Vertex> getAdjacent() {
        return Collections.unmodifiableList(adjacent);
    }

    public void addAdjacent(Vertex vertex) {
        adjacent.add(vertex);
    }

}
