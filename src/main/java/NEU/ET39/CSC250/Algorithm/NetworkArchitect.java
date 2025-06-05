package NEU.ET39.CSC250.Algorithm;

import NEU.ET39.CSC250.DataStructure.Graph.Edge;
import NEU.ET39.CSC250.DataStructure.Graph.Graph;
import NEU.ET39.CSC250.DataStructure.Graph.Vertex;

import java.util.HashSet;
import java.util.Set;

public class NetworkArchitect {


    /**
     * Implements Prim's algorithm to find the minimum spanning tree (MST) of a given graph.
     * The algorithm starts from an arbitrary vertex and grows the MST by adding the lowest-weight edge
     * that connects a visited vertex to an unvisited vertex until all vertices are included.
     *
     * BigO Complexity: O(E log V) where E is the number of edges and V is the number of vertices.
     * This is because we are using a priority queue to efficiently find the minimum edge.
     *
     * @param graph the input graph from which to find the MST
     * @return a new graph representing the minimum spanning tree
     */
    public Graph primsAlgorithm(Graph graph) {
        if (graph == null || graph.getVertices().isEmpty()) {
            throw new IllegalArgumentException("Graph cannot be null or empty");
        } else if (graph.getVertices().size() == 1) {
            Graph mst = new Graph();
            mst.addVertex(new Vertex(graph.getVertices().get(0).getValue()));
            return mst;
        }

        Graph mst = new Graph(); // Create a new MST graph
        Set<Vertex> visited = new HashSet<>(); // Track visited vertices
        Vertex startVertex = graph.getVertices().get(0); // Start with first vertex
        visited.add(startVertex);

        // Add a copy of the start vertex to the MST
        mst.addVertex(new Vertex(startVertex.getValue()));
        Set<Edge> addedEdges = new HashSet<>();



        // Visit each vertex once > V iterations
        //
        //In each iteration, look at all edges from visited nodes
        //
        //Over the whole algorithm, total edge checks = O(E)

        // the big O is (V*E) or n^2,
        // worst case on dense graphs where every vertex is connected to every other vertex:
        // O(V^3)
        // Loop as long as there are unvisited vertices
        while (visited.size() < graph.getVertices().size()) { // Outer loop runs at most O(V) times (once per vertex)
            Edge lowestEdge = null;
            Vertex fromVertex = null;

            // Search all edges from visited vertices to unvisited ones
            for (Vertex v : visited) { // This loop runs up to O(V) times (for each visited vertex)

                for (Edge e : v.getEdges()) {
                    // Each visited vertex may have edges to all other vertices in dense graphs
                    // So across all iterations, the total number of edges examined is O(E)
                    // Inner loop over edges: Total across entire algorithm is O(E)


                    // Check if the edge's destination is not visited
                    if (!visited.contains(e.getDestination())) {
                        // if its not visited, check if it's the lowest edge
                        if (lowestEdge == null || e.getWeight() < lowestEdge.getWeight()) {
                            lowestEdge = e; // Update the lowest edge
                            fromVertex = v; // Update the vertex from which the edge originates

                        }
                    }
                }
            }


            if (lowestEdge == null) break; // if no edge found, exit the loop as all vertices are visited

            // Add the lowest edge to the MST
            Vertex toVertex = lowestEdge.getDestination();
            visited.add(toVertex); // Mark the destination vertex as visited

            // Ensure both vertices exist in the MST graph
            if (mst.findVertexByData(fromVertex.getValue()) == null) {
                mst.addVertex(new Vertex(fromVertex.getValue()));
            }
            if (mst.findVertexByData(toVertex.getValue()) == null) {
                mst.addVertex(new Vertex(toVertex.getValue()));
            }

            // Get actual MST vertex objects
            Vertex mstFrom = mst.findVertexByData(fromVertex.getValue());
            Vertex mstTo = mst.findVertexByData(toVertex.getValue());

            if (!addedEdges.contains(lowestEdge) && !mstFrom.equals(mstTo)) {
                Edge newEdge = new Edge(lowestEdge.getWeight(), mstFrom, mstTo);
                mstFrom.addEdge(newEdge);
                mstTo.addEdge(newEdge);
                addedEdges.add(newEdge);
            }
        }

        // Return the minimum spanning tree/
        return mst;
    }


    // Once your MST is generated, calculate the smallest amount of cable required to span the distance.

    /**
     * Calculates the total cable length required to connect two vertices in the minimum spanning tree (MST).
     * This method traverses the MST and sums the weights of the edges that connect the specified vertices.
     *
     * BigO Complexity: O(V + E) where V is the number of vertices and E is the number of edges in the MST.
     * @param mst the minimum spanning tree graph
     * @param fromVertex the starting vertex from which to calculate the cable length
     * @param toVertex the ending vertex to which to calculate the cable length
     * @return the total cable length required to connect the two vertices
     */
    public int calculateTotalCableLength(Graph mst, Vertex fromVertex, Vertex toVertex) {
        if (mst == null || mst.getVertices().isEmpty()) {
            throw new IllegalArgumentException("MST cannot be null or empty");
        }
        if (fromVertex == null || toVertex == null) {
            throw new IllegalArgumentException("From and To vertices cannot be null");
        }

        int totalLength = 0;
        Set<Edge> visitedEdges = new HashSet<>();
        for (Vertex v : mst.getVertices()) {
            for (Edge e : v.getEdges()) {
                if (visitedEdges.add(e)) { // Add returns false if the edge is already in the set
                    totalLength += e.getWeight();
                }
            }
        }

        return totalLength;
    }

    /**
     * Calculates the length of the path cable between two vertices in the minimum spanning tree (MST).
     * This method uses a depth-first search (DFS) approach to find the path and sum the weights of the edges.
     * BigO Complexity: O(V + E) where V is the number of vertices and E is the number of edges in the MST.
     *
     * @param mst the minimum spanning tree graph
     * @param fromVertex the starting vertex from which to calculate the cable length
     * @param toVertex the ending vertex to which to calculate the cable length
     * @return the total cable length along the path between the two vertices
     */
    public int calculatePathCableLength(Graph mst, Vertex fromVertex, Vertex toVertex) {
        if (mst == null || mst.getVertices().isEmpty()) {
            throw new IllegalArgumentException("MST cannot be null or empty");
        }
        if (fromVertex == null || toVertex == null) {
            throw new IllegalArgumentException("From and To vertices cannot be null");
        }

        Set<Vertex> visited = new HashSet<>();
        return dfsPathLength(fromVertex, toVertex, visited, 0);
    }

    private int dfsPathLength(Vertex current, Vertex target, Set<Vertex> visited, int currentLength) {
        if (current.equals(target)) {
            return currentLength; // Found the target vertex
        }

        visited.add(current);
        int minLength = Integer.MAX_VALUE;

        for (Edge edge : current.getEdges()) {
            Vertex next = edge.getDestination();
            if (!visited.contains(next)) {
                int pathLength = dfsPathLength(next, target, visited, currentLength + edge.getWeight());
                if (pathLength != Integer.MAX_VALUE) {
                    minLength = Math.min(minLength, pathLength);
                }
            }
        }

        visited.remove(current); // Backtrack
        return minLength;
    }
}

// Prim’s algorithm grows a tree from one node, always adding the cheapest edge that connects a visited node to an unvisited one, until all vertices are connected.
//function PrimMST(graph):
//    Initialize MST = empty set
//    Initialize visited = empty set
//    Pick an arbitrary start vertex and add it to visited
//
//    while number of visited vertices < total vertices:
//        Find the smallest edge (u, v) such that:
//            - u is in visited
//            - v is not in visited
//        Add edge (u, v) to MST
//        Add vertex v to visited
//
//    return MST



//    public Graph primsAlgorithm(Graph graph) {
//        // Implementation of Prim's algorithm for finding the minimum spanning tree
//        // This method will be implemented later
//
//        if (graph == null || graph.getVertices().isEmpty()) {
//            throw new IllegalArgumentException("Graph cannot be null or empty");
//        }
//
//        Graph mst = new Graph(); // Create a new graph for the minimum spanning tree
//        Vertex currentVertex = graph.getVertices().get(0); // Get the first vertex in the graph
//
//        // loop through all vertices in the graph
//        while(!allVerticesVisited(graph)){
//            int lowestCost = Integer.MAX_VALUE; // Initialize lowest cost to maximum value
//            Edge lowestCurrentEdge = null; // Initialize edge to null
//            // get the lowest cost edge from the current vertex
//            for (Edge edge : currentVertex.getEdges()
//            ) {
//                // if the edge is not visited
//                if(edge.getWeight() < lowestCost) {
//                    // check if the edge's weight is less than the lowest cost found so far
//                    // and if the edge's destination vertex is not visited
//                    lowestCost = edge.getWeight(); // Update the lowest cost
//                    lowestCurrentEdge = edge; // Update the lowest current edge
//                }
//            }
//            // if the lowest current edge is not null
//            if (lowestCurrentEdge != null) {
//                Vertex newVertex = currentVertex;
//                newVertex.removeAllEdges();
//                // add the lowest current edge to the vertex
//                newVertex.addEdge(lowestCurrentEdge); // Add the lowest current edge to the vertex
//                // set the vertex within the graph to visited
//                for (Vertex v : graph.getVertices()) {
//                    if (v.getValue().equals(currentVertex.getValue())) {
//                        v.setVisited(true); // Mark the vertex as visited in the graph
//                        break;
//                    }
//                }
//                currentVertex = lowestCurrentEdge.getDestination(); // Move to the destination vertex of the lowest current edge
//                if(currentVertex.isVisited()){
//                    // If the current vertex is already visited, we need to find another vertex that is not visited yet
//                    for (Vertex v : graph.getVertices()) {
//                        if (!v.isVisited()) {
//                            currentVertex = v; // Set the current vertex to the first unvisited vertex
//                            break; // Exit the loop once we find an unvisited vertex
//                        }
//                        // If all vertices are visited, we can exit the loop
//                    }
//                } else {
//                    // add the new vertex to the minimum spanning tree
//                    mst.addVertex(newVertex); // Add the current vertex to the minimum spanning tree
//                    mst.addEdgeToVertex(newVertex, lowestCurrentEdge); // Add the lowest current edge to the minimum spanning tree
//                }
//            } else {
//                break; // No more edges to process, exit the loop
//            }
//        }
//        return mst;
//    }

