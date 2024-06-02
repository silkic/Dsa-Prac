package Sorting;

public class Quick {
	class Solution {
	    // Function to sort an array using quick sort algorithm.
	    static void quickSort(int arr[], int low, int high) {
	        while (low < high) {
	            int pivotIndex = partition(arr, low, high);
	            // Tail call optimization: sort the smaller half first
	            if (pivotIndex - low < high - pivotIndex) {
	                quickSort(arr, low, pivotIndex - 1);
	                low = pivotIndex + 1;
	            } else {
	                quickSort(arr, pivotIndex + 1, high);
	                high = pivotIndex - 1;
	            }
	        }
	    }

	    static int partition(int arr[], int low, int high) {
	        int pivot = medianOfThree(arr, low, high);
	        int i = low + 1;
	        int j = high;
	        while (true) {
	            while (i <= j && arr[i] <= pivot) {
	                i++;
	            }
	            while (i <= j && arr[j] > pivot) {
	                j--;
	            }
	            if (i <= j) {
	                swap(arr, i, j);
	            } else {
	                break;
	            }
	        }
	        swap(arr, low, j);
	        return j;
	    }

	    static int medianOfThree(int[] arr, int low, int high) {
	        int mid = low + (high - low) / 2;
	        if (arr[mid] < arr[low])
	            swap(arr, low, mid);
	        if (arr[high] < arr[low])
	            swap(arr, low, high);
	        if (arr[high] < arr[mid])
	            swap(arr, mid, high);
	        swap(arr, low, mid);
	        return arr[low];
	    }

	    public static void swap(int[] arr, int i, int j) {
	        int temp = arr[i];
	        arr[i] = arr[j];
	        arr[j] = temp;
	    }
	}

}
