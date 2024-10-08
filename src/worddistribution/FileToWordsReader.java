package worddistribution;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileToWordsReader  {
    
    private ArrayList<String> wordsList;

    public FileToWordsReader() {
        this.wordsList = new ArrayList<>();
    }

    public ArrayList<String> read(String textFilePath) throws FileNotFoundException, IOException{
        // Instantiate reader to read from text file path
        BufferedReader reader = new BufferedReader(new FileReader(textFilePath));
        
        // Read the text file line by line with the reader
        while (true) {
            String line = reader.readLine();
            // Stop reading at the end of the text file
            if (line == null) {
                break;
            } 
            else if (line.equals("")) {
                continue;
            }

            String transformedLine = line.replaceAll("[^a-zA-Z ]", "").toLowerCase().trim();

            String[] words = transformedLine.split("\\s+");

            for (String word : words) {
                this.wordsList.add(word);
            }
        }

        reader.close();

        return this.wordsList;
    }

}
