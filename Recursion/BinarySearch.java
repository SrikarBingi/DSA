package Recursion;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        System.out.println(findIndex(arr, 0, 5, 3));
    }
    public static int findIndex(int[] arr,int s, int e, int t){
        int mid = s+(e-s)/2;
        if(s>e){
            return -1;
        }
        if(arr[mid]==t){
            return mid;
        }
        else if(arr[mid]>t){
            return findIndex(arr, mid+1, e, t);
        }
        return findIndex(arr, s, mid-1, t);
    }
}
