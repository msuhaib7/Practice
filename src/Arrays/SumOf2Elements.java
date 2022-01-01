package Arrays;

import java.util.*;

public class SumOf2Elements {

    public void findPair(int[] arr, int sum){
        List<Integer> l = new ArrayList<>();
        l.set(20,10);
    }

    public static void main(String[] args) {
        int i = 0;
        System.out.println(i^1);
    }


    public static int solve(int[] A, int B) {
        int[] preSum = new int[A.length];
        int[] sufSum = new int[A.length];
        int n = A.length;

        preSum[0] = A[0];
        sufSum[n-1] = A[n-1];
        for(int i=1, j=n-2; i< n;i++,j-- ){
            preSum[i] = preSum[i-1] + A[i];
            sufSum[j] = sufSum[j+1] + A[j];
        }

        int max = Integer.MIN_VALUE;

        for(int k=0; k<=B; k++){
            int sum = 0;
            if(k==0){
                sum = sufSum[n-B];
            }
            else if(k == B){
                sum = preSum[k-1];
            }
            else {
                    sum = preSum[k-1] + sufSum[n-(B-k)];
            }
            if(sum > max) max = sum;
        }
        return max;
    }



    public static ArrayList<ArrayList<Integer>> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        ArrayList<ArrayList<Integer>> li = new ArrayList<>();
        for(int v : B){
            int[] arr = A.stream().mapToInt(i->i).toArray();
            arr = reverse(arr,0,A.size()-1);
            arr = reverse(arr,A.size()-v,A.size()-1);
            arr = reverse(arr,0,A.size()-v-1);
            li.add(asList(arr));
        }
        return li;
    }
    public static int[] reverse(int[] arr, int from, int to){
        for(int i=from, j=to; i<= j; i++,j--){
            int t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
        }
        return arr;
    }

    public static ArrayList<Integer> asList(int[] arr){
        ArrayList<Integer> al = new ArrayList<>();
        for(int i : arr) {
            al.add(i);
        }
        return al;
    }
}
