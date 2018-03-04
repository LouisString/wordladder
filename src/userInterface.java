import java.io.*;
import java.util.*;

public class userInterface {
    public static void main(String []args) {
        boolean get_ans = false;
        boolean get_path = true;
        boolean want_more = true;
        String ans;
        String filePath;
        Map word_list = new HashMap();
        Scanner scanner;

        System.out.print("Default dictionary file is dictionary.txt." +
                "\nIf you want to change, please enter 'y';" +
                "\nElse, please enter 'n': ");
        while (!get_ans){
            scanner = new Scanner(System.in);
            ans = scanner.next();
            if (ans.equals("y")){
                get_ans = true;
                get_path = false;
            }
            else if (ans.equals("n") ){
                get_ans = true;
            }
            else{
                System.out.print("Unexpected answer. Type again: ");
            }
        }

        if (get_path){
            filePath = "dictionary.txt";
            readfile file = new readfile();
            word_list = file.readTxtFile(filePath);
        }
        else{
            System.out.print("Input the file name (with suffix): ");
            while (!get_path){
                scanner = new Scanner(System.in);
                filePath = scanner.next();
                readfile file = new readfile();
                word_list = file.readTxtFile(filePath);
                if (word_list.isEmpty()){
                    System.out.print("No such file or it contains no words. Try another one: ");
                }
                else{
                    get_path = true;
                }
            }
        }

        while (want_more){
            System.out.print("\nInput the first word: ");
            scanner = new Scanner(System.in);
            String word1 = scanner.nextLine();

            while (!word_list.containsKey(word1)){
                System.out.print("The word is not in the dictionary! Try another one: ");
                scanner = new Scanner(System.in);
                word1 = scanner.nextLine();
            }

            int len1 = word1.length();

            System.out.print("Input the second word: ");
            scanner = new Scanner(System.in);
            String word2 = scanner.nextLine();

            while ( len1 != word2.length()){
                System.out.print("Two words must be in same length! Input again please: ");
                scanner = new Scanner(System.in);
                word2 = scanner.nextLine();
            }

            while (!word_list.containsKey(word2)){
                System.out.print("The second word is not in the dictionary! Try another one: ");
                scanner = new Scanner(System.in);
                word2 = scanner.nextLine();
            }

            buildladder process = new buildladder();
            process.find_ladder(word1, word2, word_list);

            System.out.print("\n\nWant another try? Type 'y' or 'n': ");
            scanner = new Scanner(System.in);
            ans = scanner.nextLine();
            if (ans.equals("y")){
                continue;
            }
            else if (ans.equals("n") ){
                want_more = false;
            }
            else{
                System.out.print("Unexpected answer. Regard as 'n'.\n");
                want_more = false;
            }
        }
        System.out.print("\nThanks for using.");
    }


}
