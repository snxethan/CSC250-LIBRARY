package NEU.ET39.CSC250;

import NEU.ET39.CSC250.Algorithms.CodeWars;
import NEU.ET39.CSC250.Algorithms.Isomorphs;
import NEU.ET39.CSC250.Algorithms.Recursive;
import NEU.ET39.CSC250.DataStructures.BinarySearchTree;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        sorting();
//        codeWars();
//        recursive();
//        isomorphs();
        dataStructures();
    }

    public static void dataStructures() {
        // Binary Search Tree
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.add(5);
        bst.add(3);
        bst.add(7);
        bst.add(2);
        bst.add(4);
        bst.add(6);
        bst.add(8);
        System.out.println("Binary Search Tree:");
        System.out.println("In-order Traversal: " + bst.inOrderTraversal());
        System.out.println("Pre-order Traversal: " + bst.preOrderTraversal());
        System.out.println("Post-order Traversal: " + bst.postOrderTraversal());
        System.out.println("Level-order Traversal: " + bst.levelOrderTraversal());
        System.out.println("Contains 4: " + bst.contains(4));
    }

    public static void sorting(){
//        Integer[] arr = {5, 2, 9, 1, 5, 6};
        Integer[] arr = {2,3,6,1,2,9,7,6,4,4,2,9,10,11,5,3,12};
//        System.out.println(Arrays.toString(arr));
//        System.out.println(Arrays.toString(Sorter.bubbleSort(arr)));
//        System.out.println(Arrays.toString(Sorter.insertionSort(arr)));
//        System.out.println(Arrays.toString(Sorter.insertionSort2(arr)));
//        System.out.println(Arrays.toString(Sorter.selectionSort(arr)));
//        System.out.println(Arrays.toString(Sorter.mergeSort(arr)));
//        System.out.println(Arrays.toString(Sorter.mergeSort(arr,0,arr.length-1)));
//        System.out.println(Arrays.toString(Sorter.quickSort(arr,0,arr.length-1)));
    }

    public static void codeWars(){

                /*
     carpark = [[1, 0, 0, 0, 2],
                [0, 0, 0, 0, 0]]
      */

//        int[][] carPark = {
//                {1, 0, 0, 0, 2},
//                {0, 0, 0, 1, 0},
//                {1, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0},
//        };
//        int[][] carPark = {
//                {0,1,0,2,0},
//                {0,1,1,1,0},
//                {0,1,0,1,0},
//                {0,1,1,0,0},
//                {0,0,1,0,0},
//        };
        int[][] carPark = {
                {0,1,0,2,0},
                {0,1,0,0,0},
                {0,1,0,0,0},
                {0,1,0,0,0},
                {0,0,0,1,0},
        };

        System.out.println(CodeWars.carPark(carPark));
    }


    public static void recursive(){
        Integer[] arr = {1,2,3,4,5,6,7,8,9};
        System.out.println(Arrays.toString(arr));
        System.out.println(Recursive.BinarySearch(arr,0,arr.length-1,-99));
    }


    public static void isomorphs(){
        String[] isos = {"aaa", "fear", "mates", "gag", "egg", "add", "foo", "sap", "yay", "tot", "look", "meet", "took", "seer", "seep", "ate", "bar", "eat", "fit"};
        System.out.println(Arrays.toString(isos));
        System.out.println(Isomorphs.exactIsomorphs(isos));
        System.out.println(Isomorphs.looseIsomorphs(isos));

    }

}