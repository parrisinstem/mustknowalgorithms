// Import necessary libraries for the 'bfs' package
package bfs;

// Import required Java utility classes
import java.util.*;

// Class to implement Dijkstra's algorithm for finding the shortest path in a weighted graph
public class DijkstraAlgorithm {

    // Inner class representing a vertex in the graph
    static class Vertex implements Comparable<Vertex> {
        int id;       // The unique identifier of the vertex
        int distance; // The distance from the source vertex

        // Constructor for creating a Vertex with an id and distance
        public Vertex(int id, int distance) {
            this.id = id;
            this.distance = distance;
        }

        // Implementation of the compareTo method for comparison during priority queue operations
        @Override
        public int compareTo(Vertex other) {
            return Integer.compare(this.distance, other.distance);
        }
    }

    // Method to perform Dijkstra's algorithm on the given graph with a specified source vertex
    public static void dijkstra(int[][] graph, int source) {
        int numVertices = graph.length;
        int[] distances = new int[numVertices];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[source] = 0; // Distance from the source to itself is 0

        // Create a priority queue to maintain the vertices with their distances
        PriorityQueue<Vertex> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(new Vertex(source, 0)); // Add the source vertex to the priority queue

        // Perform Dijkstra's algorithm
        while (!priorityQueue.isEmpty()) {
            Vertex currentVertex = priorityQueue.poll();
            int currentId = currentVertex.id;

            // Explore the neighbors of the current vertex
            for (int neighborId = 0; neighborId < numVertices; neighborId++) {
                int edgeWeight = graph[currentId][neighborId];
                if (edgeWeight != 0) {
                    int alternativeDistance = distances[currentId] + edgeWeight;
                    if (alternativeDistance < distances[neighborId]) {
                        // Found a shorter path to the neighbor
                        distances[neighborId] = alternativeDistance;
                        priorityQueue.offer(new Vertex(neighborId, distances[neighborId]));
                    }
                }
            }
        }

        // Print the shortest distances from the source to all other vertices
        System.out.println("Shortest distances from source " + source + " to all vertices:");
        for (int i = 0; i < numVertices; i++) {
            System.out.println("Vertex " + i + ": " + distances[i]);
        }
    }

    // Main method to test the Dijkstra's algorithm
    public static void main(String[] args) {
        // Define the graph as a 2D array representing the weighted adjacency matrix
        int[][] graph = {
            {0, 4, 0, 0, 0, 0, 0, 8, 0},
            {4, 0, 8, 0, 0, 0, 0, 11, 0},
            {0, 8, 0, 7, 0, 4, 0, 0, 2},
            {0, 0, 7, 0, 9, 14, 0, 0, 0},
            {0, 0, 0, 9, 0, 10, 0, 0, 0},
            {0, 0, 4, 14, 10, 0, 2, 0, 0},
            {0, 0, 0, 0, 0, 2, 0, 1, 6},
            {8, 11, 0, 0, 0, 0, 1, 0, 7},
            {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };

        int source = 0; // Source vertex

        // Call the dijkstra method to find the shortest distances from the source to all vertices
        dijkstra(graph, source);
    }
}
