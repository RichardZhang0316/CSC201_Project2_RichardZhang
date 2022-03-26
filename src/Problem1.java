import java.util.*;
public class Problem1 {
    // The main class is used to check the correctness of the quicksort I implemented
    public static void main(String[] args){
        int[] array = {1,4,1,77,80,23,43,32,9,10,15};
        System.out.println(Arrays.toString(array));
        my_quicksort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void my_quicksort(int[] array){
        int high=array.length-1;
        int low=0;
        quicksort_helper(array,low,high);
    }

    private static void quicksort_helper(int[] array, int low, int high){
        if (low<high) {
            // Find the correct position where the pivot should be.
            int pivot = partition(array, low, high);
            // Divide the array into two parts and respectively sort them using recursion
            quicksort_helper(array, low, pivot-1);
            quicksort_helper(array, pivot+1, high);
        }
    }

    private static int partition(int[] array, int low, int high){
        // Use the first element of the array defined by low and high as the pivot.
        int pivot=array[low];
        // Index of higher value (use it to locate the position where the pivot should be)
        int i=low;
        // Traverse the array except to the pivot and swap elements if needed.
        for(int j=low+1;j<=high; j++){
            // If the value at array[j] is higher than the pivot, put the value of array[j]
            // in a front of the position where the pivot should be.
            if(array[j]>pivot){
                // First increase the index of the higher value
                i++;
                // Then swap the elements at array[i] and array[j]
                int temp1 = array[i];
                array[i] = array[j];
                array[j] = temp1;
            }
        }
        // Finally, we swap the pivot and array[i+1] to put the pivot at its correct position
        int temp = array[i];
        array[i] = array[low];
        array[low] = temp;
        // Return the correct position where the pivot should be
        return i;
    }
}
