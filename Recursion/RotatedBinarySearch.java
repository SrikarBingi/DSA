package Recursion;

public class RotatedBinarySearch {
    public static void main(String[] args) {
        int[] arr={5,6,7,1,2,3,4};
        System.out.println(findIndex(arr, 0, arr.length-1, 7));
    }
    public static int findIndex(int[] arr, int s, int e, int t){
        if(s>e){
            return -1;
        }
        int m=s+(e-s)/2;
        if(arr[m]==t){
            return m;
        }
        if(arr[s]<=arr[m]){
            if(arr[s]<=t && t<=arr[m]){
                return findIndex(arr, s, m-1, t);
            }
            return findIndex(arr, m+1, e, t);
        }
        else if(arr[m]<=t && t<=arr[e]){
            return findIndex(arr, m+1, e, t);
        }
        return findIndex(arr, s, m-1, t);
    }
}
