package worddistribution;

public class WordProbability {
    
    private String word;
    private int count;

    public WordProbability(String word, int count) {
        this.word = word;
        this.count = count;
    }

    public String getWord() {
        return this.word;
    }

    public double getcount() {
        return this.count;
    }

    public void setCount() {
        this.count++;
    }
}
