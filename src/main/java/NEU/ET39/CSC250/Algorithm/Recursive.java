package NEU.ET39.CSC250.Algorithm;

public class Recursive {


    /**
     * Completes a non linear/sequential binary search
     * Completes a search through a sorted array by finding the low, mid, and high points, and then recursively calls itself with those points to
     * narrow down the array further and further.
     * @param arr a sorted array to look through
     * @param low the lowest index in the array
     * @param high the highest index in the array
     * @param target the target number you want to find in the array
     * @return the index the target is located at
     */
    public static int BinarySearch(Integer[] arr, int low, int high, int target) {
        if(arr.length == 0) return -1;
        if(arr.length == 1) {
            if(arr[0] == target) return 0;
            else return -1;
        }
        // input = sorted array
        // input = target num in array
        // output = index of key OR identifier of no index


        //get the middle index of the array (array.length / 2)
        // this prevents overflow from high integers
        int mid = low + (high - low) / 2;
        //check if target is greater than or less than target num
        if(low > high){ // 0(1)
            //if target is unreachable, and recursive search is at the end of loop, e.g. low is higher than high
            return -1; //target not in sorted array
        }

        if(arr[mid] == target){ //O(1)
            //if midpoint equals target, return index.
            //return index of found element
            return mid;
        } else if(arr[mid] > target){ //O(1)
            //if less than: split to left.
            //recursive: call method again with copied array of starting index to middle index
            //return index of found element
            return BinarySearch(arr, low, mid - 1, target);
                // Performs recursive binary search
                // Time Complexity: O(log n)
                // Space Complexity: O(log n) from recursion depth
        } else if(arr[mid] < target){ //O(1)
            //if greater than: split to right
            //recursive: call method again with copied array of middle index to end index.
            //return index of found element
            return BinarySearch(arr, mid + 1, high, target);
                // Performs recursive binary search
                // Time Complexity: O(log n)
                // Space Complexity: O(log n) from recursion depth
        }
        //if target is unreachable, return a identifier (-1).
        //this can only be reached if the target is less than and out of the array entirely
        return -1;


        //Time Complexity:
        // O(1) * Log^n(n) = O(log n)
        // the recursive method calls itself, but halves its logic each time it is called, n/2 to n/4 to n/8 and so on
        // O(log n)

        //Space Complexity:
        // constant sized vars of O(1)
        // RECURSION: array is halved each loop > recursive calls take stack space
        // max depth = log n
        // array of 8 to array of 4, and so on.
        // O(log n)
    }


}