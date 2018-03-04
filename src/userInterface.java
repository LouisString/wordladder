import java.io.*;
import java.util.*;

public class userInterface {
    public static void main(String []args) {
        String filePath = "E:\\课程相关文件\\Grade 2-2\\软工经济学\\java projects\\wordladder\\dictionary.txt";
//      "res/";
        readfile file = new readfile();
        List<String> word_list = file.readTxtFile(filePath);

        System.out.print("Input the first word: ");
        Scanner scan = new Scanner(System.in);
        String word1 = scan.nextLine();

        while (!word_list.contains(word1)){
            System.out.print("The word is not in the dictionary! Try another one: ");
            scan = new Scanner(System.in);
            word1 = scan.nextLine();
        }

        int len1 = word1.length();

        System.out.print("Input the second word: ");
        scan = new Scanner(System.in);
        String word2 = scan.nextLine();

        while ( len1 != word2.length()){
            System.out.print("Two words must be in same length! Input again please: ");
            scan = new Scanner(System.in);
            word2 = scan.nextLine();
        }

        while (!word_list.contains(word2)){
            System.out.print("The second word is not in the dictionary! Try another one: ");
            scan = new Scanner(System.in);
            word2 = scan.nextLine();
        }

        buildladder process = new buildladder();
        process.find_ladder(word1, word2, word_list);
    }
}
