package pl.edu.wat.wcy.reader;

import pl.edu.wat.wcy.graph.Graph;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class GraphReader {

    private GraphReader() {}

    public static Graph readGraph(Path path) throws IOException {
        Scanner scanner = new Scanner(path);
        Graph graph = new Graph(scanner.nextInt(), scanner.nextInt());
        while (scanner.hasNextLine()) {
            int from = scanner.nextInt();
            int to = scanner.nextInt();
            graph.addEdge(from, to);
            graph.addEdge(to, from);
        }
        return graph;
    }

    public static Graph readWeightedGraph(Path path) throws IOException {
        Scanner scanner = new Scanner(path);
        Graph graph = new Graph(scanner.nextInt(), scanner.nextInt());
        while (scanner.hasNextLine()) {
            int from = scanner.nextInt();
            int to = scanner.nextInt();
            int weight = scanner.nextInt();
            graph.addEdge(from, to, weight);
            graph.addEdge(to, from, weight);
        }
        return graph;
    }

}
