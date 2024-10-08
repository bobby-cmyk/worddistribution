package worddistribution;


import java.io.Console;
import java.io.FileNotFoundException;
import java.io.IOException;


// Consider using an edge list for this

public class Main{

    public static void main(String[] args) throws FileNotFoundException, IOException {

        // Get textfilepath from command line argument
        String textFilePath = args[0];

        FileToWordsReader reader = new FileToWordsReader();
        
        EdgeList edges = new EdgeList();

        edges.addEdges(reader.read(textFilePath));

        Predictor predictor = new Predictor(edges.calculateNextWordDistribution());
        
        Console cons = System.console();
        
        while (true) {
            System.out.print("Provide a starting word: ");
            String startingWord = cons.readLine().toLowerCase();

            if (startingWord.equals("end")) {
                break;
            }

            System.out.print("Length of sentence: ");
            int lengthOfSentence = Integer.parseInt(cons.readLine());

            System.out.println(predictor.predictSentence(startingWord, lengthOfSentence));

        }
    }

}


