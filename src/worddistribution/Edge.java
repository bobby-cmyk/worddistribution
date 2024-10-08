package worddistribution;

public class Edge {

    private String fromNode;
    private String toNode;

    public Edge(String fromNode, String toNode) {
        this.fromNode = fromNode;
        this.toNode = toNode;
    } 

    public String getFromNode() {
        return this.fromNode;
    }

    public String getToNode() {
        return this.toNode;
    }
 }