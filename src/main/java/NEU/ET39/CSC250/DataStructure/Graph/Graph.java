package NEU.ET39.CSC250.DataStructure.Graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a graph using an adjacency list.
 * The graph is constructed from a given adjacency list, where the first line contains the vertices
 * and subsequent lines contain edges with weights.
 */
public class Graph {
    public List<Vertex> vertices = new ArrayList<>();

    /**
     * Constructs a Graph from an adjacency list.
     * The first line of the adjacency list contains the vertices, and subsequent lines contain edges.
     *
     * @param adjacencyList an array of strings representing the adjacency list
     * @throws Exception if the adjacency list is invalid
     */
    public Graph(String[] adjacencyList) throws Exception {
        //"AX1,AX4:3,AX2:3,AX3:6"
        //"AX2,AX1:3,AX3:3,AX4:6",
        //"AX3,AX2:3,AX1:6,AX4:4",
        //"AX4,AX1:3,AX2:6,AX3:4,AX5:15",
        //"AX5,AX4:15"

        for (int i = 0; i < adjacencyList.length; i++) {
            if(i == 0){
                // Create vertices
                String verticesLine = adjacencyList[i];
                String[] vertices = verticesLine.split(",");
                //AX1,AX2,AX3,AX4,AX5
                for(String vertex : vertices){
                    Vertex newVertex = new Vertex(vertex);
                    this.vertices.add(newVertex);
                }
            } else {
                // Creating Edges
                //"AX1,AX4:3,AX2:3,AX3:6"
                String[] edgeParts = adjacencyList[i].split(",");
                //[AX1] ["AX4:3"]

                String startData = edgeParts[0]; //ax1
                for (int j = 1; j < edgeParts.length; j++) {
                    String[] endEdgeParts = edgeParts[j].split(":");
                    String endData = endEdgeParts[0];
                    int weight = Integer.parseInt(endEdgeParts[1]);

                    Vertex startVertex = findVertexByData(startData);
                    Vertex endVertex = findVertexByData(endData);
                    if (startVertex == null || endVertex == null) {
                        throw new Exception("Invalid Adjacency List");
                    }

                    Edge newEdge = new Edge(weight, startVertex, endVertex);
                    startVertex.getEdges().add(newEdge);
                }
            }
        }
    }
    /**
     * Finds a vertex in the vertex collection and returns it
     * @param value vertex to be returned
     * @return
     */
    public Vertex findVertexByData(String value){
        for(Vertex v : vertices){
            if(v.getValue().equals(value)){
                return v;
            }
        }
        return null;
    }

    public List<Vertex> getVertices() {
        return vertices;
    }

    public void setVertices(List<Vertex> vertices) {
        this.vertices = vertices;
    }



}
