package NEU.ET39.CSC250.DataStructure.Graph;

public class Edge {
    private final int weight;
    private Vertex source;
    private Vertex destination;


    public Edge(int weight, Vertex source, Vertex destination) {
        if (source == null || destination == null) {
            throw new IllegalArgumentException("Source and destination vertices cannot be null");
        }
        if(weight < 0) {
            throw new IllegalArgumentException("Weight cannot be negative");
        }
        this.weight = weight;
        this.source = source;
        this.destination = destination;
    }

    public int getWeight() {
        return weight;
    }
    public Vertex getSource() {
        return source;
    }
    public Vertex getDestination() {
        return destination;
    }

    public void setSource(Vertex source) {
        if (source == null) {
            throw new IllegalArgumentException("Source vertex cannot be null");
        }
        this.source = source;
    }

    public void setDestination(Vertex destination) {
        if (destination == null) {
            throw new IllegalArgumentException("Destination vertex cannot be null");
        }
        this.destination = destination;
    }
}
