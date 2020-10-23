
import java.util.Random;
import java.util.Scanner;

public class GuessWord {
    private  String[] words={"testing", "cat", "programming", "java"};
    private String res="";
    private int cnt=0;
    private int letters=0;

    private String getRes(String word){
        for (int i = 0; i < word.length(); i++) {
            res+="-";
            letters++;
        }
        return res;
    }
    public static String getRandomWord(String[] array) {
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }
    public void newGame(){
        String word=getRandomWord(words);
        res=getRes(word);
        Scanner s = new Scanner(System.in);
        System.out.println("You need to guess the word of "+ letters+" letters.");

        while (word.equals(res)==false) {

            System.out.print("Key in one character or your guess word: ");
            String str=s.nextLine();
            if(str.length()==0 || str.length()>1 && str.length()!=word.length()){
                System.out.println("enter a letter or the word of "+ letters+" letters.");
                continue;
            }
            cnt++;
             if (str.length()==word.length() && str.equals(word)) {
                System.out.println("Trial "+cnt+": "+word);
                break;
            }
            if (str.length()==word.length() && !str.equals(word)){
                System.out.println("the word is wrong! you lose!");
                break;
            }

            char a = str.charAt(0);
            for (int i = 0; i < word.length(); i++) {
                if (a == (word.charAt(i))) {
                    res = res.substring(0, i) + a + res.substring(i + 1);
                }
            }
            System.out.println("Trial "+cnt+": "+res);
            if(res.equals(word)) System.out.println("Congratulation!");
        }
        System.out.println("You got in " +cnt+" trials");
    }

    public static void main(String[] args) {
        GuessWord word= new GuessWord();
        word.newGame();
    }
}
