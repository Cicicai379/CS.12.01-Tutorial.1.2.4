import org.junit.platform.commons.util.StringUtils;

import static java.util.Collections.max;

public class WordMatch {
    String word;

    public WordMatch(String s){
        this.word = s;
    }
    public int scoreGuess(String guess)
    {
        if(guess.equals("")){
            throw new IllegalArgumentException("Your guess cannot be an empty String!");
        }
        if(guess.length()>word.length()){
            throw new IllegalArgumentException("Your guess cannot exceed the number of characters in the Secret word");
        }
        int count = 0;
        for(int i = 0; i < word.length(); i++)
        {
            int j = i + guess.length();
            if(j <= word.length() && word.substring(i, j).equals(guess)) count++;
        }

        return count * (guess.length() * guess.length());
    }


    public String findBetterGuess(String a, String b){
        if(scoreGuess(a)!= scoreGuess(b)){
            if(scoreGuess(a)> scoreGuess(b)){
                return a;
            }else{
                return b;
            }
        }
        else{
            if(a.compareTo(b)>0){
                return a;
            }else{
                return b;
            }

        }
    }
}
