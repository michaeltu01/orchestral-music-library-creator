package src.backend;

import java.util.ArrayList;

public class MergeSort 
{

    //https://www.geeksforgeeks.org/merge-sort/ 
    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    public static void merge(ArrayList<Composition> metadata, int l, int m, int r)
    {        
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        ArrayList<Composition> left = new ArrayList<Composition>(n1);
        ArrayList<Composition> right = new ArrayList<Composition>(n2);

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            left.add(metadata.get(l + i));
        for (int j = 0; j < n2; ++j)
            right.add(metadata.get(m + 1 + j));

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (left.get(i) <= right.get(j)) {
                metadata.add(k, left.get(i));
                i++;
            }
            else {
                metadata.add(k, right.get(j));
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            metadata.add(k, left.get(i));
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            metadata.add(k, right.get(j));
            j++;
            k++;
        }
    }
    
    // Main function that sorts arr[l..r] using
    // merge()
    public static void mergeSort(String[] , int l, int r)
    {
        
        if (l < r)
        {
            // Find the middle point
            int m =l+ (r-l)/2;

            // Sort first and second halves
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }
}
