package NEU.ET39.CSC250.Algorithm;

import NEU.ET39.CSC250.DataStructure.Graph.DijkstraRow;
import NEU.ET39.CSC250.DataStructure.Graph.Edge;
import NEU.ET39.CSC250.DataStructure.Graph.Graph;
import NEU.ET39.CSC250.DataStructure.Graph.Vertex;

import java.util.ArrayList;
import java.util.List;

/**
 * MazeSolver class implements Dijkstra's algorithm to find the shortest path in a maze represented as a graph.
 * It uses a table (dTable) to keep track of the cost, visited status, and previous vertex for each vertex in the graph.
 */
public class MazeSolver {
    private final List<DijkstraRow> dTable = new ArrayList<>(); // The table to store Dijkstra's rows for each vertex in the graph

    /**
     * Solves the maze using Dijkstra's algorithm.
     *
     * @param graph The graph representing the maze.
     * @param start The starting vertex data.
     * @param end   The ending vertex data.
     * @return A string representing the shortest path from start to end, or an empty string if no path exists.
     */
    public String solveMaze(Graph graph, String start, String end) {
        //Pick a random vertex
        Vertex randomVertex = graph.findVertexByData(start); // Start vertex
        if (randomVertex == null) {
            throw new IllegalArgumentException("Start vertex not found in the graph");
        }

        // Initialize the dTable and loop through all vertices
        for (Vertex v : graph.getVertices()) {
            int cost = Integer.MAX_VALUE; // Default cost for unvisited vertices (infinity)
            if (v == randomVertex){
                cost = 0; // if this is the start node, set cost to 0
            }
            DijkstraRow row = new DijkstraRow(v, cost); // Create a new DijkstraRow for each vertex
            dTable.add(row); // Add it to the dTable


            //Generate a dRow for each vertex in the graph
            // -- Set parent equal to that vertex
            // -- Set visited to false
            // -- Set cost = 0 for startNode, otherwise cost = int32.Max
            // -- Set previous to null
        }


        //LOOP (B)
        while(!allVerticesVisited()){
            //Pick the dRow with the lowest "cost" (Until all vertex are visited)
            DijkstraRow currentRow = getLowestCostRow();
            if (currentRow == null) {
                break; // No more unvisited rows
            }
            //Set that dRow.Visited = true;
            currentRow.setVisited(true);
            //LOOP (A) (for all edges that are unvisited
            for(Edge edge : currentRow.getParent().getEdges()){
                //Look at ALL unvisited edges leaving that node
                Vertex lookingAtNode = edge.getDestination(); // The vertex we are looking at
                //Find the dRow for that vertex
                DijkstraRow lookingAtNodeDRow = findDijkstraRowByVertex(lookingAtNode);
                if (lookingAtNodeDRow == null || lookingAtNodeDRow.isVisited()) {
                    continue; // If the dRow is null or already visited, skip
                }
                //If(edgeWeight + current dRow.cost < lookingAtNode.dRowCost
                int newCost = currentRow.getCost() + edge.getWeight();
                if (newCost < lookingAtNodeDRow.getCost()) {
                    //-- update lookingAtNode.dRowCost
                    lookingAtNodeDRow.setCost(newCost);
                    //reconstruct the path
                    lookingAtNodeDRow.setPrevious(currentRow.getParent());
                }
                //ENDLOOP (A)
            }
            //ENDLOOP(B)
        }

        //Find the answer
        List<Vertex> shortestPath = new ArrayList<>();
        //Start at end node, work your way back to start node
        Vertex current = graph.findVertexByData(end);
        DijkstraRow endRow = findDijkstraRowByVertex(current);
        if (endRow == null || (endRow.getCost() == Integer.MAX_VALUE && !start.equals(end))) {
            return ""; // No solution if end vertex is unreachable
        }
        //If there is NO path back to start node, FAIL (No solution)
        while (current != null) {
            shortestPath.add(0, current); // Add to the front of the list to reverse the order
            DijkstraRow currentRow = findDijkstraRowByVertex(current);
            if (currentRow == null || currentRow.getPrevious() == null) {
                break; // No previous vertex, stop
            }
            current = currentRow.getPrevious(); // Move to the previous vertex
        }
        StringBuilder toReturn = new StringBuilder();
        for (Vertex v : shortestPath) {
            toReturn.append(v.getValue()).append(" ");
        }
        return toReturn.toString();
    }

    /**
     * Finds the DijkstraRow corresponding to a given vertex.
     *
     * @param v The vertex to find in the dTable.
     * @return The DijkstraRow associated with the vertex, or null if not found.
     */
    private DijkstraRow findDijkstraRowByVertex(Vertex v) {
        for (DijkstraRow row : dTable) {
            if (row.getParent() == v) return row;
        }
        return null;
    }


    /**
     * Gets the DijkstraRow with the lowest cost that has not been visited.
     *
     * @return The DijkstraRow with the lowest cost, or null if all rows are visited.
     */
    private DijkstraRow getLowestCostRow() {
        DijkstraRow lowest = null;
        for (DijkstraRow dr : dTable) {
            if (!dr.isVisited()) {
                if (lowest == null || dr.getCost() < lowest.getCost()) {
                    lowest = dr;
                }
            }
        }
        return lowest;
    }

    //checks if every vertex is true in vertices
    /**
     * Checks if all vertices in the dTable have been visited.
     *
     * @return true if all vertices are visited, false otherwise.
     */
    private boolean allVerticesVisited() {
        //iterate over dTable
        for (DijkstraRow dr : dTable){
            //if one vertex is not visited, return false
            if(!dr.isVisited()){
                return false;
            }
        }
        //if iteration ends without a false, return true
        return true;
    }



}
