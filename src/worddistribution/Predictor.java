package worddistribution;

import java.util.HashMap;
import java.util.Map;

public class Predictor {

    private HashMap<String, HashMap<String, Integer>> predictor;

    public Predictor(EdgeList edgeList) {

        // Instantiate empty map
        predictor = new HashMap<>();

        // If the fromNode is not in the keys yet, add into the keys, and add the count = 1

        for (Edge edge : edgeList) {
            String fromNode = edge.getFromNode();
            String toNode = edge.getToNode();

            if (predictor.containsKey(fromNode)) {
                if (predictor.get(fromNode).containsKey(toNode)) {
                    predictor.get(fromNode).put(toNode, predictor.get(fromNode).get(toNode) + 1);
                }
                else {
                    predictor.get(fromNode).put(toNode, 1);
                }
            }

            else {
                predictor.put(fromNode, new HashMap<>());
                predictor.get(fromNode).put(toNode, 1);
            }
            
        }
    
    }

    public void printNextWordProbabilities(String word) {
        HashMap<String, Integer> wordProbabilites = this.predictor.get(word);
        for (String nextWord : wordProbabilites.keySet()) {
            System.out.printf("Word: %s, Count: %d \n", nextWord, wordProbabilites.get(nextWord));
        }
    }
}

