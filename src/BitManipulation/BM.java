package BitManipulation;

import java.util.ArrayList;
import java.util.List;

public class BM {
   static char[][] dic;
    static List<String> combinations;


    public static void main(String[] args) {
        System.out.println(letterCombinations("234"));
        System.out.println();
        System.out.println(-40%7);
        System.out.println(100%21);
        System.out.println(1000%21);
        System.out.println(10000%21);
    }

    public static List<String> letterCombinations(String digits) {
        dic = new char[][]{{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
        combinations = new ArrayList<>();
        int len = digits.length();
        if(len==0) return combinations;
        addCombinations(0,new char[len],len,digits);
        return combinations;

    }

    private static void addCombinations(int index, char[] sequence, int len, String digits){
        for(char c : sequence){
        }
        if(index == len)
            combinations.add(String.valueOf(sequence));
        else{
            for(char letter : dic[digits.charAt(index)-50]){
                char[] sequenceCopy = new char[len];
                for(int i =0; i < index; i++){
                    sequenceCopy[i] = sequence[i];
                }
                sequenceCopy[index] = letter;
                addCombinations(index+1, sequenceCopy,len,digits);
            }

        }
    }
}
