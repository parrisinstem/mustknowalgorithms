package dp;

import java.util.*;

public class TSP {
    // Function to find the shortest possible route using dynamic programming
    public List<Integer> findShortestRoute(int[][] dist, int n) {
        // 1 << n is the number of subsets of n cities
        int numSubsets = 1 << n;

        // Create a 2D memoization table to store subproblem solutions
        int[][] dp = new int[numSubsets][n];

        // Initialize the memoization table with maximum values (set as -1)
        for (int[] subArr : dp) {
            Arrays.fill(subArr, -1);
        }

        // Base case: when we have visited only one city, the distance is 0
        for (int i = 0; i < n; i++) {
            dp[1 << i][i] = 0;
        }

        // Iterate through all possible subsets of cities
        for (int subset = 1; subset < numSubsets; subset++) {
            for (int currCity = 0; currCity < n; currCity++) {
                // If the current city is not part of the subset, skip it
                if ((subset & (1 << currCity)) == 0) {
                    continue;
                }

                // Try to visit all other cities in the current subset
                for (int nextCity = 0; nextCity < n; nextCity++) {
                    // If the next city is already visited or not part of the subset, skip it
                    if (currCity == nextCity || (subset & (1 << nextCity)) == 0) {
                        continue;
                    }

                    // Calculate the distance for the current subset and current city
                    int prevSubset = subset ^ (1 << currCity); // Remove current city from the subset
                    if (dp[prevSubset][nextCity] != -1) {
                        int newDistance = dp[prevSubset][nextCity] + dist[nextCity][currCity];
                        if (dp[subset][currCity] == -1 || newDistance < dp[subset][currCity]) {
                            dp[subset][currCity] = newDistance;
                        }
                    }
                }
            }
        }

        // Find the shortest route from the last city back to the starting city (0)
        int minDistance = -1;
        int lastCity = -1;
        for (int i = 0; i < n; i++) {
            if (dp[numSubsets - 1][i] != -1) {
                int totalDistance = dp[numSubsets - 1][i] + dist[i][0];
                if (minDistance == -1 || totalDistance < minDistance) {
                    minDistance = totalDistance;
                    lastCity = i;
                }
            }
        }

        // Reconstruct the shortest route from the memoization table
        List<Integer> shortestRoute = new ArrayList<>();
        int subset = numSubsets - 1;
        while (subset != 0) {
            shortestRoute.add(lastCity);
            int prevSubset = subset ^ (1 << lastCity);
            lastCity = getPrevCity(dp, dist, prevSubset, lastCity);
            subset = prevSubset;
        }
        shortestRoute.add(0); // Add the starting city to complete the route

        // Reverse the route since we added cities in reverse order
        Collections.reverse(shortestRoute);

        return shortestRoute;
    }

    // Function to find the previous city in the shortest route
    private int getPrevCity(int[][] dp, int[][] dist, int subset, int lastCity) {
        int minDistance = -1;
        int prevCity = -1;
        for (int i = 0; i < dp[subset].length; i++) {
            if (dp[subset][i] != -1) {
                int totalDistance = dp[subset][i] + dist[i][lastCity];
                if (minDistance == -1 || totalDistance < minDistance) {
                    minDistance = totalDistance;
                    prevCity = i;
                }
            }
        }
        return prevCity;
    }

    public static void main(String[] args) {
        TSP tspSolver = new TSP();
        int[][] dist = {
            {0, 10, 15, 20},
            {10, 0, 35, 25},
            {15, 35, 0, 30},
            {20, 25, 30, 0}
        };
        int n = dist.length;

        List<Integer> shortestRoute = tspSolver.findShortestRoute(dist, n);
        System.out.println("Shortest Route: " + shortestRoute);
    }
}
