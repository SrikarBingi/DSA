package Arrays;
import java.util.*;
public class KthSmallest {
    
    
    // using sorting

    public static int sorting(int[] arr, int k){
        
        // for sorting it takes nlogn

        Arrays.sort(arr);
        return arr[k-1];
    }

    // using min-heap 

    public static int minHeap(int[] arr, int k){

        Queue<Integer> pq = new PriorityQueue<>();

        // pq arranges elements in ascending order
        // smallest element is at th top i.e., root level
        // nlogn for inserting elements into pq and O(klogn) for extracting the min k times
        // space o(n) for using heap
        
        for(int num : arr){
            pq.add(num);
        }

        int kthSmallest = -1;
        for(int i=0; i<k; i++){
            kthSmallest = pq.poll();
        }

        return kthSmallest;
    }

    // using quick-select

    public static int quickSelect(int[] arr, int left, int right, int k){

        if(left==right){
            return arr[left];
        }

        int pivotIndex = partition(arr, left, right);
        return pivotIndex;

    }
    public static int partition(int[] arr, int left, int right){
        // int pivot = arr[right];
        int i = left;

        return i;
    }

    public static void main(String[] args) {
        int[] arr = {12, 3, 5, 7, 19};
        int k = 2;
        System.out.println("Kth smallest element is " + sorting(arr, k));
        System.out.println(minHeap(arr, k));
    }
}
