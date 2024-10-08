package worddistribution;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class Predictor {

    private HashMap<String, HashMap<String, Integer>> wordDistribution;

    public Predictor(HashMap<String, HashMap<String, Integer>> wordDistribution) {
        this.wordDistribution = wordDistribution;
    }

    
    public void printNextWordDistribution(String word) {
        HashMap<String, Integer> nextWords = this.wordDistribution.get(word);
        for (String nextWord : nextWords.keySet()) {
            System.out.printf("Word: %s, Count: %d \n", nextWord, nextWords.get(nextWord));
        }
    }

    public String predictNextWord(String word) {

        HashMap<String, Integer> nextWords = new HashMap<>();

        if (this.wordDistribution.containsKey(word)) {
            nextWords = this.wordDistribution.get(word);
        }

        else {
            List<String> keys = new ArrayList<>(wordDistribution.keySet());
            Random rand = new Random();
            int randomIndex = rand.nextInt(keys.size());
            String randomKey = keys.get(randomIndex);
            nextWords = this.wordDistribution.get(randomKey);
        }
        
        // String nextBestWord = Collections.max(nextWords.entrySet(), Map.Entry.comparingByValue()).getKey();

        List<String> nextBestWords = nextWords.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).limit(5).map(Map.Entry::getKey).collect(Collectors.toList());
        
        // 
        Random rand = new Random();

        int randomIndex = rand.nextInt(5);

        String nextBestWord = "";

        if (nextBestWords.size() < 5) {
            nextBestWord = nextBestWords.get(0);
        } 

        else {
            nextBestWord = nextBestWords.get(randomIndex);
        }
        
        return nextBestWord;
    }

    public String predictSentence(String startingWord, int lengthOfSentence) {
        
        String sentence = startingWord;
        String priorWord = startingWord;

        for (int i = 0; i < lengthOfSentence; i++) {
            String nextWord = this.predictNextWord(priorWord);
            sentence += " " + nextWord;
            priorWord = nextWord;
        }

        return sentence;
    }
}

