package DataStructure.Graph;

import NEU.ET39.CSC250.Algorithm.MazeSolver;
import NEU.ET39.CSC250.DataStructure.Graph.Graph;


public class MazeSolver_Tests {
    @org.junit.jupiter.api.Test
    void solveMazeFindsShortestPathInComplexGraph() throws Exception {
        String[] adjacencyList = {
                "AX1,AX2,AX3,AX4,AX5",
                "AX1,AX4:3,AX2:3,AX3:6",
                "AX2,AX1:3,AX3:3,AX4:6",
                "AX3,AX2:3,AX1:6,AX4:4",
                "AX4,AX1:3,AX2:6,AX3:4,AX5:15",
                "AX5,AX4:15"
        };
        Graph graph = new Graph(adjacencyList);
        MazeSolver solver = new MazeSolver();
        String result = solver.solveMaze(graph, "AX1", "AX5");
        org.junit.jupiter.api.Assertions.assertEquals("AX1 AX4 AX5 ", result);
    }

    @org.junit.jupiter.api.Test
    void solveMazeReturnsEmptyStringWhenNoPathExists() throws Exception {
        String[] adjacencyList = {
                "AX1,AX2,AX3,AX4,AX5",
                "AX1,AX2:1",
                "AX2,AX1:1",
                "AX3",
                "AX4",
                "AX5"
        };
        Graph graph = new Graph(adjacencyList);
        MazeSolver solver = new MazeSolver();
        String result = solver.solveMaze(graph, "AX1", "AX5");
        org.junit.jupiter.api.Assertions.assertEquals("", result);
    }

    @org.junit.jupiter.api.Test
    void solveMazeThrowsWhenStartVertexMissing() throws Exception {
        String[] adjacencyList = {
                "AX1,AX2,AX3,AX4,AX5",
                "AX1,AX2:1",
                "AX2,AX1:1",
                "AX3",
                "AX4",
                "AX5"
        };
        Graph graph = new Graph(adjacencyList);
        MazeSolver solver = new MazeSolver();
        org.junit.jupiter.api.Assertions.assertThrows(IllegalArgumentException.class, () -> solver.solveMaze(graph, "AX0", "AX5"));
    }

    @org.junit.jupiter.api.Test
    void solveMazeReturnsSingleVertexPathWhenStartEqualsEnd() throws Exception {
        String[] adjacencyList = {
                "AX1,AX2,AX3,AX4,AX5",
                "AX1,AX2:1",
                "AX2,AX1:1",
                "AX3",
                "AX4",
                "AX5"
        };
        Graph graph = new Graph(adjacencyList);
        MazeSolver solver = new MazeSolver();
        String result = solver.solveMaze(graph, "AX3", "AX3");
        org.junit.jupiter.api.Assertions.assertEquals("AX3 ", result);
    }


    @org.junit.jupiter.api.Test
    void solveMazeHandlesDisconnectedGraph() throws Exception {
        String[] adjacencyList = {
                "AX1,AX2,AX3",
                "AX1,AX2:1",
                "AX2,AX1:1",
                "AX3"
        };
        Graph graph = new Graph(adjacencyList);
        MazeSolver solver = new MazeSolver();
        String result = solver.solveMaze(graph, "AX1", "AX3");
        org.junit.jupiter.api.Assertions.assertEquals("", result);
    }


    @org.junit.jupiter.api.Test
    void solveMazeHandlesGraphWithMultiplePaths() throws Exception {
        String[] adjacencyList = {
                "AX1,AX2,AX3,AX4",
                "AX1,AX2:1,AX3:2",
                "AX2,AX1:1,AX4:3",
                "AX3,AX1:2,AX4:1",
                "AX4,AX2:3,AX3:1"
        };
        Graph graph = new Graph(adjacencyList);
        MazeSolver solver = new MazeSolver();
        String result = solver.solveMaze(graph, "AX1", "AX4");
        org.junit.jupiter.api.Assertions.assertEquals("AX1 AX3 AX4 ", result);
    }

    @org.junit.jupiter.api.Test
    void solveMazeHandlesGraphWithCycles() throws Exception {
        String[] adjacencyList = {
                "AX1,AX2,AX3",
                "AX1,AX2:1,AX3:4",
                "AX2,AX1:1,AX3:1",
                "AX3,AX1:4,AX2:1"
        };
        Graph graph = new Graph(adjacencyList);
        MazeSolver solver = new MazeSolver();
        String result = solver.solveMaze(graph, "AX1", "AX3");
        org.junit.jupiter.api.Assertions.assertEquals("AX1 AX2 AX3 ", result);
    }

    @org.junit.jupiter.api.Test
    void solveMazeHandlesGraphWithDeadEnds() throws Exception {
        String[] adjacencyList = {
                "AX1,AX2,AX3,AX4",
                "AX1,AX2:1",
                "AX2,AX1:1,AX3:2",
                "AX3,AX2:2,AX4:3",
                "AX4,AX3:3"
        };
        Graph graph = new Graph(adjacencyList);
        MazeSolver solver = new MazeSolver();
        String result = solver.solveMaze(graph, "AX1", "AX4");
        org.junit.jupiter.api.Assertions.assertEquals("AX1 AX2 AX3 AX4 ", result);
    }

    @org.junit.jupiter.api.Test
    void solveMazeHandlesGraphsWithInfiniteLoops() throws Exception {
        String[] adjacencyList = {
                "AX1,AX2,AX3",
                "AX1,AX2:1",
                "AX2,AX1:1,AX3:1",
                "AX3,AX2:1"
        };
        Graph graph = new Graph(adjacencyList);
        MazeSolver solver = new MazeSolver();
        String result = solver.solveMaze(graph, "AX1", "AX3");
        org.junit.jupiter.api.Assertions.assertEquals("AX1 AX2 AX3 ", result);
    }
}