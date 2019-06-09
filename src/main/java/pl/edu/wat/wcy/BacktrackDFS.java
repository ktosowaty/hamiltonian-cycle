package pl.edu.wat.wcy;

import java.util.Stack;

public class BacktrackDFS {

    private static boolean[] visited;
    private static Stack<Vertex> path;

    private BacktrackDFS() {}

    public static void findHamiltonianCycles(Graph graph) {
        visited = new boolean[graph.size()];
        path = new Stack<>();
        recursion(graph.getVertices()[0]);
    }

    private static void recursion(Vertex vertex) {
        path.push(vertex);
        if (path.size() < visited.length) {
            int vertexNumber = vertex.getNumber();
            visited[vertexNumber] = true;
            for (Vertex adj : vertex.getAdjacent()) {
                if (!visited[adj.getNumber()]) {
                    recursion(adj);
                }
            }
            visited[vertexNumber] = false;
        } else if (path.size() == visited.length) {
            for (Vertex adj : vertex.getAdjacent()) {
                if (adj.getNumber() == 0) {
                    path.forEach(vertex123 -> System.out.print(vertex123.getNumber() + " "));
                    System.out.println("0");
                    break;
                }
            }
        } else {
            throw new IllegalStateException("Path size is greater than graph size.");
        }
        path.pop();
    }

}
