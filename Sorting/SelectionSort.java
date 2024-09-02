package Sorting;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5};
        for(int i=0;i<arr.length-1;i++){
            int j=i,k=i;
            for(;j<arr.length;j++){
                if(arr[j]<arr[k]){
                    k=j;
                }
            }
            int temp=arr[i];
            arr[i]=arr[k];
            arr[k]=temp;
        }
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
