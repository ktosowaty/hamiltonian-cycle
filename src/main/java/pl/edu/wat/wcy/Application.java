package pl.edu.wat.wcy;

import pl.edu.wat.wcy.algorithm.BacktrackDfsAlgorithm;
import pl.edu.wat.wcy.algorithm.NearestNeighborAlgorithm;
import pl.edu.wat.wcy.graph.Graph;
import pl.edu.wat.wcy.graph.HamiltonianCycle;
import pl.edu.wat.wcy.input.GraphGenerator;
import pl.edu.wat.wcy.input.GraphReader;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Application {

    public static void main(String[] args) throws IOException {
        Path path1 = Paths.get("src/main/resources/graph.txt").normalize().toAbsolutePath();
        Graph graph1 = GraphReader.readGraph(path1);
        graph1.print();
        BacktrackDfsAlgorithm backtrackDfsAlgorithm = new BacktrackDfsAlgorithm();
        HamiltonianCycle cycle1 = backtrackDfsAlgorithm.findBestHamiltonianCycle(graph1);
        cycle1.print();

        Path path2 = Paths.get("src/main/resources/weighted-graph.txt").normalize().toAbsolutePath();
        Graph weightedGraph1 = GraphReader.readWeightedGraph(path2);
        weightedGraph1.print();
        HamiltonianCycle cycle2 = backtrackDfsAlgorithm.findBestHamiltonianCycle(weightedGraph1);
        cycle2.print();
        NearestNeighborAlgorithm nearestNeighborAlgorithm = new NearestNeighborAlgorithm();
        HamiltonianCycle cycle3 = nearestNeighborAlgorithm.findBestHamiltonianCycle(weightedGraph1);
        cycle3.print();

        Graph graph2 = GraphGenerator.generateGraph(4);
        graph2.print();
        HamiltonianCycle cycle4 = backtrackDfsAlgorithm.findBestHamiltonianCycle(graph2);
        cycle4.print();

        Graph weightedGraph2 = GraphGenerator.generateWeightedGraph(4);
        weightedGraph2.print();
        HamiltonianCycle cycle5 = backtrackDfsAlgorithm.findBestHamiltonianCycle(weightedGraph2);
        cycle5.print();
        HamiltonianCycle cycle6 = nearestNeighborAlgorithm.findBestHamiltonianCycle(weightedGraph2);
        cycle6.print();

    }

}
