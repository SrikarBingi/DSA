package Sorting;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr={12,8,3,6,1,2};
        mergeSort(0, arr.length-1, arr);
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
    public static void mergeSort(int start, int end, int[] arr){
        if(start<end){
            int mid=(start+end)/2;
            mergeSort(start,mid,arr);
            mergeSort(mid+1,end,arr);
            merge(start,mid,end,arr);
        }
    }
    public static void merge(int start, int mid, int end, int[] arr){
        int i=start, j=mid+1, k=start;
        int[] b = new int[arr.length];
        while(i<=mid && j<=end){
            if(arr[i]<arr[j]){
                b[k++]=arr[i++];
            }
            else{
                b[k++]=arr[j++];
            }
        }
        while(i<=mid){
            b[k++]=arr[i++];
        }
        while(j<=end){
            b[k++]=arr[j++];
        }
        for(i=start;i<=end;i++){
            arr[i]=b[i];
        }
    }
}
