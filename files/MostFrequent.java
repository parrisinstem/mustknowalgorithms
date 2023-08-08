package files;

import java.util.HashMap;
import java.util.Map;

public class MostFrequent {
    public static String findMostFrequentIP(String[] logs) {
        // Create a HashMap to store the count of each IP address.
        Map<String, Integer> ipCountMap = new HashMap<>();
        
        // Iterate through the logs and update the count for each IP address.
        for (String log : logs) {
            // Split the log into parts (assuming IP address is the first part).
            String[] parts = log.split(" ");
            String ipAddress = parts[0];
            
            // Update the count in the HashMap.
            ipCountMap.put(ipAddress, ipCountMap.getOrDefault(ipAddress, 0) + 1);
        }
        
        // Find the IP address with the highest count.
        String mostFrequentIP = null;
        int maxCount = 0;
        for (String ipAddress : ipCountMap.keySet()) {
            int count = ipCountMap.get(ipAddress);
            if (count > maxCount) {
                mostFrequentIP = ipAddress;
                maxCount = count;
            }
        }
        
        return mostFrequentIP;
    }

    // Example usage:
    public static void main(String[] args) {
        String[] logs = {
            "192.168.1.1 - user1 [30/Jul/2023:10:00:01]",
            "192.168.1.2 - user2 [30/Jul/2023:10:00:02]",
            "192.168.1.1 - user3 [30/Jul/2023:10:00:03]",
            "192.168.1.1 - user4 [30/Jul/2023:10:00:04]",
            "192.168.1.3 - user5 [30/Jul/2023:10:00:05]",
            "192.168.1.2 - user6 [30/Jul/2023:10:00:06]"
        };
        
        String mostFrequentIP = findMostFrequentIP(logs);
        System.out.println("IP with most logs: " + mostFrequentIP); // Output: IP with most logs: 192.168.1.1
    }
}
