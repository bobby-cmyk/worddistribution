package worddistribution;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

// Consider using an edge list for this

public class Main{

    public static void main(String[] args) throws FileNotFoundException, IOException {

        // Get textfilepath from command line argument
        String textFilePath = args[0];

        // Instantiate reader to read from text file path
        BufferedReader reader = new BufferedReader(new FileReader(textFilePath));

        // Instantiate a graph object

        ArrayList<String> chapterHeaders = new ArrayList<String>(
            Arrays.asList(
            "THE PREFACE",
            "CHAPTER I.",
            "CHAPTER II.",
            "CHAPTER III.",
            "CHAPTER IV.",
            "CHAPTER V.",
            "CHAPTER VI.",
            "CHAPTER VII.",
            "CHAPTER VIII.",
            "CHAPTER IX.",
            "CHAPTER X.",
            "CHAPTER XI.",
            "CHAPTER XII.",
            "CHAPTER XIII.",
            "CHAPTER XIV.",
            "CHAPTER XV.",
            "CHAPTER XVI.",
            "CHAPTER XVII.",
            "CHAPTER XVIII.",
            "CHAPTER XIX.",
            "CHAPTER XX."));

        ArrayList<String> allWords = new ArrayList<>();
        
        // Read the text file line by line with the reader
        while (true) {
            String line = reader.readLine();
            // Stop reading at the end of the text file
            if (line == null) {
                break;
            } 
            else if (chapterHeaders.contains(line)) {
                continue;
            }
            else if (line.equals("")) {
                continue;
            }

            String transformedLine = line.replaceAll("[^a-zA-Z ]", "").toLowerCase().trim();

            String[] words = transformedLine.split("\\s+");

            for (String word : words) {
                allWords.add(word);
            }
        }

        reader.close();

        EdgeList edges = new EdgeList(allWords);

        Predictor predictor = new Predictor(edges);

        predictor.printNextWordProbabilities("that");
    }


}


