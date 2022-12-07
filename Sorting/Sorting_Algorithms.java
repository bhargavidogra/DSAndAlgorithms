import java.util.Scanner;
import java.util.*;

class Scratch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i]= sc.nextInt();
        }
        // bubbleSort(arr);
        // selectionSort(arr);
        // insertionSort(arr);
        // quickSort(arr,0, n-1);
        // mergeSort(arr,0,n-1);
        // countSort(arr,n);
         printable(arr);
    }

    public static void countSort(int[] arr, int n){
        int max = Arrays.stream(arr).max().getAsInt();
        int fre[] = new int[max+1];
        Arrays.fill(fre,0);
        int sum[] = new int[max+1];
        int output[] = new int[arr.length];
        for(int i=0;i< arr.length;i++){
            fre[arr[i]]++;
        }
        sum[0]= fre[0];
        for(int j=1;j<max+1;j++){
            sum[j]= sum[j-1]+fre[j];
        }
        for(int k=arr.length-1;k>=0;k--){
            output[--sum[arr[k]]]=arr[k];
        }
        for(int i=0;i<arr.length;i++){
            arr[i]=output[i];
        }
    }

    public static void mergeSort(int[] arr, int l, int r){
        if(l<r){
            int mid = (l+r)/2;
            mergeSort(arr,l,mid);
            mergeSort(arr,mid+1,r);
            merge(arr,l,mid,r);
        }
    }

    public static void merge(int[] arr, int l, int m, int r ){
        int n1 = m-l+1;
        int n2 = r-m;
        int left[] = new int[n1];
        int right[] = new int[n2];

        for(int i=0;i<n1;i++){
            left[i]=arr[l+i];
        }
        for(int i=0;i<n2;i++){
            right[i]=arr[m+1+i];
        }

        int k=l, i=0,j=0;
        while(i<n1 && j<n2){
            if(left[i]<=right[j]){
                arr[k]=left[i];
                i++;
                k++;
            }else{
                arr[k]=right[j];
                j++;
                k++;
            }
        }

        while(i<n1){
            arr[k]=left[i];
            i++;
            k++;
        }

        while(j<n2){
            arr[k]=right[j];
            j++;
            k++;
        }
    }

    public static void bubbleSort(int[] arr){
        for(int i=1; i < arr.length; i++ ){
            for(int j = 0 ; j< arr.length-i ;j++){
                if(arr[j]>arr[j+1]){
                    swap(arr,j,j+1);
                }
            }
        }
    }

    public static void insertionSort(int [] arr){
        for(int i=0; i<arr.length ; i++){
            int minIndex= getminIndex(arr,i);
            swap(arr,i,minIndex);
        }
    }
    public static int getminIndex(int arr[], int i){
        int mi=i;int mv=arr[mi];
        for(int x=i+1;x<arr.length;x++){
            if(arr[x]<mv){
                mv=arr[x];
                mi=x;
            }
        }
        return mi;
    }

    public static void selectionSort(int arr[]){
        for(int i=0; i< arr.length-1 ; i++){
            for(int j=i+1; j>0 ; j--){
                if(arr[j]<arr[j-1]){
                    swap(arr,j,j-1);
                }
            }
        }
    }

    public static void quickSort(int[] arr, int l , int r){
        if(l<r){
            int mid = (l+r)/2;
            int in = partition(arr,l,r,arr[mid]);
            quickSort(arr,l,in);
            quickSort(arr,in+1,r);
        }
    }

    public static int partition(int arr[], int l , int r, int pivot){

        while(l<r){
            while(arr[l]<pivot){
                l++;
            }
            while(arr[r]>pivot){
                r--;
            }
            if(arr[l]>arr[r]){
                swap(arr,l,r);
            }
        }

        return l;
    }

    public static void swap(int arr[], int l, int r){
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
    public static void printable(int arr[]){
        System.out.println();
        for(int i=0;i<arr.length;i++){
            System.out.print(" "+arr[i]);
        }
    }
}