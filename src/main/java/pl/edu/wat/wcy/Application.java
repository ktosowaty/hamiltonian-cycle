package pl.edu.wat.wcy;

import pl.edu.wat.wcy.algorithm.BacktrackDfsAlgorithm;
import pl.edu.wat.wcy.algorithm.NearestNeighborAlgorithm;
import pl.edu.wat.wcy.graph.Graph;
import pl.edu.wat.wcy.graph.HamiltonianCycle;
import pl.edu.wat.wcy.reader.GraphReader;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Application {

    public static void main(String[] args) throws IOException {
        Path path1 = Paths.get("src/main/resources/graph.txt").normalize().toAbsolutePath();
        Graph graph = GraphReader.readGraph(path1);
        graph.print();
        BacktrackDfsAlgorithm backtrackDfsAlgorithm = new BacktrackDfsAlgorithm();
        HamiltonianCycle cycle1 = backtrackDfsAlgorithm.findBestHamiltonianCycle(graph);
        cycle1.print();

        Path path2 = Paths.get("src/main/resources/weighted-graph.txt").normalize().toAbsolutePath();
        Graph weightedGraph = GraphReader.readWeightedGraph(path2);
        weightedGraph.print();
        HamiltonianCycle cycle2 = backtrackDfsAlgorithm.findBestHamiltonianCycle(weightedGraph);
        cycle2.print();
        NearestNeighborAlgorithm nearestNeighborAlgorithm = new NearestNeighborAlgorithm();
        HamiltonianCycle cycle3 = nearestNeighborAlgorithm.findBestHamiltonianCycle(weightedGraph);
        cycle3.print();
    }

}
