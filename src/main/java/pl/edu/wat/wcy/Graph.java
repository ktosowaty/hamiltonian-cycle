package pl.edu.wat.wcy;

public class Graph {

    private Vertex[] vertices;
    private int edgesNumber;

    public Graph(int verticesNumber, int edgesNumber) {
        initVertices(verticesNumber);
        this.edgesNumber = edgesNumber;
    }

    public void addEdge(int from, int to) {
        vertices[from].addAdjacent(vertices[to]);
    }

    public Vertex[] getVertices() {
        return vertices;
    }

    public int size() {
        return vertices.length;
    }

    public void print() {
        System.out.println("Vertices: " + vertices.length);
        System.out.println("Edges: " + edgesNumber);
        for (Vertex vertex : vertices) {
            System.out.print("Vertex " + vertex.getNumber() + " is connected to: " );
            for (Vertex adj : vertex.getAdjacent()) {
                System.out.print(adj.getNumber() + " ");
            }
            System.out.println();
        }
    }

    private void initVertices(int verticesNumber) {
        vertices = new Vertex[verticesNumber];
        for (int i = 0; i < verticesNumber; i++) {
            vertices[i] = new Vertex(i);
        }
    }

}
