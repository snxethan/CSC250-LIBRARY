package NEU.ET39.CSC250;

import NEU.ET39.CSC250.Algorithm.*;
import NEU.ET39.CSC250.DataStructure.Graph.Graph;
import NEU.ET39.CSC250.DataStructure.Graph.Vertex;
import NEU.ET39.CSC250.DataStructure.Tree.AVLTree;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
//        sorting();
//        codeWars();
//        recursive();
//        isomorphs();
//        dataStructures();
        graphs();
    }


    public static void graphs() throws Exception {
        MazeSolver mazeSolver = new MazeSolver();
        NetworkArchitect prims = new NetworkArchitect();
        //"AX1,AX4:3,AX2:3,AX3:6"
        //"AX2,AX1:3,AX3:3,AX4:6",
        //"AX3,AX2:3,AX1:6,AX4:4",
        //"AX4,AX1:3,AX2:6,AX3:4,AX5:15",
        //"AX5,AX4:15"
        String[] adjacencyList = {
                "AX1,AX2,AX3,AX4,AX5",
                "AX1,AX4:3,AX2:3,AX3:6",
                "AX2,AX1:3,AX3:3,AX4:6",
                "AX3,AX2:3,AX1:6,AX4:4",
                "AX4,AX1:3,AX2:6,AX3:4,AX5:15",
                "AX5,AX4:15"
        };
        Graph graph = new Graph(adjacencyList);
//        mazeSolver.solveMaze(graph, "AX1", "AX5");
        Graph solvedGraph = prims.primsAlgorithm(graph);
        System.out.println("Minimum Spanning Tree:\n" + solvedGraph);
        Vertex startVertex = solvedGraph.findVertexByData("AX1");
        Vertex endVertex = solvedGraph.findVertexByData("AX5");
        System.out.println("Total Length: " + prims.calculateTotalCableLength(solvedGraph, startVertex, endVertex));
        System.out.println("Path Length from AX1 to AX5: " + prims.calculatePathCableLength(solvedGraph, startVertex, endVertex));
    }

    public static void dataStructures() {
//         Binary Search Tree
        AVLTree<Integer> bst = new AVLTree<>();
        bst.add(10);
        bst.add(5);
        bst.add(15);
        bst.add(3);
        bst.add(7);
        bst.add(13);
        bst.add(17);
        bst.add(18);
        System.out.println("Binary Search Tree:");
        System.out.println("Count: " + bst.getCount());
        System.out.println("Contains 7: " + bst.contains(7));
        System.out.println("Contains 20: " + bst.contains(20));
        System.out.println("To Array: " + Arrays.toString(bst.toArray()));
        bst.remove(7);
        System.out.println("After removing 7:");
        System.out.println("Count: " + bst.getCount());
        System.out.println("Contains 7: " + bst.contains(7));

        System.out.println("In-order Traversal: " + bst.inOrder());
        System.out.println("Pre-order Traversal: " + bst.preOrder());
        System.out.println("Post-order Traversal: " + bst.postOrder());
        System.out.println("To Array: " + Arrays.toString(bst.toArray()));
        System.out.println("Height: " + bst.getHeight());

//         AVL Tree
        AVLTree<Integer> avl = new AVLTree<>();

        avl.add(1);
        avl.add(2);
        avl.add(4);
        avl.add(3);

        System.out.println("Binary Search Tree:");
        System.out.println("To Array: " + Arrays.toString(avl.toArray()));
        System.out.println("Count: " + avl.getCount());
        System.out.println("Height: " + avl.getHeight());
        System.out.println("Contains 3: " + avl.contains(3));
        System.out.println("Contains 5: " + avl.contains(5));
        avl.remove(3);
        System.out.println("After removing 3:");
        System.out.println("To Array: " + Arrays.toString(avl.toArray()));
        System.out.println("Count: " + avl.getCount());
        System.out.println("Height: " + avl.getHeight());
        System.out.println("Contains 3: " + avl.contains(3));

    }

    public static void sorting(){
//        Integer[] arr = {5, 2, 9, 1, 5, 6};
        Integer[] arr = {2,3,6,1,2,9,7,6,4,4,2,9,10,11,5,3,12};
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(Sorter.bubbleSort(arr)));
        System.out.println(Arrays.toString(Sorter.insertionSort(arr)));
        System.out.println(Arrays.toString(Sorter.insertionSort2(arr)));
        System.out.println(Arrays.toString(Sorter.selectionSort(arr)));
        System.out.println(Arrays.toString(Sorter.mergeSort(arr)));
        System.out.println(Arrays.toString(Sorter.quickSort(arr,0,arr.length-1)));
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