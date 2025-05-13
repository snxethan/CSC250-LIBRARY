package NEU.ET39.CSC250.Algorithms;

import java.util.Arrays;

public class Sorter<T extends Comparable<? super T>> {


    public static Comparable[] bubbleSort(Comparable[] arr)
    {
        //Time complexity  O(n^2)
        //Space complexity  O(1)

        // loop through length of array
        for (int i = 0; i < arr.length; i++) { //O(n)
            boolean swap= false;

            // loop through array, but skip last index
            for (int j = 0; j < arr.length - 1 - i; j++) { //O(n)

                // check next index
                if (arr[j].compareTo(arr[j + 1]) > 0) { //O(1)
                    var temp = arr[j]; //O(1)
                    arr[j] = arr[j+1];
                    arr[j + 1] = temp;
                    // replace both indexes
                    swap= true;
                }

            }
            if (!swap){ //O(1)
                return arr;
                // break out of loop if not swapped
            }
        }
        //Big O
        //Time complexity: O(N^2)
        //Space complexity: O(1)
        return arr;
    }

    public static Comparable[] swap(Comparable[] arr, int one, int two) {
        var temp = arr[one];
        arr[one] = arr[two];
        arr[two] = temp;
        return arr;
    }

    public static Comparable[] insertionSort(Comparable[] arr){

        //take a given array, go index by index, checking the previous indexes that have been sorted
        for (int i = 1; i < arr.length; i++) { // O(n)
            // loop through the length of the array
            for (int j = i; j > 0; j--) { // O(n)
                // nested for loop to check each index to the current index
                // loop backwards and compare the index and each index behind it
                if (arr[j].compareTo(arr[j-1]) < 0) { //O(1)
                    //swap the indexes if they are smaller
                    var temp = arr[j]; //O(1)
                    arr[j] = arr[j-1]; //O(1)
                    arr[j-1] = temp; //O(1)
                }
            }
        }
        return arr;

        // Space Complexity: O(1)
        // We only use 1 array which doesnt change, same with all our vars,
        // Time Complexity: O(n^2)
        // We have 2 nested for loops which go from linear to quadratic.
    }



    public static Comparable[] insertionSort2(Comparable[] arr){

        //take a given array, go index by index, checking the previous indexes that have been sorted
        for (int i = 0; i < arr.length; i++) { // O(n)
            var j = i;
            while(j > 0 && arr[j].compareTo(arr[j - 1]) < 0){
                var temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
                j--;
            }
        }
        return arr;
    }

    public static Comparable[] selectionSort(Comparable[] arr){
        // check and get the smallest num / index out of the entire array

        // loop through the length of the array
        for (int i = 0; i < arr.length; i++) { // O(n)
            var smallestIndex = i; // O(1)
            // loop through the array and find the smallest possible number
            for (int j = i; j < arr.length; j++) { // O(n)
                // if the smallest possible number is smaller than the index the nested loop starts at, swap
                if (arr[j].compareTo(arr[smallestIndex]) < 0) { // O(1)
                    smallestIndex = j; // O(1)
                }
            }
            // replace the index with the smallest index from the second loop
//            var temp = arr[i]; // O(1)
//            arr[i] = arr[smallestIndex];  // O(1)
//            arr[smallestIndex] = temp;  // O(1)
            swap(arr, i, smallestIndex);
        }
        return arr;

        // Space Complexity: O(1)
        // we only use 1 array which doesnt change, which is the same for all the vars.
        // Time Complexity: O(n^2)
        // we have a nested forloop inside a for loop which changes from linear, to linear*linear=quadratic.
    }




    //  Divide
    //Split the array into two halves.
    //
    //Keep splitting each half until each subarray has only one element (which is trivially sorted).
    //
    //2. Conquer (Sort)
    //Recursively sort each of the smaller subarrays.
    //
    //3. Combine (Merge)
    //Merge the two sorted halves into one sorted array.


    //Divide Phase:
    //[38, 27, 43, 3, 9, 82, 10]
    // → [38, 27, 43] and [3, 9, 82, 10]
    // → [38], [27, 43] and [3, 9], [82, 10]
    // → [27], [43] and [3], [9], [82], [10]

    //Conquer + Combine Phase:
    //→ merge([27], [43]) → [27, 43]
    //→ merge([38], [27, 43]) → [27, 38, 43]
    //
    //→ merge([3], [9]) → [3, 9]
    //→ merge([82], [10]) → [10, 82]
    //→ merge([3, 9], [10, 82]) → [3, 9, 10, 82]
    //
    //→ merge([27, 38, 43], [3, 9, 10, 82]) → [3, 9, 10, 27, 38, 43, 82]

//    public static Comparable[] mergeSort(Comparable[] arr, int left, int right) {
//        if (right - left <= 0) {  // one element array / O (1)
//            return arr; //return the one element array
//        }
//
//        int mid = (left + right) / 2; //grab the middle value // O (1)
//
//        Comparable[] leftSide = mergeSort(arr, left, mid); //get the left side (as an array) and recurse
//        Comparable[] rightSide = mergeSort(arr, mid + 1, right); //get the right side (as an array) and recurse
//
//        return mergeAndSort(leftSide, rightSide); //merge each array through each loop,
//    }

    public static Comparable[] mergeSort(Comparable[] arr) {
        if (arr.length <= 1) return arr;

        int mid = arr.length / 2;
        Comparable[] left = Arrays.copyOfRange(arr, 0, mid);
        Comparable[] right = Arrays.copyOfRange(arr, mid, arr.length);

        return mergeAndSort(mergeSort(left), mergeSort(right));
    }


    public static Comparable[] mergeAndSort(Comparable[] arr1, Comparable[] arr2) {
        // create a array to hold both incoming arrays
        Comparable[] merged = new Comparable[arr1.length + arr2.length];
        // indexes for while loops
        int i = 0, j = 0, k = 0; // O (3)

        // loop through the first and second array
        while (i < arr1.length && j < arr2.length) { //
            // compare each index and assign it to merged array
            if (arr1[i].compareTo(arr2[j]) <= 0) {
                //if arr1[i] is less than or equal to array2[j]
                merged[k++] = arr1[i++];
                //add to the next merge index from arr1
            } else {
                //otherwise add to the next mere index from arr2
                merged[k++] = arr2[j++];
            }
        }

        //only one of these loops will run at once

        while (i < arr1.length) {
            //while the loop index is less than arr1 length, add arr1 index to merge array
            merged[k++] = arr1[i++];
        }

        while (j < arr2.length) {
            //while the loop index is less than arr2 length, add arr1 index to merge array
            merged[k++] = arr2[j++];
        }

        return merged; //return the merged array
    }


    /**
     * Quick sort through an array, taking a pivot and partitioning points around it.
     * @param arr The array to sort
     * @param left the leftmost value of the array
     * @param right the rightmost value of the array
     * @return a sorted/partitioned array
     */
    public static Comparable[] quickSort(Comparable[] arr, int left, int right) {
        if (right - left <= 0) { // O(1)
            //check if the array is less than or one value
            return arr;
        }

        int pivot = right; //the pivot is the rightmost value of the array (starting as the end value and working down from recursion
        int jndex = left-1; // the j index to hold lower values agaisnt the pivot
        for (int index = left; index < right; index++) { // O(n)
            //loop through the array agaisnt the left & right values
            if(arr[index].compareTo(arr[pivot]) < 0){ // O(1)
                //if the current index is less than the pivot
                jndex++; //increase the j index // O(1)
                swap(arr, jndex, index); // O(1)
            }
        }
        //after the loop has finished, you have reached the pivot
        // the pivot will now swap with the last value sorted + 1
        jndex++;
        //swap values
        swap(arr, jndex, pivot);


        // recursive - sort the left fields of the pivot
        arr = quickSort(arr,left,jndex-1); // O(log n)
        // recursive - sort the right fields of the pivot
        arr = quickSort(arr,jndex+1,right); // O(log n)
        //return thr array
        return arr;
    }
    //Space Complexity:
    // no values being changed, i.e. arrays, O(1)
    // however, recursive calls take stack space: O (Log n)
    //Time Complexity:
    // recursive calls: O (n Log n)


}