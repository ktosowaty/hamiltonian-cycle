package pl.edu.wat.wcy;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Application {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("src/main/resources/graph.txt").normalize().toAbsolutePath();
        Graph graph = GraphReader.readFromFile(path);
        graph.print();
        BacktrackDFS.findHamiltonianCycles(graph);
    }

}
