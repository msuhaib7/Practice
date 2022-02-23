package Hashing;

import java.util.HashMap;
import java.util.Map;

public class MaxSubArrayWithSumZero {
    public  static int[] lszero(int[] A) {

        int[] prefixSum = new int[A.length];

        prefixSum[0] = A[0];
            for(int i=1; i < A.length; i++) {
            prefixSum[i] = prefixSum[i-1] + A[i];
        }

        int i=0,j=0;
        Map<Integer,Integer> map = new HashMap<>();

            for(int k=0; k < prefixSum.length;k++) {
                if(prefixSum[k] == 0){
                    i = -1;
                    j = k;
                    break;
                }
            if(map.containsKey(prefixSum[k])) {
                if((j - i) < (k - map.get(prefixSum[k]))) {
                    j = k;
                    i = map.get(prefixSum[k]);
                } else if((j - i) == (k - map.get(prefixSum[k])) && i > map.get(prefixSum[k])) {
                    j = k;
                    i = map.get(prefixSum[k]);
                }
            }  else {
                map.put(prefixSum[k],k);
            }
        }
        i = i+1;
        int[] ans = new int[j-i+1];
        int s=0;
            for(int k=i; k <= j; k++) {
            ans[s] = A[k];
            s++;
        }
            return ans;
}

    public static void main(String[] args) {
        System.out.println(lszero(new int[] {1, 2, -2, 4, -4 }));
        System.out.println(lszero(new int[] {1, 2, -3, 3 }));

    }
}
