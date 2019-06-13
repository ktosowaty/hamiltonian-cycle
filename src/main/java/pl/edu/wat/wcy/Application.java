package pl.edu.wat.wcy;

import pl.edu.wat.wcy.algorithm.BacktrackDfsAlgorithm;
import pl.edu.wat.wcy.algorithm.NearestNeighborAlgorithm;
import pl.edu.wat.wcy.graph.Graph;
import pl.edu.wat.wcy.graph.HamiltonianCycle;
import pl.edu.wat.wcy.input.GraphGenerator;

import java.io.FileWriter;
import java.io.IOException;

public class Application {

    private static final int ATTEMPTS = 10;

    public static void main(String[] args) throws IOException {
        BacktrackDfsAlgorithm backtrackDfsAlgorithm = new BacktrackDfsAlgorithm();
        NearestNeighborAlgorithm nearestNeighborAlgorithm = new NearestNeighborAlgorithm();

        Graph g = GraphGenerator.generateWeightedGraph(4);
        nearestNeighborAlgorithm.findBestHamiltonianCycle(g);

        FileWriter csvWriter = new FileWriter("new.csv");
        csvWriter.append("GraphSize");
        csvWriter.append(",");
        csvWriter.append("BruteTime");
        csvWriter.append(",");
        csvWriter.append("HeuristicTime");
//        csvWriter.append(",");
//        csvWriter.append("AvgDiff");
//        csvWriter.append(",");
//        csvWriter.append("AvgPercentDiff");
        csvWriter.append("\n");

        for (int i = 4; i <= 12; i++) {
            System.out.println("GRAPH SIZE: " + i);
            long bruteAvg = 0;
            long heuristicAvg = 0;
//            double avgDiff = 0;
//            double avgPercentDiff = 0;
            for (int j = 1; j <= ATTEMPTS; j++) {
                Graph graph = GraphGenerator.generateWeightedGraph(i);
                long bruteStart = System.nanoTime();
                HamiltonianCycle cycle1 = backtrackDfsAlgorithm.findBestHamiltonianCycle(graph);
                long bruteFinish = System.nanoTime();
                long bruteTime = bruteFinish - bruteStart;
                long heuristicStart = System.nanoTime();
                HamiltonianCycle cycle2 = nearestNeighborAlgorithm.findBestHamiltonianCycle(graph);
                long heuristicFinish = System.nanoTime();
                long heuristicTime = heuristicFinish - heuristicStart;
                bruteAvg += bruteTime;
                heuristicAvg += heuristicTime;
                cycle1.print();
                cycle2.print();
//                avgDiff += cycle2.getCost() - cycle1.getCost();
//                avgPercentDiff = ((double) cycle2.getCost() / cycle1.getCost()) - 1.0;
            }
            bruteAvg /= ATTEMPTS;
            heuristicAvg /= ATTEMPTS;
//            avgPercentDiff /= ATTEMPTS;
            csvWriter.append(Integer.toString(i)).append(",");
            csvWriter.append(Long.toString(bruteAvg)).append(",");
            csvWriter.append(Long.toString(heuristicAvg));
//            csvWriter.append(Double.toString(avgDiff)).append(",");
//            csvWriter.append(Double.toString(avgPercentDiff)).append(",");
            csvWriter.append("\n");
        }

        csvWriter.flush();
        csvWriter.close();

    }

}
