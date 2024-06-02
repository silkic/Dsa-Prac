package Sorting;

public class Merge {

class Solution
{
    void merge(int arr[], int l, int m, int r)
    {
         // Sizes of two subarrays to be merged
         int n1 = m - l + 1;
         int n2 = r - m;
         
         // Temporary arrays
         int[] arr1 = new int[n1];
         int[] arr2 = new int[n2];
         
         // Copy data to temporary arrays
         for (int i = 0; i < n1; ++i)
             arr1[i] = arr[l + i];
         for (int j = 0; j < n2; ++j)
             arr2[j] = arr[m + 1 + j];
         
         // Initial indexes of the temporary arrays
         int i = 0, j = 0;
         
         // Initial index of the merged subarray array
         int k = l;
         while (i < n1 && j < n2) {
             if (arr1[i] <= arr2[j]) {
                 arr[k] = arr1[i];
                 i++;
             } else {
                 arr[k] = arr2[j];
                 j++;
             }
             k++;
         }
         
         // Copy remaining elements of arr1[]
         while (i < n1) {
             arr[k] = arr1[i];
             i++;
             k++;
         }
         
         // Copy remaining elements of arr2[]
         while (j < n2) {
             arr[k] = arr2[j];
             j++;
             k++;
         }
    }
    
    void mergeSort(int arr[], int l, int r)
    {
        // Base case to stop recursion
        if (l < r) {
            // Find the middle point
            int m = l + (r - l) / 2;
            
            // Sort first and second halves
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            
            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }
}


}
