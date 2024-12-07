package Arrays;

import java.util.HashSet;

public class ContainsDuplicate {
    public static boolean containsDuplicate(int[] nums) {
        // Arrays.sort(nums);
        // int n = nums.length;
        // for (int i = 1; i < n; i++) {
        //     if (nums[i] == nums[i - 1])
        //         return true;
        // }
        // return false;

        HashSet<Integer> set = new HashSet<Integer>();
        for(int num : nums){
            if(set.contains(num)){
                return true;
            }
            set.add(num);
        }
        return false;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 1};
        System.out.println(containsDuplicate(arr));
    }
}
