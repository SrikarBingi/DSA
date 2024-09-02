package Arrays;

import java.util.*;
public class RotateArrayByK {

    //thi method takes extra space
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] rotated = new int[n];
        
        for (int i = 0; i < n; i++) {
            //rotated[0]=nums[3]
            rotated[(i + k) % n] = nums[i];
        }
        
        for (int i = 0; i < n; i++) {
            nums[i] = rotated[i];
        }
    }

    //without extra space
    public static void rotate2(int[] nums, int k){
        int i = 0;
        int j = nums.length-1;
        while(i<j){
            swap(nums,i,j);
            i++;
            j--;
        }
        i = 0;
        j = k-1;
        while(i<j){
            swap(nums, i, j);
            i++;
            j--;
        }
        i=k;
        j = nums.length-1;
        while(i<j){
            swap(nums, i, j);
            i++;
            j--;
        }
    }
    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};
        int k = 3;
        // rotate(arr, k);
        rotate2(arr, k);
        System.out.println(Arrays.toString(arr));
        
    }
}
