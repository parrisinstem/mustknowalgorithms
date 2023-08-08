package unionfind;

import java.util.HashMap;
import java.util.Map;

public class Friendship {
    private Map<String, String> parent;
    private Map<String, Integer> size;

    public Friendship() {
        parent = new HashMap<>();
        size = new HashMap<>();
    }

    public void union(String person1, String person2) {
        String rootP = find(person1);
        String rootQ = find(person2);

        if (rootP.equals(rootQ)) {
            return; // Already in the same set
        }

        // Merge the smaller set into the larger set
        if (size.getOrDefault(rootP, 1) < size.getOrDefault(rootQ, 1)) {
            parent.put(rootP, rootQ);
            size.put(rootQ, size.getOrDefault(rootQ, 1) + size.getOrDefault(rootP, 1));
        } else {
            parent.put(rootQ, rootP);
            size.put(rootP, size.getOrDefault(rootP, 1) + size.getOrDefault(rootQ, 1));
        }
    }

    public String find(String person) {
        // Path compression: Update parent pointers to find the root
        if (!parent.containsKey(person)) {
            parent.put(person, person); // Initialize parent for a new person
        }

        if (!parent.get(person).equals(person)) {
            parent.put(person, find(parent.get(person)));
        }

        return parent.get(person);
    }

    public boolean connected(String person1, String person2) {
        return find(person1).equals(find(person2));
    }


    public static void main(String[] args) {
        Friendship socialNetwork = new Friendship();

        // Add connections in the social network
        socialNetwork.union("John", "Alice");
        socialNetwork.union("Alice", "Bob");
        socialNetwork.union("Michael", "David");
        socialNetwork.union("David", "Sarah");
        socialNetwork.union("Sarah", "Emily");

        // Check if two people are connected
        System.out.println("John and Bob are connected: " + socialNetwork.connected("John", "Bob")); // Output: true
        System.out.println("Michael and Emily are connected: " + socialNetwork.connected("Michael", "Emily")); // Output: true
        System.out.println("John and Emily are connected: " + socialNetwork.connected("John", "Emily")); // Output: false
    }

}