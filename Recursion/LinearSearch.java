package Recursion;

import java.util.ArrayList;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {1,2,3,2};
        System.out.println(findAllIndex2(arr, 2, 0));
    }
    public static int findIndex(int[] arr, int t,int index){
        if(arr[index]==t){
            return index;
        }
        if(index==arr.length-1){
            return -1;
        }
        return findIndex(arr, t, index+1);
    }
    static ArrayList<Integer> list = new ArrayList<>();
    public static void findAllIndex(int[] arr, int t, int index){
        if(index==arr.length){
            return;
        }
        if(arr[index]==t){
            list.add(index);
        }
        findAllIndex(arr, t, index+1);
    }
    public static ArrayList<Integer> findAllIndex(int[] arr, int t, int index, ArrayList<Integer> list) {
        if(index==arr.length){
            return list;
        }
        if(arr[index]==t){
            list.add(index);
        }
        return findAllIndex(arr, t, index+1, list);
    }
    public static ArrayList<Integer> findAllIndex2(int[] arr, int t, int index){
        ArrayList<Integer> res = new ArrayList<>();
        if(index==arr.length){
            return res;
        }
        if(arr[index]==t){
            res.add(index);
        }
        ArrayList<Integer> ansFromBelowCalls=findAllIndex2(arr, t, index+1);
        res.addAll(ansFromBelowCalls);
        return res;
    }
}
