package Sorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr={12,8,3,6,1,2};
        
        arr=quickSort(arr, 0, arr.length-1);
        System.out.print(Arrays.toString(arr));
    }
    public static int[] quickSort(int[] nums, int low, int high){

        
        if(low<high){
            int i=low;
            int j=high;
            int mid=(i+j)/2;
            int pivot = nums[mid];
            do{
                
                while(nums[i]<=pivot){
                    i++;
                }
                
                while(nums[j]>pivot){
                    j--;
                }
                if(i<j){
                    swap(nums, i, j);
                }
            }
            while(i<j);
            swap(nums,low,j);
            quickSort(nums, low, j);
            quickSort(nums, j+1, high);
        }
        
        return nums;
    }
    public static void swap(int[] nums, int i, int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
