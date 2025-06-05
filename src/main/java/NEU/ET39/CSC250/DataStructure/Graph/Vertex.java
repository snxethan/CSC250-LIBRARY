package NEU.ET39.CSC250.DataStructure.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Represents a vertex in a graph.
 * Each vertex has a value and can have multiple edges connecting it to other vertices.
 */
public class Vertex {
    private final String value; // The value of the vertex, must not be null or empty
    private List<Edge> edges = new ArrayList<>(); // The edges connected to this vertex, must not be null or contain null values


    /**
     * Constructs a Vertex with the specified value.
     *
     * @param value the value of the vertex, must not be null or empty
     * @throws IllegalArgumentException if the value is null or empty
     */
    public Vertex(String value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException("Vertex value cannot be null or empty");
        }
        this.value = value;
    }


    public String getValue() {
        return value;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void setEdges(List<Edge> edges) {
        if (edges == null) {
            throw new IllegalArgumentException("Edges cannot be null");
        }
        if (edges.contains(null)) {
            throw new IllegalArgumentException("Edges cannot contain null values");
        }
        for (Edge edge : edges) {
            if (edge == null) {
                throw new IllegalArgumentException("Edges cannot contain null values");
            }
            if (edge.getSource() != this && edge.getDestination() != this) {
                throw new IllegalArgumentException("Edge must connect to this vertex");
            }
        }
        this.edges = new ArrayList<>(edges);
    }

    public void removeAllEdges() {
        this.edges.clear();
    }

    public void addEdge(Edge edge) {
        if (edge == null) {
            throw new IllegalArgumentException("Edge cannot be null");
        }
        if (edge.getSource() != this && edge.getDestination() != this) {
            throw new IllegalArgumentException("Edge must connect to this vertex");
        }
        edges.add(edge);
    }
}
