# CSC250 Library

A comprehensive Java library implementing various data structures and algorithms for Computer Science 250 coursework. This project demonstrates fundamental computer science concepts including sorting algorithms, graph algorithms, tree data structures, and algorithmic problem solving.

## Features

### Data Structures
- **Trees**: AVL Trees with self-balancing capabilities
- **Graphs**: Graph representation with adjacency lists and vertex management
- **Lists**: Custom list implementations
- **Nodes**: Building blocks for various data structures

### Algorithms
- **Sorting Algorithms**: Bubble Sort, Insertion Sort, Selection Sort, Merge Sort, Quick Sort
- **Graph Algorithms**: 
  - Prim's Algorithm for Minimum Spanning Tree
  - Maze Solving using graph traversal
- **Search Algorithms**: Binary Search (recursive implementation)
- **Pattern Matching**: Isomorph detection (exact and loose matching)
- **Backtracking**: N-Queens problem solver
- **Problem Solving**: CodeWars challenges and recursive solutions

## Prerequisites

- Java 17 or higher
- Maven 3.6 or higher

## Build and Run

### Clone the repository
```bash
git clone https://github.com/snxethan/CSC250-LIBRARY.git
cd CSC250-LIBRARY
```

### Compile the project
```bash
mvn compile
```

### Run the main application
```bash
mvn exec:java -Dexec.mainClass="NEU.ET39.CSC250.Main"
```

### Run tests
```bash
mvn test
```

## Project Structure

```
src/main/java/NEU/ET39/CSC250/
├── Algorithm/
│   ├── Isomorphs.java          # Pattern matching algorithms
│   ├── MazeSolver.java         # Graph-based maze solving
│   ├── NetworkArchitect.java   # Prim's algorithm for MST
│   ├── NQueens.java           # N-Queens backtracking solution
│   ├── Recursive.java         # Recursive algorithm implementations
│   └── Sorter.java            # Various sorting algorithms
├── DataStructure/
│   ├── Graph/                 # Graph implementation
│   ├── List/                  # Custom list structures
│   ├── Node/                  # Node implementations
│   └── Tree/                  # AVL Tree implementation
├── CodeWars.java              # CodeWars challenge solutions
└── Main.java                  # Main application entry point
```

## Usage Examples

### Sorting Algorithms
```java
Integer[] arr = {5, 2, 9, 1, 5, 6};
Integer[] sorted = Sorter.quickSort(arr, 0, arr.length-1);
```

### Graph Operations
```java
String[] adjacencyList = {
    "AX1,AX2,AX3,AX4,AX5",
    "AX1,AX4:3,AX2:3,AX3:6",
    // ... more adjacency definitions
};
Graph graph = new Graph(adjacencyList);
NetworkArchitect architect = new NetworkArchitect();
Graph mst = architect.primsAlgorithm(graph);
```

### AVL Tree
```java
AVLTree<Integer> tree = new AVLTree<>();
tree.add(10);
tree.add(5);
tree.add(15);
System.out.println("Tree height: " + tree.getHeight());
```

## Testing

The project includes comprehensive JUnit tests for all algorithms and data structures:

- Algorithm tests in `src/test/java/Algorithm/`
- Data structure tests in `src/test/java/DataStructure/`

Run specific test suites:
```bash
mvn test -Dtest=PrimsTests
mvn test -Dtest=AVLTreeTest
```

## Algorithms Implemented

### Sorting
- **Bubble Sort**: O(n²) comparison-based sorting
- **Insertion Sort**: O(n²) efficient for small datasets
- **Selection Sort**: O(n²) in-place sorting algorithm
- **Merge Sort**: O(n log n) divide-and-conquer approach
- **Quick Sort**: O(n log n) average case, efficient partitioning

### Graph Algorithms
- **Prim's Algorithm**: Minimum Spanning Tree construction
- **Graph Traversal**: DFS/BFS for maze solving
- **Path Finding**: Shortest path calculations

### Search & Pattern Matching
- **Binary Search**: O(log n) recursive search
- **Isomorph Detection**: Pattern matching for strings

## Learning Objectives

This library demonstrates key computer science concepts:

1. **Time Complexity Analysis**: Understanding Big O notation
2. **Data Structure Design**: Implementing efficient storage solutions
3. **Algorithm Design**: Problem-solving with optimal approaches
4. **Graph Theory**: Network analysis and optimization
5. **Recursive Thinking**: Breaking down complex problems
6. **Testing**: Comprehensive unit test coverage

## Author(s)

- [**Ethan Townsend (snxethan)**](www.ethantownsend.dev)
