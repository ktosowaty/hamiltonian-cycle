package pl.edu.wat.wcy;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class GraphReader {

    private GraphReader() {}

    public static Graph readFromFile(Path path) throws IOException {
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

}
