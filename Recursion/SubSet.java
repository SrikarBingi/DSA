package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSet {
    public static void main(String[] args) {
        int[] arr={1,2,2};
        // System.out.println(subSet(arr));
        System.out.println(subSetWithDuplicates(arr));
    }
    public static List<List<Integer>> subSet(int[] arr){
        Arrays.sort(arr);
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<Integer>());
        for(int num:arr){
            int n=outer.size();
            for(int i=0;i<n;i++){
                List<Integer> internal = new ArrayList<>(outer.get(i));
                internal.add(num);
                outer.add(internal);
            }
        }
        return outer;
    }
    public static List<List<Integer>> subSetWithDuplicates(int[] arr){
        Arrays.sort(arr);
        int start=0;
        int end=0;
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<Integer>());
        for(int i=0;i<arr.length;i++){
            start=0;
            if(i>0 && arr[i]==arr[i-1]){
                start=end+1;
            }
            int n=outer.size();
            end=outer.size()-1;
            for(int j=start;j<n;j++){
                List<Integer> internal = new ArrayList<>(outer.get(j));
                internal.add(arr[i ]);
                outer.add(internal);
            }
        }
        return outer;
    }
}
