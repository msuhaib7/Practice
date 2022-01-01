package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CarryForward {

    public static  int bulbs(int[] A) {

        int count = 0;
        boolean swtch = false;
        for(int i=0; i<= A.length -1; i++){
            if(A[i] == 0){
                count++;

                for(int j=i+1; j <= A.length -1; j++){
                    A[j] = A[j] ^ 1;
                }
                printArray(A,i+1);
            }
        }
        return count;
    }

    public static void printArray(int[] ar,int s){
        System.out.print("[ ");
        for (int i = s; i < ar.length;i++) {
            System.out.print(ar[i] + ", ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {

        System.out.println(searchSuggestions(Arrays.asList(new String[]{"bags","baggage","banner","box","cloths"}),"bags"));
    }

    public static String solve(int[] A) {
        int len = A.length;
        //System.out.println("len == "+len);
        if(len % 2 == 1) return "NO";

        if(A[0] % 2 == 1 || A[len-1]%2 == 1) return "NO";

        for(int i = len - 2; i>0; i--){
            if(A[i] % 2 == 0) {
                //  System.out.println(len +" - "+i+" = "+(len-1));
                if((len-i)%2 == 0 && A[i-1]%2 == 0) return "YES";
            }
        }
        return "NO";
    }

    public static List<List<String>> searchSuggestions(List<String> repository, String customerQuery) {
        // Write your code here
        List<List<String>> ans = new ArrayList<>();

        Collections.sort(repository);
        if(customerQuery.length() < 2) return ans;
        int idx = 0;
        int len = customerQuery.length();
        for(int i=2; i<= len; i++) {
            List<String> queries = new ArrayList<>();
            for(; idx < repository.size();){
                if (repository.get(idx).toLowerCase().startsWith(customerQuery.substring(0,i).toLowerCase())){
                    if(queries.size() == 3) break;
                    queries.add(repository.get(idx).toLowerCase());
                    idx++;
                } else {
                    idx++;
                }
                ans.add(queries);
            }
        }
        return ans;
    }
}
