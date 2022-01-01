package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubArrays {
    public static int solve(int[] A, int B) {
        int sum = 0;

        for(int i=0; i < B;i++){
            sum = sum + A[i];
        }
        int minSum = sum;
      //  if(sum % B == 0) return 0;
        int idx = 0;
        int start = 1;
        int end = B;


        for(; end  < A.length; start++,end++) {
            sum = sum - A[start-1] + A[end];
            if(minSum > sum) {
                minSum = sum;
                idx = start;
            }
        }
        return idx;
    }

    public static int maxSubArray(final int[] A) {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;

        for(int i=0; i < A.length; i++) {
            sum = sum + A[i];

            if(maxSum < sum) maxSum = sum;
            if(sum < 0) sum = 0;
        }
        return maxSum;
    }
    public static int[] alternateSubArray(int[] A, int B) {
        //if(B == 0) return A.length;
        int n = A.length;
        List<Integer> list = new ArrayList<>();
        int l = 2*B +1;

        for(int i=0; i < n -1;) {
            int start = A[i];
            int end = i+l-1;
            boolean flag = true;
            int j = i+1;
            for( ; j < end; j++) {
                int next = 1 - start;
                if(A[j] != next) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                list.add((i+j)/2);
                i = j;
            } else i++;
        }

        int ans[] = {};
        if(list.size() > 0) ans = new int[list.size()];
        for(int i=0; i< list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
//        System.out.println(solve(new int[]{18, 11, 16, 19, 11, 9, 8, 15, 3, 10, 9, 20, 1, 19},6));
//        System.out.println(maxSubArray(new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4 }));
        Arrays.stream(alternateSubArray(new int[]{0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 1}, 1)).forEach(x -> System.out.println(x));
    }


}
