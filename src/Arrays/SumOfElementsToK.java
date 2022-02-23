package Arrays;

import java.util.*;

public class SumOfElementsToK {

    public static boolean canSumToK(int[] arr,int k, Map<Integer,Boolean> map){
        if(map.containsKey(k)) return map.get(k);
        if(k == 0) return true;
        if(k < 0) return false;
        for(int i=0;i <arr.length; i++){
             if(canSumToK(arr, k - arr[i],map)){
                 map.put(k,true);
                 return true;
             }
        }
        map.put(k,false);
        return false;
    }

    public static List<Integer> findSumToK(int[] arr, int k, Map<Integer,List<Integer>> map){
        if(map.containsKey(k)) return map.get(k);
        if(k == 0) return new ArrayList<>();
        if(k < 0) return null;
        for(int i=0;i <arr.length; i++){
            List<Integer> l  = findSumToK(arr, k - arr[i],map);
            if( l != null){
                l.add(arr[i]);
                map.put(k,l);
                return l;
            }
        }
        map.put(k,null);
        return null;
    }
    public static List<Integer> bestSumToK(int[] arr, int k, Map<Integer,List<Integer>> map){
        if(map.containsKey(k)) return map.get(k);
        if(k == 0) return new ArrayList<>();
        if(k < 0) return null;
        List<Integer> minimum = null;
        for(int i=0;i <arr.length; i++){
            int remainder = k - arr[i];
            List<Integer> combination  = bestSumToK(arr, remainder,map);
            if( combination != null){
                combination.add(arr[i]);
                if(minimum == null || combination.size() < minimum.size() ) {
                    minimum = combination;
                }
            }
        }
        map.put(k,minimum);
        return minimum;
    }

    public static List<List<Integer>> allSumToK(int[] arr, int sum) {
        if(sum == 0) return new ArrayList<>();
        if(sum < 0) return null;
        List<List<Integer>> allCombinations = null;
        for(int i=0; i< arr.length; i++) {
            int rem = sum - arr[i];
            List<List<Integer>> list = allSumToK(arr, rem);
            if(list != null){
                //allCombinations.add(list);
                if(list.size() == 0) {
                    List<Integer> ll = new ArrayList<>();
                    list.add(ll);
                }
                for(List<Integer> l : list) {
                    l.add(arr[i]);
                    if(allCombinations == null) allCombinations = new ArrayList<>();
                    Collections.sort(l);
                    if(!allCombinations.contains(l)) allCombinations.add(l);
                }
            }
        }
        return allCombinations;
    }

    public static List<Integer> distinctKElementsThatSum(int[] nums, int sum, int k,int i){
        if(sum < 0) return null;
        if(sum == 0 && k == 0) return new ArrayList<>();
        if(k < 0) return null;
       // if(k < 0) return null;
       // int target = 0;
        for(int j=i; j< nums.length;j++){
            int rem = sum - nums[j];
            List<Integer> currSum = distinctKElementsThatSum(nums,rem,k-1,i+1);
           if(currSum != null) {
               currSum.add(nums[j]);
               return currSum;
           }
        }
        return null;
    }

    public static void main(String[] args) {
/*        System.out.println(canSumToK(new int[]{3,9,11}, 99, new HashMap<>()));
        System.out.println(canSumToK(new int[]{3,9,11}, 12, new HashMap<>()));
        System.out.println(canSumToK(new int[]{3,9,11}, 7, new HashMap<>()));
        System.out.println(canSumToK(new int[]{7,14}, 3000, new HashMap<>()));

        System.out.println(findSumToK(new int[]{3,9,11}, 99, new HashMap<>()));
        System.out.println(findSumToK(new int[]{3,9,11}, 12, new HashMap<>()));
        System.out.println(findSumToK(new int[]{3,9,11}, 7, new HashMap<>()));
        System.out.println(findSumToK(new int[]{7,14}, 3000, new HashMap<>()));


        System.out.println(bestSumToK(new int[]{3,9,11}, 12, new HashMap<>()));
        System.out.println(bestSumToK(new int[]{3,9,11}, 99, new HashMap<>()));
        System.out.println(bestSumToK(new int[]{3,9,11}, 7, new HashMap<>()));
        System.out.println(bestSumToK(new int[]{7,14}, 3000, new HashMap<>()));*/

        System.out.println("----------------------------------");
     //   System.out.println(allSumToK(new int[]{2,4},8));
       // System.out.println(distinctKElementsThatSum(new int[]{1,2,3,4,5,6,2,1},9,3,0));
        System.out.println(allSumToK(new int[]{2,3,6,7},7));
    }
}
