import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public int solve(int A) {
        return  squareRoot(A,1,A);
    }
    public int squareRoot(int num, int left, int right) {
        if(left <= right){
            int mid = (left+right)/2;
            int multiple = (int)mid*(int)mid;
            if(multiple == num) return mid;
            if(multiple > num || multiple < 0) right = mid-1;
            else if(multiple < num) left = mid+1;
            return squareRoot(num,left,right);
        }
        return -1;
    }
    //[1,2,3,-7,6]
    public static int maxSubArray(int[] nums) {
        if(nums.length == 1) return nums[0];
        int sum = nums[0];
        int currSum = nums[0];
        for(int i=1; i< nums.length; i++)  {
            if(currSum < 0) {
                currSum = currSum > nums[i] ? currSum : nums[i];
            }
            else {
                currSum += nums[i];
            }
            if(currSum > sum) {
                sum = currSum;
            }
        }
        //if(sum == 0) return nums[nums.length -1];
        return sum;
    }

    public static int maxArea(int[] height) {
        int len = height.length;
        int leftMax = height[0];
        int rightMax = height[len -1];
        int sum = 0;
        for(int i=0,j=len-1;i<j;) {
            int currSum = 0;
            if(leftMax < rightMax) {
                currSum = leftMax * (j-i);
                while(height[i] <= leftMax && i < len) {
                    i++;
                }
            }
            else {
                currSum = rightMax * (j-i);
                while(height[j] <= rightMax && j > 0) j--;
            }
            leftMax = height[i];
            rightMax = height[j];
            if(sum < currSum) {
                sum = currSum;
            }
        }
        return sum;
    }



    public static void main(String[] args) {
      /*  System.out.println(new Solution().solve(1065024));
        System.out.println(Math.sqrt(1065024));

        System.out.println(Integer.MAX_VALUE);
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(maxSubArray(new int[]{1,2,3,-7,10}));
        System.out.println(maxSubArray(new int[]{-1,-2}));
        System.out.println(maxSubArray(new int[]{1,-1,-2}));*/
       // System.out.println(1065024222232 * 21212);
        List<Integer> list = new ArrayList<>();
            Collections.sort(list);
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        System.out.println(maxArea(new int[]{1,2,1}));
        System.out.println(maxArea(new int[]{4,3,2,1,4}));
        System.out.println(maxArea(new int[]{1,1}));
        System.out.println(1 << 5);
        System.out.println(Math.pow(2,10));
        //trailingZeros(100);
    }

}
