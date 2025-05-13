package NEU.ET39.CSC250.Algorithms;

import java.util.ArrayList;
import java.util.List;

public class CodeWars {

        /*
     carpark = [[1, 0, 0, 0, 2],
                [0, 0, 0, 0, 0]]
      */


    // input/params: 2d array of ints
    public static List<String> carPark(int[][] array2d){
        // var for string array, the amount of directions there can possibly be will be the length of the array, plus the length of the array, -1 direction
        // e.g. every time you turn L/R in an array, and everytime you move D between arrays, minus the last array as you wont move down.
        // list or array will always be size: array2d.length+array2d.length-1
        List<String> directions = new ArrayList<>();
        // local var for starting index, defined as an unreachable val
        int startingIndex = -1;
        // local var for ending index, defined as an unreachable val
        int endingIndex = -1;
        // local var for distance between starting & ending index, defaulting to 0
        int distanceBetweenStartAndEndingIndex = 0;
        // local boolean to determine if first loop, defaulting to true on startup.
        boolean isFirstLoop = true;
        // local string for the direction, defaulting as empty
        String direction = "";
        // local string for the combination of direction + distance, defaulting as empty;
        String directionAndDistance = "";

        // loop for entire array of arrays
        for (int outerArrayIndex = 0; outerArrayIndex < array2d.length; outerArrayIndex++) {
            //nested loop to access inside array
            for (int innerArrayIndex = 0; innerArrayIndex < array2d[outerArrayIndex].length; innerArrayIndex++) {
                // if first loop:
                if (isFirstLoop) {
                    // check where 2 index and 1 index is:
                    // starting index is 2, ending index is 1
                    if(array2d[outerArrayIndex][innerArrayIndex] == 2){
                        startingIndex = innerArrayIndex;
                    }
                    if (array2d[outerArrayIndex][innerArrayIndex] == 1) {
                        endingIndex = innerArrayIndex;
                    }
                    // calculate distance from starting to ending distance
                    // compare starting & ending index to find out the direction and distance
                    if(startingIndex != -1 && endingIndex != -1){
                        if(startingIndex != endingIndex) {
                            //if starting index > ending index: go left
                            if (startingIndex > endingIndex) {
                                distanceBetweenStartAndEndingIndex = startingIndex - endingIndex;
                                direction = "L";
                            }
                            //else ending index > starting index: go right
                            else {
                                distanceBetweenStartAndEndingIndex = endingIndex - startingIndex;
                                direction = "R";
                            }
                            //add distance (0-array length) and direction (left/right) to string array
                            directionAndDistance = direction + distanceBetweenStartAndEndingIndex;
                            directions.add(directionAndDistance);

                            //add direction DOWN and distance 1 (D1) to string array - distance between 2 arrays remains constant, D1, you will never go up.
                            direction = "D";
                            distanceBetweenStartAndEndingIndex = 1;
                            directionAndDistance = direction + distanceBetweenStartAndEndingIndex;
                            directions.add(directionAndDistance);

                            // end the first loop
                            isFirstLoop = false;
                            startingIndex = endingIndex;
                        } else {
                            if (direction.equals("D")) {
                                distanceBetweenStartAndEndingIndex++;

                                // Check if last direction in list starts with "D"
                                if (!directions.isEmpty() && directions.get(directions.size() - 1).startsWith("D")) {
                                    // Replace the last element
                                    directions.set(directions.size() - 1, direction + distanceBetweenStartAndEndingIndex);
                                } else {
                                    // Otherwise, just add the new direction
                                    directionAndDistance = direction + distanceBetweenStartAndEndingIndex;
                                    directions.add(directionAndDistance);
                                }
                            } else {
                                direction = "D";
                                distanceBetweenStartAndEndingIndex = 1;
                                directionAndDistance = direction + distanceBetweenStartAndEndingIndex;
                                directions.add(directionAndDistance);
                            }

                            startingIndex = endingIndex;
                        }
                    }
                } else {
                    //else (not first loop):

                    //check if 1 exists in array
                    if (array2d[outerArrayIndex][innerArrayIndex] == 1) {
                        //if 1 exists:
                        //set end position to that index
                        endingIndex = innerArrayIndex;
                        // compare starting & ending index to find out the direction and distance
                            if(startingIndex != endingIndex) {
                                //if starting index > ending index: go left
                                if (startingIndex > endingIndex) {
                                    distanceBetweenStartAndEndingIndex = startingIndex - endingIndex;
                                    direction = "L";
                                }
                                //else ending index > starting index: go right
                                else {
                                    distanceBetweenStartAndEndingIndex = endingIndex - startingIndex;
                                    direction = "R";
                                }
                                //add distance (0-array length) and direction (left/right) to string array
                                directionAndDistance = direction + distanceBetweenStartAndEndingIndex;
                                directions.add(directionAndDistance);

                                //add direction DOWN and distance 1 (D1) to string array - distance between 2 arrays remains constant, D1, you will never go up.
                                direction = "D";
                                distanceBetweenStartAndEndingIndex = 1;
                                directionAndDistance = direction + distanceBetweenStartAndEndingIndex;
                                directions.add(directionAndDistance);

                                //starting position is now the ending position from previous loop
                                startingIndex = endingIndex;
                            } else {
                                if (direction.equals("D")) {
                                    distanceBetweenStartAndEndingIndex++;

                                    // Check if last direction in list starts with "D"
                                    if (!directions.isEmpty() && directions.get(directions.size() - 1).startsWith("D")) {
                                        // Replace the last element
                                        directions.set(directions.size() - 1, direction + distanceBetweenStartAndEndingIndex);
                                    } else {
                                        // Otherwise, just add the new direction
                                        directionAndDistance = direction + distanceBetweenStartAndEndingIndex;
                                        directions.add(directionAndDistance);
                                    }
                                } else {
                                    direction = "D";
                                    distanceBetweenStartAndEndingIndex = 1;
                                    directionAndDistance = direction + distanceBetweenStartAndEndingIndex;
                                    directions.add(directionAndDistance);
                                }

                                startingIndex = endingIndex;
                            }
                        //loop again.

                    }

                    // end check logic
                    if (outerArrayIndex == array2d.length - 1 && innerArrayIndex == array2d[outerArrayIndex].length - 1) {
                        //else (1 does not exist) exit array and ending position is the array length/end of array
                        //compare starting & ending index (end of array) to find out the distance
                        distanceBetweenStartAndEndingIndex = (array2d[outerArrayIndex].length -1)- startingIndex;
                        //add direction RIGHT and distance (0-array length) to string array - distance will always be right for final loop
                        direction = "R";
                        directionAndDistance = direction + distanceBetweenStartAndEndingIndex;
                        directions.add(directionAndDistance);
                    }
                }
            }
        }
        // return string array
        return directions;
    }


}
