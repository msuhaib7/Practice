import java.util.ArrayList;
import java.util.List;

public class Practice {

    public static List<List<Integer>> findSums(int[] nums, int target) {

        if(target == 0) return new ArrayList<>();
        if(target < 0) return null;

        List<List<Integer>> combs = new ArrayList<>();

        for(int i =0; i< nums.length; i++) {
            int rem = target - nums[i];
            List<List<Integer>> list = findSums(nums, rem);
            if(list != null) {
                if(list.size() == 0){
                    List<Integer> newList = new ArrayList<>();
                    list.add(newList);
                } else {
                    for(List l :list){
                        l.add(nums[i]);
                        combs.add(l);
                    }
                }
            }
        }
        return combs;
    }

    public static void main(String[] args) {
        System.out.println(findSums(new int[]{2,3,6,7},7));
    }
}
