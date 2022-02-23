package Hashing;

import java.util.HashMap;
import java.util.Map;

public class SumOfElementsWithSameFreq {

    public static int getSum(int A, int B, int[] C) {
        int sum = 0;
        int mod = 1000000000 + 7;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i : C) {
            if(map.containsKey(i)) {
                map.put(i, map.get(i)+1);
            } else map.put(i,1);
        }

        for(int i : C) {
            if(map.containsKey(i))
                if(map.get(i) == B) {
                    sum = (sum + (i % mod));
                    map.remove(i);
                }
        }
        if(sum == 0) return -1;
        return sum%mod;
    }

    public static int solve(String A) {
        int[] freq = new int[26];
        for (int i = 0; i < A.length(); i++)
            freq[A.charAt(i) - 97]++;
        int odd = 0;
        for (int a: freq)
            if (a % 2 == 1)
                odd++;
        if (odd > 1)
            return 0;
        return 1;
    }

    public static void main(String[] args) {
        System.out.println(getSum(5,2,new int[]{1,2,2,3,3}));
        System.out.println(solve("aabb"));
    }
}
