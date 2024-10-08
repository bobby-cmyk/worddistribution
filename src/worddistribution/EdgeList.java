package worddistribution;

import java.util.ArrayList;

public class EdgeList {
    private ArrayList<Edge> edges;

    public EdgeList(ArrayList<String> words) {

        this.edges = new ArrayList<>();

        for (int i = 0; i < words.size() - 1; i++) {
            Edge edge = new Edge(words.get(i), words.get(i+1));
            edges.add(edge);
        }
    }

    @Override
    public String toString() {
        return "Number of edges: " + edges.size();
    }


}
