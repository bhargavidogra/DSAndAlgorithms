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
        // quicksort(arr,0, n-1);
        // mergesort(arr,0,n-1);
        // heapsort(arr);
        // radixsort(arr,n);
        countSort2(arr,n);
        printable(arr);
    }

    public static void countSort2(int arr[],int n){
        int max = Arrays.stream(arr).max().getAsInt();
        int out[]=new int[n];
        int count[]= new int[max+1];
        for(int i=0;i<n;i++){
            count[arr[i]]++;
        }
        for(int j=0;j<max;j++){
            count[j+1]+=count[j];
        }
        for(int i=n-1;i>=0;i--){
            out[--count[arr[i]]]=arr[i];
        }
        for(int j=0;j<n;j++){
            arr[j]=out[j];
        }
    }
    public static  void radixsort(int arr[], int n){
        int m = Arrays.stream(arr).max().getAsInt();
        for(int exp=1;m/exp>0;exp*=10){
            countSort(arr,n,exp);
        }
    }

    public static  void countsort(int arr[], int n,int exp){
//        int max = arr[0];
        int tarr[] = new int[n];
        for (int i = 0; i < arr.length; i++) {
           tarr[i]=arr[i]%exp;
        }
        int max = Arrays.stream(tarr).max().getAsInt();
        int count[] = new int[max+1];
        //finding frequency array
       for(int i =0;i<n;i++){
           count[tarr[i]]++;
       }
       //add previous element to every next element
       for(int j=1;j<=max;j++){
           count[j]+=count[j-1];
       }

       int output[]= new int[n];
       //traverse the original array(arr) reverse and for each element, in count for that value dec freq by 1
        // and place the element in output array at that index.
       for(int i=n-1;i>=0;i--){
           output[--count[tarr[i]]]= arr[i];
       }
       for(int i=0;i<n;i++){
           arr[i]= output[i];
       }
    }

    static void countSort(int arr[], int n, int exp)
    {
        int output[] = new int[n]; // output array
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);

        // Store count of occurrences in count[]
        for (i = 0; i < n; i++)
            count[(arr[i] / exp) % 10]++;

        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];

        // Build the output array
        for (i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to current
        // digit
        for (i = 0; i < n; i++)
            arr[i] = output[i];
    }

    public static void  heapsort(int arr[]){
        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>();

        int temp[] =new int[arr.length];
        int i=0;
        while(i<arr.length){
            pQueue.add(arr[i]);
            i++;
        }
        int k=0;
        while(pQueue.peek()!=null) {
            int x = pQueue.poll();
            temp[k]=x;
            k++;
        }
        printable(temp);
    }
    public static void quicksort(int arr[], int left, int right){
        //incase left index is more than right -> return
        if(left>=right)
            return;
       //gain pivot element
        int pivot = arr[(left+right)/2] ;
        //find partition index
        int index = partition(arr,left,right,pivot);
        //perform quicksort on subarray
        quicksort(arr,left,index-1);
        quicksort(arr,index,right);
    }
    public static int partition (int arr[], int l, int r, int pivot){
        //while left index is less than right index iterate
        while(l<=r){
            //increment left pointer till arr[left] is less than pivot
            while(arr[l]<pivot){
                l++;
            }
            //decrement right pointer till arr[right] is more than pivot
            while(arr[r]>pivot){
                r--;
            }
            //if left index is less than or equal to right index swap array elements
            // and increase left pointer by one and decrease right by one.
            if(l<=r){
                swap(arr,l,r);
                l++;
                r--;
            }
        }
        //return left index to partition further.
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
    public static void mergesort(int arr[], int left, int right){
        if(left<right) {
            int mid = (left + right) / 2;
            mergesort(arr, left, mid);
            mergesort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}