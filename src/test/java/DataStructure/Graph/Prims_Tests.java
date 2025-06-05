package DataStructure.Graph;

import NEU.ET39.CSC250.Algorithm.NetworkArchitect;
import NEU.ET39.CSC250.DataStructure.Graph.Graph;
import NEU.ET39.CSC250.DataStructure.Graph.Vertex;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.Set;
import java.util.HashSet;

public class Prims_Tests {
    @Test
    public void testSimpleGraphMST() throws Exception {
        String[] adjacencyList = {
                "A,B,C,D",
                "A,B:1,C:3",
                "B,A:1,C:2,D:4",
                "C,A:3,B:2,D:5",
                "D,B:4,C:5"
        };

        Graph graph = new Graph(adjacencyList);
        NetworkArchitect architect = new NetworkArchitect();
        Graph mst = architect.primsAlgorithm(graph);

        String mstString = mst.toString().trim();
        // MST should contain edges: A-B(1), B-C(2), B-D(4) (or equivalent undirected order)
        assertTrue(mstString.contains("A -(1)> B") || mstString.contains("B --(1)--> A"));
        assertTrue(mstString.contains("B -(2)> C") || mstString.contains("C --(2)--> B"));
        assertTrue(mstString.contains("B -(4)> D") || mstString.contains("D --(4)--> B"));
    }

    @Test
    public void testSingleVertexGraph() throws Exception {
        String[] adjacencyList = {
                "A"
        };

        Graph graph = new Graph(adjacencyList);
        NetworkArchitect architect = new NetworkArchitect();
        Graph mst = architect.primsAlgorithm(graph);

        assertEquals(1, mst.getVertices().size());
        assertEquals("A", mst.getVertices().get(0).getValue());
        assertTrue(mst.getVertices().get(0).getEdges().isEmpty());
    }

    @Test
    public void testEmptyGraph() {
        Graph graph = new Graph();
        NetworkArchitect architect = new NetworkArchitect();
        assertThrows(IllegalArgumentException.class, () -> architect.primsAlgorithm(graph));
    }

    @Test
    public void testTotalMSTWeight() throws Exception {
        String[] adjacencyList = {
                "AX1,AX2,AX3,AX4,AX5",
                "AX1,AX4:3,AX2:3,AX3:6",
                "AX2,AX1:3,AX3:3,AX4:6",
                "AX3,AX2:3,AX1:6,AX4:4",
                "AX4,AX1:3,AX2:6,AX3:4,AX5:15",
                "AX5,AX4:15"
        };

        Graph graph = new Graph(adjacencyList);
        NetworkArchitect architect = new NetworkArchitect();
        Graph mst = architect.primsAlgorithm(graph);

        int totalWeight = 0;
        Set<String> seenEdges = new HashSet<>();
        for (var v : mst.getVertices()) {
            for (var e : v.getEdges()) {
                String u = e.getSource().getValue();
                String w = e.getDestination().getValue();
                String key = u.compareTo(w) < 0 ? u + "-" + w : w + "-" + u;
                if (!seenEdges.contains(key)) {
                    seenEdges.add(key);
                    totalWeight += e.getWeight();
                }
            }
        }

        assertEquals(24, totalWeight); // 3 + 3 + 3 + 15
    }


    @Test
    public void testCalculatedPathLength() throws Exception {
        String[] adjacencyList = {
                "AX1,AX2,AX3,AX4,AX5",
                "AX1,AX4:3,AX2:3,AX3:6",
                "AX2,AX1:3,AX3:3,AX4:6",
                "AX3,AX2:3,AX1:6,AX4:4",
                "AX4,AX1:3,AX2:6,AX3:4,AX5:15",
                "AX5,AX4:15"
        };

        Graph graph = new Graph(adjacencyList);
        NetworkArchitect architect = new NetworkArchitect();
        Graph mst = architect.primsAlgorithm(graph);

        Vertex startVertex = mst.findVertexByData("AX1");
        Vertex endVertex = mst.findVertexByData("AX5");

        int pathLength = architect.calculatePathCableLength(mst, startVertex, endVertex);
        assertEquals(18, pathLength); // Path AX1 -> AX4 -> AX5
    }

    @Test
    public void testTotalCableLength() throws Exception {
        String[] adjacencyList = {
                "AX1,AX2,AX3,AX4,AX5",
                "AX1,AX4:3,AX2:3,AX3:6",
                "AX2,AX1:3,AX3:3,AX4:6",
                "AX3,AX2:3,AX1:6,AX4:4",
                "AX4,AX1:3,AX2:6,AX3:4,AX5:15",
                "AX5,AX4:15"
        };

        Graph graph = new Graph(adjacencyList);
        NetworkArchitect architect = new NetworkArchitect();
        Graph mst = architect.primsAlgorithm(graph);

        Vertex startVertex = mst.findVertexByData("AX1");
        Vertex endVertex = mst.findVertexByData("AX5");

        int totalLength = architect.calculateTotalCableLength(mst, startVertex, endVertex);
        assertEquals(24, totalLength); // Total length of MST edges
    }
}