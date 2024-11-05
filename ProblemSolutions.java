/******************************************************************
 *
 *   NATE CALDERON / SECTION 001
 *
 *   This java file contains the problem solutions of isSubSet, findKthLargest,
 *   and sort2Arrays methods. You should utilize the Java Collection Framework for
 *   these methods.
 *
 ********************************************************************/

import java.util.*;
// import java.util.Collections;

class ProblemSolutions {

    /**
     * Method: isSubset()
     *
     * Given two arrays of integers, A and B, return whether
     * array B is a subset if array A. Example:
     *      Input: [1,50,55,80,90], [55,90]
     *      Output: true
     *      Input: [1,50,55,80,90], [55,90, 99]
     *      Output: false
     *
     * The solution time complexity must NOT be worse than O(n).
     * For the solution, use a Hash Table.
     *
     * @param list1 - Input array A
     * @param list2 - input array B
     * @return      - returns boolean value B is a subset of A.
     */

    public boolean isSubset(int list1[], int list2[]) {
        /*  PSEUDO CODE: 
        GIVEN INPUT list1[] {
            CHECK IF list2[] IS CONTAINED IN list1[];
            return TRUE;
        } ELSE */
        // USAGE OF HASHTABLE: HashSet <Integer> = new HashSet<>();
        HashSet <Integer> = new HashSet<>();
        // Add elements in list1 to HashSet
        for (int num : list1) {
            set.add(num);
        }
        // Checking if elements in list2 are in HashSet
        for (int num : list2) {
            if (!set.contains(num)) {
                return false; // If not return false
            }
        }
        // Otherwise, return true
        return true;
    }


    /**
     * Method: findKthLargest
     *
     * Given an Array A and integer K, return the k-th maximum element in the array.
     * Example:
     *      Input: [1,7,3,10,34,5,8], 4
     *      Output: 7
     * 
     * @param array - Array of integers
     * @param k     - the kth maximum element
     * @return      - the value in the array which is the kth maximum value
     */

    public int findKthLargest(int[] array, int k) {
        /* IDEAS: ORDER ARRAY FROM GREATEST TO SMALLEST THEN LOCATE KTH ELEMENT */
        // COLLECTION.SORT() (QUICK SORT) (ASCENDING ORDER); COLLECTIONS.REVERSEORDER() (DESCENDING)
        /* Arrays.sort(array, Collections.reverseOrder()); // Sorting array in Descending
        return array[k - 1]; // Returning kth element */
        
        // Create a min-heap with capacity k
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        // Add elements from array into heap
        for (int num : array) {
            minHeap.add(num);
            // if heap size > k, remove the smallest element
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        // The kth element will be at the top of the heap
        return minHeap.peek();

        //return 0;
    }


    /**
     * Method: sort2Arrays
     *
     * Given two arrays A and B with n and m integers respectively, return
     * a single array of all the elements in A and B in sorted order. Example:
     *      Input: [4,1,5], [3,2]
     *      Output: 1 2 3 4 5
     *
     * @param array1    - Input array 1
     * @param array2    - Input array 2
     * @return          - Sorted array with all elements in A and B.
     */

    public int[] sort2Arrays(int[] array1, int[] array2) {
        /* IDEAS: UNIONIZE ARRAYS AND SORT, THEN RETURN CONTENTS */
        // Create new array to contain array1 and array2
        int[] combinedArray = new int[array1.length + array2.length];
        // Copy elements from array1 to combinedArray
        System.arraycopy(array1, 0, combinedArray, 0, array1.length);
        // Copy elements from array2 to combinedArray
        System.arraycopy(array2, 0, combinedArray, array1.length, array2.length);
        // Sort array
        Arrays.sort(combinedArray);
        // Return sorted Array
        return combinedArray;
    }

}