package worddistribution;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashMap;

public class EdgeList implements Iterable<Edge>{
    private ArrayList<Edge> edges;

    public EdgeList() {
        this.edges = new ArrayList<>();
    }

    public void addEdges(ArrayList<String> wordsList) {
        for (int i = 0; i < wordsList.size() - 1; i++) {
            Edge edge = new Edge(wordsList.get(i), wordsList.get(i+1));
            edges.add(edge);
        }
    }

    public HashMap<String, HashMap<String, Integer>> calculateNextWordDistribution() {
                // Instantiate empty map
        HashMap<String, HashMap<String, Integer>>  wordDistribution = new HashMap<>();

        // If the fromNode is not in the keys yet, add into the keys, and add the count = 1

        for (Edge edge : this.edges) {
            String fromNode = edge.getFromNode();
            String toNode = edge.getToNode();

            if (wordDistribution.containsKey(fromNode)) {
                if (wordDistribution.get(fromNode).containsKey(toNode)) {
                    wordDistribution.get(fromNode).put(toNode, wordDistribution.get(fromNode).get(toNode) + 1);
                }
                else {
                    wordDistribution.get(fromNode).put(toNode, 1);
                }
            }

            else {
                wordDistribution.put(fromNode, new HashMap<>());
                wordDistribution.get(fromNode).put(toNode, 1);
            }
            
        }

        return wordDistribution;
    }

    @Override
    public String toString() {
        return "Number of edges: " + edges.size();
    }

    @Override
    public Iterator<Edge> iterator() {
        return edges.iterator(); // Use the iterator of ArrayList
    }
}
