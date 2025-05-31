package NEU.ET39.CSC250.DataStructure.Graph;

/**
 * Represents a row in the Dijkstra's algorithm table.
 * Each row contains information about a vertex, its cost from the source,
 * whether it has been visited, and its previous vertex in the path.
 */
public class DijkstraRow {
    private Vertex parent; // The parent vertex of this row, representing the vertex itself
    private boolean visited; // Indicates if this vertex has been visited in the algorithm
    private int cost; // The cost from the source vertex to this vertex
    private Vertex previous; // The previous vertex in the path from the source to this vertex

    /**
     * Constructs a DijkstraRow with the specified parent vertex and cost.
     *
     * @param parent The parent vertex of this row.
     * @param cost   The cost from the source to this vertex.
     */
    public DijkstraRow(Vertex parent, int cost) {
        setParent(parent);
        setCost(cost);
        setPrevious(null);
        setVisited(false);
    }

    public Vertex getParent() {
        return parent;
    }

    public void setParent(Vertex parent) {
        this.parent = parent;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Vertex getPrevious() {
        return previous;
    }

    public void setPrevious(Vertex previous) {
        this.previous = previous;
    }
}
